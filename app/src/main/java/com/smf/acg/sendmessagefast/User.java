package com.smf.acg.sendmessagefast;

import com.google.gson.Gson;

public class User {
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String json) {
        Gson gson = new Gson();
        User people = gson.fromJson(json, User.class);
        name = people.name;
        surname = people.surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
