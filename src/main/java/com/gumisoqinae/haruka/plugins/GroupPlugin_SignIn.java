package com.gumisoqinae.haruka.plugins;

import com.gumisoqinae.haruka.entity.SignInMember;
import lombok.extern.slf4j.Slf4j;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static com.gumisoqinae.haruka.common.HarukaCommon.groupSignedMap;

@Slf4j
@Component
public class GroupPlugin_SignIn extends BotPlugin {

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {

        SignInMember member;

        //  签到
        if(event.getRawMessage().equals("签到")) {

//            Map<Long, SignInMember> groupSignedMemberMap = new HashMap<>();

            //  查询是否存在【以当前群ID为KEY】的内部map
            if(groupSignedMap.containsKey(event.getGroupId())) {

                //  存在签到群号key，先取出对应key-map
                Map<Long, SignInMember> currentGroupSignInMember = groupSignedMap.get(event.getGroupId());
                if(currentGroupSignInMember.containsKey(event.getUserId())) {
                    //  存在群友key
//                    bot.sendGroupMsg(event.getGroupId(), "已经签到过了~", false);
                    System.out.println("已经签到过了~");
                } else {
                    //  不存在群友key
//                    bot.sendGroupMsg(event.getGroupId(), "签到收到了~", false);
                    System.out.println("签到收到了~");
                    member = new SignInMember(event.getGroupId(), event.getUserId(), event.getSender().getNickname());
                    currentGroupSignInMember.put(event.getUserId(), member);
                }
            } else {
                //  不存在签到群号，将当前群加入key-map
                //  先构建
                Map<Long, SignInMember> newSignedMemberMap = new HashMap<>();
                newSignedMemberMap.put(event.getUserId(), new SignInMember(event.getGroupId(), event.getUserId(), event.getSender().getNickname()));
                //  再把当前群加入key-map
                groupSignedMap.put(event.getGroupId(), newSignedMemberMap);
//                bot.sendGroupMsg(event.getGroupId(), "你是本群首位签到者！签到收到了~", false);
                System.out.println("你是本群首位签到者！签到收到了~");


            }


        }

//        if(event.getRawMessage().equals("签到")) {
//            if(signedSetUser.containsKey(event.getUserId())) {
//                //  存在
//                bot.sendGroupMsg(event.getGroupId(), "已经签到过了~", false);
//            } else {
//                //  不存在
//
//
//                signedSetUser.put(event.getUserId(), member);
//            }
//        } else if(event.getRawMessage().equals("签到取消")) {
//            if(signedSetUser.containsKey(event.getUserId())) {
//                //  存在
//                signedSetUser.remove(event.getUserId());
//                bot.sendGroupMsg(event.getGroupId(), "已经从签到表里把尼移除了~", false);
//            } else {
//                //  不存在
//                bot.sendGroupMsg(event.getGroupId(), "咱在签到表里没找到你~", false);
//            }
//        }
//
//        if(event.getRawMessage().equals("查询签到")) {
//            if (signedSetUser != null) {
//                bot.sendGroupMsg(event.getGroupId(), "签到情况如下" + signedSetUser.toString(), false);
//                bot.sendGroupPoke(event.getGroupId(), event.getUserId());
//            } else {
//                bot.sendGroupMsg(event.getGroupId(), "签到表为空或者暂时没有人签到", false);
//            }
//        }
//
//        if(event.getRawMessage().equals("清空签到")) {
//            signedSetUser = null;
//            bot.sendGroupMsg(event.getGroupId(), "签到表已经清空", false);
//        }

        return super.onGroupMessage(bot, event);
    }
}
