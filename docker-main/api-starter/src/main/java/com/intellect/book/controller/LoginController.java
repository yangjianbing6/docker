package com.intellect.book.controller;

import com.google.common.collect.Maps;
import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.token.Action;
import com.intellect.book.base.token.Constant;
import com.intellect.book.base.token.Token;
import com.intellect.book.base.token.service.TokenService;
import com.intellect.book.domain.entity.DictEmployee;
import com.intellect.book.domain.entity.DictOrgAuth;
import com.intellect.book.domain.request.DoctorDTO;
import com.intellect.book.domain.request.LoginPasswordDTO;
import com.intellect.book.domain.request.LoginPersonIdDTO;
import com.intellect.book.service.DictEmployeeService;
import com.intellect.book.service.DictOrgAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by yangjianbing
 * 登录接口
 *
 * @date 2019/8/10 16:01
 */
@Api(description = "登录接口")
@RestController
@RequestMapping(value = "/main/login")
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    DictEmployeeService dictEmployeeService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    DictOrgAuthService dictOrgAuthService;

    /**
     * 登录
     *
     * @return
     */
    @ApiOperation("根据用户名密码登录")
    @PostMapping("/by_password")
    @Token(action = Action.SKIP)
    public Object loginByPassword(@RequestBody LoginPasswordDTO loginPasswordDTO) {
        if (loginPasswordDTO == null || Strings.isNullOrEmpty(loginPasswordDTO.getLoginName())) {
            return unSuccessResponse("参数异常");
        }
        DictEmployee param = new DictEmployee();

        param.setLoginName(loginPasswordDTO.getLoginName());
        param.setPassword(loginPasswordDTO.getPassword());

        DictEmployee dictEmployee = dictEmployeeService.selectOne(param);

        if (dictEmployee == null) {
            return unSuccessResponse("账号密码不正确");
        }

        boolean checkAuth = this.checkAuth(dictEmployee.getEmpID(), loginPasswordDTO.getAppid(), loginPasswordDTO.getAppkey());
        if (!checkAuth) {
            return unSuccessResponse("AppKey未授权");
        }

        Map<String, Object> result = Maps.newHashMap();
        convert(result, dictEmployee);

        return successResponse(result);
    }

    /**
     * 登录
     *
     * @return
     */
    @ApiOperation("根据医生用户在健康海淀app中的ID登录")
    @PostMapping("/app_user_id")
    @Token(action = Action.SKIP)
    public Object loginBypersonId(@RequestBody LoginPersonIdDTO loginPersonIdDTO) {
        if (loginPersonIdDTO == null || Strings.isNullOrEmpty(loginPersonIdDTO.getAppUserID())) {
            return unSuccessResponse("参数异常");
        }
        DictEmployee param = new DictEmployee();
        param.setAppUserID(loginPersonIdDTO.getAppUserID());

        DictEmployee dictEmployee = dictEmployeeService.selectOne(param);

        if (dictEmployee == null) {
            return unSuccessResponse("没有该医生的AppID");
        }

        boolean checkAuth = this.checkAuth(dictEmployee.getEmpID(), loginPersonIdDTO.getAppid(), loginPersonIdDTO.getAppkey());
        if (!checkAuth) {
            return unSuccessResponse("AppKey未授权");
        }

        Map<String, Object> result = Maps.newHashMap();
        convert(result, dictEmployee);

        return successResponse(result);
    }


    /**
     * 新增海淀app医生用户
     *
     * @return
     */
    @ApiOperation("新增海淀app医生用户")
    @PostMapping("/save_doctor")
    @Token(action = Action.SKIP)
    public Object saveDoctor(@RequestBody DoctorDTO doctorDTO) {
        if (doctorDTO == null
                || Strings.isNullOrEmpty(doctorDTO.getDoctorid())
                || Strings.isNullOrEmpty(doctorDTO.getAppid())
                || Strings.isNullOrEmpty(doctorDTO.getAppkey())) {
            return unSuccessResponse("参数异常");
        }

        try {
            //先判断appid 和appkey 是否存在，获取orgId
            //保存医生数据到employee表中
            DictOrgAuth param = new DictOrgAuth();
            param.setAppid(doctorDTO.getAppid());
            param.setAppkey(doctorDTO.getAppkey());
            DictOrgAuth dictOrgAuth = dictOrgAuthService.selectOne(param);
            if (dictOrgAuth == null) {
                return unSuccessResponse("APP未授权");
            }

            dictOrgAuthService.saveDoctorInfo(doctorDTO, dictOrgAuth.getOrgId());

            return successResponse("保存成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return unSuccessResponse("保存失败");
        }


    }

    /**
     * 数据转换
     *
     * @param result
     * @param dictEmployee
     */
    private void convert(Map<String, Object> result, DictEmployee dictEmployee) {
        //复制token
        String token = tokenService.generateToken(dictEmployee);
        result.put(Constant.TOKEN, token);

        result.put("docker", dictEmployee);
    }

    /**
     * 检查是否授权
     *
     * @param empId
     * @param appId
     * @param appKey
     * @return
     */
    private boolean checkAuth(String empId, String appId, String appKey) {
        if (Strings.isNullOrEmpty(appId) || Strings.isNullOrEmpty(appKey)) {
            return false;
        }
        DictOrgAuth param1 = new DictOrgAuth();
        param1.setAppid(appId);
        param1.setAppkey(appKey);
        DictOrgAuth dictOrgAuth = dictOrgAuthService.selectOne(param1);

        if (dictOrgAuth == null) {
            return false;
        }


        List<String> orgIds = dictOrgAuthService.getOrgIdByEmpId(empId);

        if (CollectionUtils.isEmpty(orgIds)) {
            return false;
        }

        if (orgIds.contains(dictOrgAuth.getOrgId())) {
            return true;
        }


        return false;
    }
}
