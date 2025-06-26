package services;

import models.requests.AdopterModel;
import models.services.AdopterService;
import org.junit.jupiter.api.BeforeEach;

public class BaseAdopterServiceTest {
    protected final AdopterService service = new AdopterService();

    @BeforeEach
    public void setup() {
        //service.authenticate();
    }

    protected AdopterModel defaultAdopter() {
        AdopterModel model = new AdopterModel();
        model.setName("Carlos");
        model.setLastName("Roberto");
        model.setDateOfBirth("2000-06-20T23:39:22.868Z");
        model.setPhone("87654321");
        model.setAddress("string");
        return model;
    }
}