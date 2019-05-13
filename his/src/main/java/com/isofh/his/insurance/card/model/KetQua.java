package com.isofh.his.insurance.card.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KetQua {

    String maKetQua;
    APIKey APIKey;

    public KetQua() {
    }

    public String getMaKetQua() {
        return maKetQua;
    }

    public void setMaKetQua(String maKetQua) {
        this.maKetQua = maKetQua;
    }

    public APIKey getAPIKey() {
        return APIKey;
    }

    @JsonProperty("APIKey")
    public void setAPIKey(APIKey APIKey) {
        this.APIKey = APIKey;
    }
}
