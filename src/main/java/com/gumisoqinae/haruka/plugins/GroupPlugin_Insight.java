package com.gumisoqinae.haruka.plugins;

import lombok.extern.slf4j.Slf4j;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import onebot.OnebotApi;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GroupPlugin_Insight extends BotPlugin {

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {

        if(event.getRawMessage().equals("查询群员")) {
            OnebotApi.GetGroupMemberListResp s = bot.getGroupMemberList(event.getGroupId());
            if(s!=null) {
                List<OnebotApi.GetGroupMemberListResp.GroupMember> s2 = s.getGroupMemberList();
                bot.sendGroupMsg(event.getGroupId(), s2.toString().substring(0, 1000).replaceAll("\\\\", "-"), false);
            }else {
                bot.sendGroupMsg(event.getGroupId(), "bot.getGroupMemberList(event.getGroupId())为空，查询失败", false);
            }
        }

        return super.onGroupMessage(bot, event);
    }
}
