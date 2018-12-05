package com.baise.school.data.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author 小强
 * @time 2018/12/5  14:26
 * @desc 聊天实体类
 */
public class MsmEntity implements MultiItemEntity {

    private String content;
    private String time;
    private int type;


    public MsmEntity() {

    }

    public MsmEntity(String content, String time, int type) {
        this.content = content;
        this.time = time;
        this.type = type;
    }



    public String getContent() {
        return content;
    }

    public MsmEntity setContent(String content) {
        this.content = content;

        return this;
    }


    public String getTime() {
        return time;
    }

    public MsmEntity setTime(String time) {
        this.time = time;
        return this;

    }


    public MsmEntity setType(int type) {
        this.type = type;
        return this;

    }

    @Override
    public int getItemType() {
        return type;
    }
}
