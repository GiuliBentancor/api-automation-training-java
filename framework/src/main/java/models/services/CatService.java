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

    //POST
    public ResponseContainer<CatResponse> addCats(CatModel model, Map<String, String> headers) {
        return this.post(this.url, model, headers, CatResponse.class);
    }
    //GET-ID
    public ResponseContainer<CatModel> getCatById(Integer catId, Map<String, String> headers) {
        return this.getSingleObject(this.url + "/" + catId, headers, CatModel.class);
    }
    //GET
    public ResponseContainer<List<CatModel>> getCats(Map<String, String> headers) {
        return this.getListOfObjects(this.url, headers);
    }
    //PUT-ID
    public ResponseContainer<CatModel> updateCat(Long catId, CatModel model, Map<String, String> headers) {
        String updateUrl = this.url + "/" + catId;
        return this.put(updateUrl, model, headers, CatModel.class);
    }
    //DELETE-ID
    public ResponseContainer<Void> deleteCatById(Long catId, Map<String, String> headers) {
        String deleteUrl = this.url + "/" + catId;
        return this.delete(deleteUrl, null, headers, Void.class);
    }

    // PATCH-ID
    public ResponseContainer<CatModel> patchCatById(Long catId, CatModel partialUpdate, Map<String, String> headers) {
        String patchUrl = this.url + "/" + catId;
        return this.patch(patchUrl, partialUpdate, headers, CatModel.class);
    }
}