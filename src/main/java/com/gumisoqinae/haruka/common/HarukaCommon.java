package com.gumisoqinae.haruka.common;

import com.gumisoqinae.haruka.entity.SignInMember;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HarukaCommon {

    public static Set<Long> signedSetUserID = new HashSet<>();

//    public static Map<Long, SignInMember> groupSignedMemberMap = new HashMap<>();

    public static Map<Long, Map<Long, SignInMember>> groupSignedMap = new HashMap<>();



}
