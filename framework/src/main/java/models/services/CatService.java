package models.services;
import base.ServiceBase;
import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;

import java.util.List;
import java.util.Map;

public class CatService extends ServiceBase {
    public CatService() {
        super("/api/cats");
    }

    public ResponseContainer<List<CatModel>> getCats(Map<String, String> headers) {
        return this.getListOfObjects(this.url, headers);
    }

    public ResponseContainer<CatModel> getCatById(Integer catId, Map<String, String> headers) {
        return this.getSingleObject(this.url + "/" + catId, headers, CatModel.class);
    }

    public ResponseContainer<CatResponse> addCat(CatModel model, Map<String, String> headers) {
        return this.post(this.url, model, headers, CatResponse.class);
    }

    public ResponseContainer<CatResponse> updateCat(Integer catId, CatModel model, Map<String, String> headers) {
        return this.put(this.url + "/" + catId, model, headers, CatResponse.class);
    }

    public ResponseContainer<CatResponse> patchCat(Integer catId, CatModel model, Map<String, String> headers) {
        return this.patch(this.url + "/" + catId, model, headers, CatResponse.class);
    }

    public ResponseContainer<CatResponse> deleteCat(Integer catId, Map<String, String> headers) {
        return this.delete(this.url + "/" + catId, "", headers, CatResponse.class);
    }
}