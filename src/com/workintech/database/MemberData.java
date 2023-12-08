package com.workintech.database;

import com.workintech.user.Member;
import com.workintech.user.User;

import java.util.HashMap;
import java.util.Map;

public class MemberData {
    private  Map<Integer, User> members = new HashMap<>();
    public final Map<Integer, User> Members(){
        User member = new Member("Gülbeyaz Özer", "glbzbayram@gmail.com", "505 555 55 55");
        User member1 = new Member("Maya Özer", "maya@gmail.com", "515 555 55 55");
        User member2 = new Member("Mehmet Özer", "mehmet@gmail.com", "525 555 55 55");
        User member3 = new Member("Bahar Bayram", "bahar@gmail.com", "535 555 55 55");
        User member4 = new Member("Arife Gökçeoğlu", "arife@gmail.com", "545 555 55 55");
        User member5 = new Member("Beren Bayram", "beren@gmail.com", "555 555 55 55");
        User member6 = new Member("Melisa Bayram", "melisa@gmail.com", "565 555 55 55");
        User member7 = new Member("Tomi Özer", "tomi@gmail.com", "575 555 55 55");
        User member8 = new Member("Azra Özer", "azra@gmail.com", "585 555 55 55");

        members.put(0,member);
        members.put(1,member1);
        members.put(2,member2);
        members.put(3,member3);
        members.put(4,member4);
        members.put(5,member5);
        members.put(6,member6);
        members.put(7,member7);
        members.put(8,member8);
        return members;
    }
}
