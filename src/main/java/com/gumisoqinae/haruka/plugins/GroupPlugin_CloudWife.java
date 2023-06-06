package com.gumisoqinae.haruka.plugins;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class GroupPlugin_CloudWife extends BotPlugin {

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {

        if(event.getRawMessage().contains("测试老婆")) {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            bot.sendGroupMsg(event.getGroupId(), "测试老婆成功于"+format.format((date)), false);
        }

        return super.onGroupMessage(bot, event);
    }
}
