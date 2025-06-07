package models.responses;

import models.requests.BookingModel;
import models.requests.CatModel;

public class CatResponse {
    private Long id;
    private CatModel cat;

    public CatResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CatModel getCat() {
        return cat;
    }

    public void setCat(CatModel cat) {
        this.cat = cat;
    }
}