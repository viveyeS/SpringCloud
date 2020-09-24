package com.viveye.common.util;

import lombok.Data;

import java.io.Serializable;

/**
 * ResponseResult
 *
 * @author Sssp
 * @date 2020/8/12 15:12
 */
@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求结果对象
     **/
    private T data;
    /**
     * 请求结果的状态码
     **/
    private int code;
    /**
     * 请求结果的文本消息
     **/
    private String message;

    /**
     * 具体错误信息
     */
    private Object detail;

    public ResponseResult(){

    }

    public ResponseResult(String message) {
        this.message = message;
    }

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public ResponseResult(T data, int code, String message, String detail) {
        this.data = data;
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    public ResponseResult(int code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.detail = object;
    }

}
