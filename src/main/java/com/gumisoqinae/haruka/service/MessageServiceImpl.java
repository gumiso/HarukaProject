package com.gumisoqinae.haruka.service;

import com.gumisoqinae.haruka.entity.GroupMessage;
import com.gumisoqinae.haruka.entity.PrivateMessage;
import com.gumisoqinae.haruka.repository.GroupMessageRepository;
import com.gumisoqinae.haruka.repository.PrivateMessageRepository;
import lombok.extern.slf4j.Slf4j;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageServiceImpl implements IMessageService{

//    String rawMessageLimited;

    private PrivateMessageRepository privateMessageRepository;
    private GroupMessageRepository groupMessageRepository;

    @Autowired
    public void setPrivateMessageRepository(PrivateMessageRepository privateMessageRepository) {
        this.privateMessageRepository = privateMessageRepository;
    }

    @Autowired
    public void setGroupMessageRepository(GroupMessageRepository groupMessageRepository) {
        this.groupMessageRepository = groupMessageRepository;
    }

    @Override
    public void savePrivateMessage(@NotNull OnebotEvent.PrivateMessageEvent event) {

//        rawMessageLimited = "";
        if(event.getRawMessage().length() > 250) {
            log.warn("侦测到PrivateMessage - rawMessage原始数据长度超出可存储范围");
//            rawMessageLimited = event.getRawMessage().substring(0,249);
//            rawMessageLimited = rawMessageLimited + "...";
        }
        privateMessageRepository.save(new PrivateMessage(event.getTime(), event.getMessageType(), event.getUserId(), event.getSender().getNickname(), event.getRawMessage()));

    }

    @Override
    public void saveGroupMessage(@NotNull OnebotEvent.GroupMessageEvent event) {
//        rawMessageLimited = "";
        if(event.getRawMessage().length() > 250) {
            log.warn("侦测到GroupMessage - rawMessage原始数据长度超出可存储范围");
//            rawMessageLimited = event.getRawMessage().substring(0,249);
//            rawMessageLimited = rawMessageLimited + "...";
        }
        groupMessageRepository.save(new GroupMessage(event.getTime(), event.getMessageType(), event.getGroupId(), event.getUserId(), event.getSender().getNickname(), event.getRawMessage()));
    }
}
