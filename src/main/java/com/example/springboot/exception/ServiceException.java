package com.example.springboot.exception;

import lombok.Getter;

/**
 * @version 1.0
 * @author： xiaoxu
 * @date： 2022-12-04 09:01
 */

@Getter
public class ServiceException extends RuntimeException {
    private String code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }

}
