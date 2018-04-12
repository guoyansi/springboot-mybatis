package com.springbootmybatis.demo.exceptiion;

public class MyException extends RuntimeException {
    private Integer status;
    public MyException(Integer status,String message) {
        super(message);
        this.status=status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
