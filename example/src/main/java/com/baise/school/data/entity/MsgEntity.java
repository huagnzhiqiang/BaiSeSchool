package com.baise.school.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author 小强
 * @time 2018/12/15  15:48
 * @desc 聊天信息实体类
 */
@Entity
public class MsgEntity {

    @Id(autoincrement = true)
    private Long id;//id
    private String fromUser;//发送者
    private String toUser;//接收者
    private int type;//1表发送的消息，2表接收的消息
    private String content;//信息内容
    private String date;//时间
    private String isReaded;//是否已读
    private String jsoninfo;//


    public MsgEntity() {
    }


    @Generated(hash = 36709577)
    public MsgEntity(Long id, String fromUser, String toUser, int type, String content, String date, String isReaded, String jsoninfo) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.type = type;
        this.content = content;
        this.date = date;
        this.isReaded = isReaded;
        this.jsoninfo = jsoninfo;
    }


    public Long getMsgId() {
        return this.id;
    }

    public void setMsgId(Long msgId) {
        this.id = msgId;
    }

    public String getFromUser() {
        return this.fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return this.toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsReaded() {
        return this.isReaded;
    }

    public void setIsReaded(String isReaded) {
        this.isReaded = isReaded;
    }

    public String getJsoninfo() {
        return this.jsoninfo;
    }

    public void setJsoninfo(String jsoninfo) {
        this.jsoninfo = jsoninfo;
    }

    @Override
    public String toString() {
        return "MsgEntity{" + "msgId=" + id + ", fromUser='" + fromUser + '\'' + ", toUser='" + toUser + '\'' + ", type='" + type + '\'' + ", content='" + content + '\'' + ", isComing=" + ", date='" + date + '\'' + ", isReaded='" + isReaded + '\'' + ", jsoninfo='" + jsoninfo + '\'' + '}';
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
