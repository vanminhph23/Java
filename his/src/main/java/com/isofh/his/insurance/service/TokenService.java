package com.isofh.his.insurance.service;


import com.isofh.his.insurance.model.APIKey;

public interface TokenService {

    String URL_TOKEN = "http://egw.baohiemxahoi.gov.vn/api/token/take";

    APIKey getToken();
}
