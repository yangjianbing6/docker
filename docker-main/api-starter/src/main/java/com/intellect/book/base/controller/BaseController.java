package com.intellect.book.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.intellect.book.base.entity.ResponseEntity;
import com.intellect.book.base.enums.ResponseCodeEnum;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2018-11-23 12:56:26
 **/
public class BaseController {


    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected static Map<String, Object> javaBean2Map(Object entity) {
        String json = JSON.toJSONString(entity);

        JSONObject jsonObject = JSON.parseObject(json);
        return jsonObject.toJavaObject(Map.class);
    }

    protected Object jsonMsg(boolean isSuccess, String code, String msg, Object data) {
        return ImmutableMap.of("success", isSuccess,
                "code", code,
                "msg", msg,
                "data", data == null ? Collections.emptyMap() : data
        );
    }

    protected Object jsonMsg(boolean isSuccess, int code, String msg, Object data) {
        return ImmutableMap.of("success", isSuccess,
                "code", code,
                "msg", msg,
                "data", data == null ? Collections.emptyMap() : data
        );
    }

    protected Object successResponse(Object data) {
        return jsonMsg(true, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getContent(), data);
    }

    protected Object unSuccessResponse(ResponseCodeEnum response) {
        return jsonMsg(false, response.getCode(), response.getContent(), Collections.emptyMap());
    }

    protected Object unSuccessResponse(String message) {
        return jsonMsg(false, ResponseCodeEnum.PROMPT.getCode(), message, Collections.emptyMap());
    }

    protected Object unSuccessResponse(ResponseEntity responseEntity) {
        return jsonMsg(responseEntity.getError(), responseEntity.getCode(), responseEntity.getContent(), Collections.emptyMap());
    }


    /**
     * 分页设置
     *
     * @param offset
     * @param limit
     * @return
     */
    protected RowBounds getRowRounds(Integer offset, Integer limit) {

        if (offset >= 1) {
            offset = (offset - 1) * limit;
        }

        return new RowBounds(offset, limit);

    }

    protected Integer getOffset(Integer pageNo, Integer limit) {
        int offset = 0;
        if (pageNo >= 1) {
            offset = (pageNo - 1) * limit;
        }

        return offset;

    }


}
