package com.gumisoqinae.haruka.service;

import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;

public interface IMessageService {

    public void savePrivateMessage(@NotNull OnebotEvent.PrivateMessageEvent event);

    public void saveGroupMessage(@NotNull OnebotEvent.GroupMessageEvent event);

}
