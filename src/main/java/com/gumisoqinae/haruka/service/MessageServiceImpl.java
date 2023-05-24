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

        privateMessageRepository.save(new PrivateMessage(event.getTime(), event.getMessageType(), event.getUserId(), event.getSender().getNickname(), event.getRawMessage()));

    }

    @Override
    public void saveGroupMessage(@NotNull OnebotEvent.GroupMessageEvent event) {
        groupMessageRepository.save(new GroupMessage(event.getTime(), event.getMessageType(), event.getGroupId(), event.getUserId(), event.getSender().getNickname(), event.getRawMessage()));
    }
}
