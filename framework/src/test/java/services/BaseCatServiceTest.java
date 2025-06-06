package services;

import models.requests.BookingModel;
import models.requests.CatModel;
import models.services.BookingService;
import models.services.CatService;
import org.junit.jupiter.api.BeforeEach;

public class BaseCatServiceTest {
    protected final CatService service = new CatService();

    @BeforeEach
    public void setup() {
        service.authenticate();
    }

    protected CatModel defaultCat() {
        CatModel model = new CatModel();
        model.setFirstname("Gato1");
        model.setAge(2);
        model.setBreed("Siames");
        model.setDateJoined("2025-06-06T21:27:48.910Z");
        model.setVaccinated(true);
        model.setTemperament("Friendly");
        model.setStaffInCharge("Ricardo");
        model.setAdopted(true);
        model.setAdopterId(1);
        return model;
    }
}
