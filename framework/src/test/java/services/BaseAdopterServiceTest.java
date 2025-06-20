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
        model.setAge(30);
        model.setDateJoined("2024-01-01");
        model.setRole("adoptador");
        return model;
    }
}