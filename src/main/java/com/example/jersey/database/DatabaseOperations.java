package com.example.jersey.database;

import com.example.jersey.modal.Profile;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseOperations {

    public DatabaseOperations(){}

    public static void addProfileToDatabase( Profile profile){
        Connection con = DatabaseConnection.getInstance().getCon();
        String query="Insert Into profile (name,firstname,lastname,created) Values(?,?,?,current_timestamp)";
        try {
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1,profile.getProfileName());
            preparedStatement.setString(2,profile.getFirstName());
            preparedStatement.setString(3,profile.getLastName());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConnection.getInstance().closeCon();
    }

    public static ArrayList<Profile> getAllProfileFromDatabase(){
        Connection con = DatabaseConnection.getInstance().getCon();
        ArrayList<Profile> profiles = new ArrayList<Profile>();
        String query="SELECT id,name,firstname,lastname,created FROM profile";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Profile profile = new Profile();
                profile.setId(rs.getInt(1));
                profile.setProfileName(rs.getString(2));
                profile.setFirstName(rs.getString(3));
                profile.setLastName(rs.getString(4));
                profile.setCreated(rs.getDate(5));
                profiles.add(profile);
            }
            rs.close();
            preparedStatement.close();
            DatabaseConnection.getInstance().closeCon();
            return profiles;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Profile getProfileFromDatabase(String userName){
        Connection con = DatabaseConnection.getInstance().getCon();
        String query="SELECT id,name,firstname,lastname,created FROM profile WHERE name='"+userName+"'";
        Profile profile = new Profile();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                profile.setId(rs.getInt(1));
                profile.setProfileName(rs.getString(2));
                profile.setFirstName(rs.getString(3));
                profile.setLastName(rs.getString(4));
                profile.setCreated(rs.getDate(5));
            }
            rs.close();
            preparedStatement.close();
            DatabaseConnection.getInstance().closeCon();
            return profile;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void removeProfileFromDatabase(String userName) {
        Connection con = DatabaseConnection.getInstance().getCon();
        String query = "DELETE FROM profile WHERE  name='" + userName + "'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConnection.getInstance().closeCon();
    }

    public static void updateProfileFromDatabase(String userName, Profile profile) {
        Connection con = DatabaseConnection.getInstance().getCon();
        String query = "UPDATE profile SET firstname=?, lastname=? WHERE name='" + userName + "'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, profile.getFirstName());
            preparedStatement.setString(2, profile.getLastName());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DatabaseConnection.getInstance().closeCon();
    }
}
