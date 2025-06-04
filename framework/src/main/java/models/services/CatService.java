package models.services;
import base.ServiceBase;
import models.requests.BookingModel;
import models.responses.BookingResponse;
import models.responses.ResponseContainer;

import java.util.List;
import java.util.Map;

public class CatService extends ServiceBase {
    public CatService() {
        super("/cats");
    }

    public ResponseContainer<BookingResponse> addCats(CatModel model, Map<String, String> headers) {
        return this.post(this.url, model, headers, CatResponse.class);
    }

    public ResponseContainer<BookingModel> getCatById(Long catId, Map<String, String> headers) {
        return this.getSingleObject(this.url + "/" + catIdId, headers, CatModel.class);
    }

    public ResponseContainer<List<CatModel>> getCats(Map<String, String> headers) {
        return this.getListOfObjects(this.url, headers);
    }
}