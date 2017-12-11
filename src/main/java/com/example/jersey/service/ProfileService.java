package com.example.jersey.service;

import com.example.jersey.database.DatabaseClass;
import com.example.jersey.modal.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {
    private Map<String,Profile> profiles  = DatabaseClass.getProfiles();

    public ProfileService(){
        profiles.put("natay",new Profile(1L,"natay","nataay","atay"));
    }
    public List<Profile> getAllProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String  profileName){
        return profiles.get(profileName);
    }
    public Profile addProfile(Profile profile){
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }
    public Profile upDateProfile(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }
    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }


}
