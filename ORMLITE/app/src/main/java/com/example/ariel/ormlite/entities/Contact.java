package com.example.ariel.ormlite.entities;
import com.j256.ormlite.field.DatabaseField;
import java.io.Serializable;
public class Contact implements Serializable {
    @DatabaseField(generatedId = true,columnName = "contact_id")
    public int contactid;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "phone")
    private String phone;
    @DatabaseField(columnName = "email")
    private String email;

    public Contact(){}

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getContactid() {
        return contactid;
    }

    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
