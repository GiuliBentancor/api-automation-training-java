package models.responses;

import models.requests.AdopterModel;

public class AdopterResponse {
    private Integer id;
    private String name;
    private String last_Name;
    private String date_Of_Birth;
    private String phone;
    private String address;
    private AdopterModel adopter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return last_Name;
    }

    public void setLastName(String lastName) {
        this.last_Name = lastName;
    }

    public String getDateOfBirth() {
        return date_Of_Birth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.date_Of_Birth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AdopterModel getAdopter() {
        return adopter;
    }

    public void setAdopter(AdopterModel adopter) {
        this.adopter = adopter;
    }
}
