package com.example.jersey.database;

//import com.example.jersey.modal.Message;
import com.example.jersey.modal.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    //private static Map<Long,Message> messages=new HashMap<>();
    private static Map<String,Profile> profiles=new HashMap<>();

   /* public static Map<Long,Message> getMessages(){
        return messages;
    }
*/
    public static Map<String, Profile> getProfiles(){
        return profiles;
    }
}