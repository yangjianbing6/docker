package com.intellect.book.controller;

import com.google.common.collect.Maps;
import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.token.Token;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by yangjianbing
 * 七牛接口
 *
 * @date 2019/8/10 16:01
 */
@Api(description = "七牛接口")
@RestController
@RequestMapping(value = "/main/qiniu")
@Slf4j
public class QiniuController extends BaseController {

    /**
     * 获取七牛云存储token
     *
     * @return
     */
    @GetMapping(value = "/token")
    @Token
    @ApiOperation("获取七牛token")
    @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",
            paramType = "header")
    public Object qiNiuToken() {
        Config.ACCESS_KEY = "gQykg29uKGwsTeEI-L-Lfooq9MjTRVE96fbd_hns";
        Config.SECRET_KEY = "OCY5MhVGwF-MhpdqHOHMzHcYdWLHrjvrlL6PFvO9";
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);

        // 请确保该bucket已经存在
        String bucketName = "picture-of-prescription";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        try {
            String upToken = putPolicy.token(mac);
            Map<String, Object> result = Maps.newHashMap();
            result.put("qiniuToken", upToken);

            return successResponse(result);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return unSuccessResponse("查询失败");
        }

    }
}