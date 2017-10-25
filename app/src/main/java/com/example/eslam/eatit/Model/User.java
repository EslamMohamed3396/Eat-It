package com.example.eslam.eatit.Model;

/**
 * Created by Eslam on 10/18/2017.
 */

public class User {
    private String Name;
    private String Password;

    public User() {
    }

    public User(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
