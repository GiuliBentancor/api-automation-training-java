package services;

import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RequestResponseLogger;

public class CatCreationTest extends BaseCatServiceTest {

    @Test
    @DisplayName("Create a new cat returns expected data")
    void createNewCat() {
        CatModel model = defaultCat();
        RequestResponseLogger.logRequest(model);
        
        ResponseContainer<CatResponse> response = service.addCats(model, null);
        RequestResponseLogger.logResponse(response);
        
        Assertions.assertEquals(201, response.getStatus());

        CatResponse responseModel = response.getData();
        Assertions.assertNotNull(response.getData());
        Assertions.assertEquals(model.getName(), responseModel.getName());
        /*Assertions.assertEquals(model.getLastname(), responseModel.getLastname());
        Assertions.assertEquals(model.getDepositpaid(), responseModel.getDepositpaid());
        Assertions.assertEquals(model.getTotalprice(), responseModel.getTotalprice());
        Assertions.assertEquals(model.getAdditionalneeds(), responseModel.getAdditionalneeds());
        Assertions.assertEquals(model.getBookingdates().getCheckin(), responseModel.getBookingdates().getCheckin());
        Assertions.assertEquals(model.getBookingdates().getCheckout(), responseModel.getBookingdates().getCheckout());*/
    }

    /*@Test
    @DisplayName("Create booking without firstname returns 400")
    void createBookingWithoutFirstname() {
        BookingModel model = defaultBooking();
        model.setFirstname(null);
        ResponseContainer<BookingResponse> response = service.addBooking(model, null);
        Assertions.assertEquals(500, response.getStatus());
    }*/
}
