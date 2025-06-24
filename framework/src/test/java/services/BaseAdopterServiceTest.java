package services;

import models.requests.AdopterModel;
import models.services.AdopterService;

public class BaseAdopterServiceTest {
    protected final AdopterService service = new AdopterService();

    protected AdopterModel defaultAdopter(){
        AdopterModel model = new AdopterModel();
        model.setName("Agustin");
        model.setLastName("Ferreira");
        model.setDateOfBirth("1997-06-09T15:05:23.414Z");
        model.setPhone("099999991");
        model.setAddress("Direccion 3");
        return model;
    }
}
