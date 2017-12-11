package com.example.jersey.resources;

import com.example.jersey.modal.Profile;
import com.example.jersey.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Profiles {

    private ProfileService profileService=new ProfileService();

    @GET
    public List<Profile> getProfile() {
        return profileService.getAllProfiles();
    }

    @POST

    public Profile addProfile(Profile profile){
        return profileService.addProfile(profile);
    }

    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName ,Profile profile){
        profile.setProfileName(profileName);
        return profileService.upDateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public void deleteProfile(@PathParam("profileName") String profileName){
        profileService.removeProfile(profileName);
    }

    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName){
        return profileService.getProfile(profileName);
    }
}
