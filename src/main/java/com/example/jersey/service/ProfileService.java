package com.example.jersey.service;

import com.example.jersey.database.DatabaseOperations;
import com.example.jersey.modal.Profile;
import java.util.ArrayList;
import java.util.List;

public class ProfileService {

    public List<Profile> getAllProfiles(){
        return new ArrayList<Profile>(DatabaseOperations.getAllProfileFromDatabase());
    }

    public Profile getProfile(String  profileName){
        return DatabaseOperations.getProfileFromDatabase(profileName);
    }

    public Profile addProfile(Profile profile){
        DatabaseOperations.addProfileToDatabase(profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        DatabaseOperations.updateProfileFromDatabase(profile.getProfileName(),profile);
        return profile;
    }

    public void removeProfile(String profileName){
        DatabaseOperations.removeProfileFromDatabase(profileName);
    }
}
