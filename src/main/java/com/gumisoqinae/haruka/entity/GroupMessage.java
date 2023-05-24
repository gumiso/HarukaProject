package com.gumisoqinae.haruka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "tb_messagerecord_group")
public class GroupMessage {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "timestamp")
    private Long timestamp;

    @Column(name = "messageType")
    private String messageType;

    @Column(name = "groupID")
    private Long groupID;

    @Column(name = "userID")
    private Long userID;

    @Column(name = "userNickname")
    private String senderNickname;

    @Column(name = "rawMessage")
    private String rawMessage;

    public String getUuid() {
        return uuid;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getSenderNickname() {
        return senderNickname;
    }

    public void setSenderNickname(String senderNickname) {
        this.senderNickname = senderNickname;
    }

    public String getRawMessage() {
        return rawMessage;
    }

    public void setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public GroupMessage() {
        setUuid();
    }

    public GroupMessage(Long timestamp, String messageType, Long groupID, Long userID, String senderNickname, String rawMessage) {
        setUuid();
        this.timestamp = timestamp;
        this.messageType = messageType;
        this.groupID = groupID;
        this.userID = userID;
        this.senderNickname = senderNickname;
        this.rawMessage = rawMessage;
    }
}
