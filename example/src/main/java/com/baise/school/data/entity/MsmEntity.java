package com.baise.school.data.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * @author 小强
 * @time 2018/12/5  14:26
 * @desc 聊天实体类
 */

@Entity
public class MsmEntity implements MultiItemEntity {

    @Id(autoincrement = true)
    private Long id;

    private String content;
    private String time;
    private int type;


    @Generated(hash = 1246576065)
    public MsmEntity(Long id, String content, String time, int type) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.type = type;
    }

    @Generated(hash = 1558061011)
    public MsmEntity() {
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


    public int getType() {
        return this.type;
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
