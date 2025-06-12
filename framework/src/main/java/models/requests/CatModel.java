package models.requests;

import java.util.ArrayList;
import java.util.List;

public class CatModel {

    private Integer id;
    private String name;
    private Integer age;
    private String breed;
    private String dateJoined;
    private Boolean vaccinated;
    private List<String> temperament;
    private String staffInCharge;
    private boolean isAdopted;
    private Integer adopterId;

    public CatModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstname) {
        this.name = firstname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }


    public String getStaffInCharge() {
        return staffInCharge;
    }

    public void setStaffInCharge(String staffInCharge) {
        this.staffInCharge = staffInCharge;
    }

    public boolean getIsAdopted() {
        return isAdopted;
    }

    public void setIsAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    public Integer getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(Integer adopterId) {
        this.adopterId = adopterId;
    }

    public List<String> getTemperament() {
        return temperament;
    }

    public void setTemperament(List<String> temperament) {
        this.temperament = temperament;
    }


}