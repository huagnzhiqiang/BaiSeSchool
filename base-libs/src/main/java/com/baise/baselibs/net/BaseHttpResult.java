package com.baise.baselibs.net;

import java.io.Serializable;

/**
 * @author 小强
 * @time 2018/6/12 00:58
 * @desc 抽取的一个基类的bean, 直接在泛型中传data就行
 */
public class BaseHttpResult<T> implements Serializable {
    private static final long serialVersionUID = 2690553609250007325L;
    public static final int SUCCESS_CODE = 200;

    private T data;

    private int code; // 200
    private String message;//成功
    private String remark;//成功


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseHttpResult{" + "data=" + data + ", code=" + code + ", message='" + message + '\'' + ", remark='" + remark + '\'' + '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 正常返回
     */
    public boolean isOk() {
        if (code == SUCCESS_CODE)
            return true;
        return false;
    }

}