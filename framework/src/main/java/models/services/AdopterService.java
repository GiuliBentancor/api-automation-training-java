package models.services;

import base.ServiceBase;
import models.requests.AdopterModel;
import models.responses.AdopterResponse;
import models.responses.ResponseContainer;

import java.util.List;
import java.util.Map;

public class AdopterService extends ServiceBase {
    public AdopterService() {
        super("/api/adopters");
    }

    public ResponseContainer<AdopterResponse> addAdopter(AdopterModel model, Map<String, String> headers) {
        return this.post(this.url, model, headers, AdopterResponse.class);
    }

    public ResponseContainer<AdopterModel> getAdopterById(Integer adopterId, Map<String, String> headers) {
        return this.getSingleObject(this.url + "/" + adopterId, headers, AdopterModel.class);
    }

    public ResponseContainer<List<AdopterModel>> getAdopters(Map<String, String> headers) {
        return this.getListOfObjects(this.url, headers);
    }

    public ResponseContainer<Void> deleteAdopterById(Integer adopterId, Map<String, String> headers) {
        return this.delete(this.url + "/" + adopterId, "", headers, Void.class);
    }
}