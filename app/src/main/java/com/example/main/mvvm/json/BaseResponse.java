package com.example.main.mvvm.json;

public class BaseResponse<T> {
    private int retcode;
    private String error;
    private T data;

    public int getRetcode() {
        return retcode;
    }

    public String getError() {
        return error;
    }

    public T getData() {
        return data;
    }
}