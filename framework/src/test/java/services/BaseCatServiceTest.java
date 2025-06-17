package services;

import models.requests.CatModel;
import models.services.CatService;

import java.util.Arrays;

public class BaseCatServiceTest {
    protected final CatService service = new CatService();

    protected CatModel defaultCat() {
        CatModel model = new CatModel();
        model.setName("Garfield");
        model.setAge(3);
        model.setBreed("Persa");
        model.setDateJoined("2025-06-09T15:05:23.414Z");
        model.setVaccinated(true);
        model.setTemperament(Arrays.asList("Calm"));
        model.setStaffInCharge("00000000-0000-0000-0000-000000000000");
        model.setIsAdopted(false);
        model.setAdopterId(1);
        return model;
    }
}
