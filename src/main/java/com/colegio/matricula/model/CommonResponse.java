package com.colegio.matricula.model;

public class CommonResponse {

    private String code;


    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public CommonResponse() {
    }


    public CommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String toString() {
        return "CommonResponse{" + "code='" + code + '\'' + ", message='" + message + '\'' + '}';
    }
}
