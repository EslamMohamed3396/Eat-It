package com.example.eslam.eatit.Model;

/**
 * Created by Eslam on 10/19/2017.
 */

public class Category {
    private String Name;
    private String Image;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Category() {

    }

    public Category(String name, String image) {

        Name = name;
        Image = image;
    }
}
