package com.baise.school.data.entity;

/**
 * @author 小强
 * @time 2018/12/5  16:11
 * @desc
 */
public class MsgBean {


    /**
     * code : 100000
     * text : 我就装傻让你教我好不
     */

    private int code;
    private String text;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MsgBean{" + "code=" + code + ", text='" + text + '\'' + '}';
    }
}
