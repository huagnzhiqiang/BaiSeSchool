package com.baise.baselibs.Bean;

import java.io.Serializable;

/**
 * @author 小强
 * @time 2018/7/17  16:36
 * @desc 用于传递eventBus广播数据
 */
public class MessageEvent implements Serializable {

    public String tag;//eventbus标签，用来区分

    public Object result;//eventbus 传递的结果

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public MessageEvent(){

    }
    public MessageEvent(String tag){
        setTag(tag);
        setResult("");
    }

    public MessageEvent(String tag,Object result){
        setTag(tag);
        setResult(result);
    }

}
