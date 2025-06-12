package models.requests;
import java.util.List;

public class CatModel {

    private Integer id;
    private String name;
    private Integer age;
    private String breed;
    private String dateJoined;
    private boolean vaccinated;
    private List<String> temperament;
    private String staffInCharge;
    private Boolean isAdopted;
    private Integer adopterId;

    public CatModel() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer Age) {
        this.age = Age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String Breed) {
        this.breed = Breed;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String DateJoined) {
        this.dateJoined = DateJoined;
    }

    public boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean Vaccinated) {
        this.vaccinated = Vaccinated;
    }

    public List<String> getTemperament() {
        return temperament;
    }

    public void setTemperament(List<String> Temperament) {
        this.temperament = Temperament;
    }

    public String getStaffInCharge() {
        return staffInCharge;
    }

    public void setStaffInCharge(String StaffInCharge) {
        this.staffInCharge = StaffInCharge;
    }

    public boolean getIsAdopted() {
        return isAdopted;
    }

    public void setIsAdopted(Boolean IsAdopted) {
        this.isAdopted = IsAdopted;
    }

    public Integer getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(Integer AdopterId) {
        this.adopterId = AdopterId;
    }
}