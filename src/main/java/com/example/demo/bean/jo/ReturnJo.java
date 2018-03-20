package com.example.demo.bean.jo;


public class ReturnJo {
    private boolean status;
    private String msg;
    private int code;
    private Object data;


    public ReturnJo(boolean status, String msg, int code, Object data) {
        this.status = status;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
