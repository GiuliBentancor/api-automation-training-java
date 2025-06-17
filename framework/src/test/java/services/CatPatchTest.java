package services;

import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatPatchTest extends BaseCatServiceTest{

    @Test
    void testPatchCatUpdatesInformationCorrectly(){
        CatModel gatoNuevo = defaultCat();
        //gatoNuevo.setIsAdopted(true);
        //gatoNuevo.setAdopterId(2);
        ResponseContainer<CatResponse>addedCat = service.addCats(gatoNuevo,null);
        Assertions.assertEquals(201,addedCat.getStatus());
        CatModel partialUpdate = new CatModel();
        partialUpdate.setStaffInCharge("00000000-0000-0000-0000-000000000000");
        partialUpdate.setAdopterId(1);
        ResponseContainer<CatModel>gatoParcheado = service.patchCatById(addedCat.getData().getId(), partialUpdate,null);
        Assertions.assertEquals(200,gatoParcheado.getStatus());
    }
    @Test
    void testPatchCatDoesNotUpdatesOtherInformation(){
        CatModel gatoNuevo = defaultCat();
        ResponseContainer<CatResponse>addedCat = service.addCats(gatoNuevo,null);
        CatModel partialUpdate = new CatModel();
        partialUpdate.setAge(10);
        partialUpdate.setAdopterId(1);
        ResponseContainer<CatModel>gatoParcheado = service.patchCatById(addedCat.getData().getId(),partialUpdate,null);
        Assertions.assertEquals(400,gatoParcheado.getStatus());
        Assertions.assertEquals(3,addedCat.getData().getAge());
    }
}
