package services;

import models.requests.CatModel;
import models.services.CatService;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseCatServiceTest {
    protected final CatService service = new CatService();

    @BeforeEach
    public void setup() {
        //service.authenticate();
    }

    protected CatModel defaultCat() {
        CatModel model = new CatModel();
        model.setName("Gato");
        model.setAge(2);
        model.setBreed("Siames");
        model.setDateJoined("2025-06-06T21:27:48.910Z");
        model.setVaccinated(true);
        model.setTemperament(new ArrayList<>(Arrays.asList("Calm")));
        model.setStaffInCharge("00000000-0000-0000-0000-000000000000");
        model.setAdopted(false);
        model.setAdopterId(1);
        return model;
    }
}
