package com.gumisoqinae.haruka.entity;

import java.util.Date;

public class SignInMember {

    private long groupID;
    private long userID;
    private String nickName;
    private Long timestamp;

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public SignInMember(long groupID, long userID, String nickName) {
        this.groupID = groupID;
        this.userID = userID;
        this.nickName = nickName;
        this.timestamp = new Date().getTime();
    }
}
