package com.smf.acg.sendmessagefast;

import com.google.gson.Gson;

public class Address {

    private String address;
    private String number;
    private String postalCode;
    private String location;


    public Address(String address, String number, String postalCode, String location) {
        this.address = address;
        this.number = number;
        this.postalCode = postalCode;
        this.location = location;

    }

    public Address(String json) {
        Gson gson = new Gson();
        Address addr = gson.fromJson(json, Address.class);
        address = addr.address;
        number = addr.number;
        postalCode = addr.postalCode;
        location = addr.location;

    }



    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getLocation() {
        return location;
    }
    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
