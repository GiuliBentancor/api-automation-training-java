package models.responses;

import models.requests.BookingModel;
import models.requests.CatModel;

public class CatResponse {
    private Long catid;
    private CatModel cat;

    public CatResponse() {
    }

    public Long getCatid() {
        return catid;
    }

    public void setCatid(Long catid) {
        this.catid = catid;
    }

    public CatModel getCat() {
        return cat;
    }

    public void setCat(CatModel cat) {
        this.cat = cat;
    }
}