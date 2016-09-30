package com.example.telebook.Contacts.view;

/**
 * Created by Iket on 8/20/2016.
 */
public class ContactsData {

    private String name;
    private String desig;
    private String phone;
    private String image;

    public ContactsData(String name, String desig, String phone, String image) {
        this.name = name;
        this.desig = desig;
        this.phone = phone;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDesig() {
        return desig;
    }

    public String getPhone() {
        return phone;
    }

    public String getImage() {
        return image;
    }
}
