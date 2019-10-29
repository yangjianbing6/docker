package com.intellect.book.base.entity;

import lombok.Data;

@Data
public class ResponseEntity<T> {

    private Boolean error = true;
    private Integer code = 1;
    private String content = "接口调用成功";
    private T result;
}
