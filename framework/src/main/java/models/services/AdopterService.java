package models.services;

import java.util.List;
import java.util.Map;

import base.ServiceBase;
import models.requests.AdopterModel;
import models.responses.AdopterResponse;
import models.responses.ResponseContainer;

public class AdopterService extends ServiceBase {
    public AdopterService() {
        super("/api/adopters");
    }

    public ResponseContainer<AdopterResponse> addAdopter(AdopterModel model, Map<String, String> headers) {
        return this.post(this.url, model, headers, AdopterResponse.class);
    }

    public ResponseContainer<AdopterModel> getAdopterById(Integer id, Map<String, String> headers) {
        return this.getSingleObject(this.url + "/" + id, headers, AdopterModel.class);
    }

    public ResponseContainer<List<AdopterModel>> getAllAdopters(Map<String, String> headers) {
        return this.getListOfObjects(this.url, headers);
    }

    public ResponseContainer<AdopterResponse> deleteAdopter(Integer id, Map<String, String> headers) {
        return this.delete(this.url + "/" + id, null, headers, AdopterResponse.class);
    }
}
