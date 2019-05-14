package com.isofh.his.insurance.service;

import com.isofh.his.client.RestClientService;
import com.isofh.his.exception.connection.ConnectionException;
import com.isofh.his.exception.insurance.InsurancePortalException;
import com.isofh.his.insurance.model.APIKey;
import com.isofh.his.insurance.model.KetQua;
import com.isofh.his.insurance.model.Login;
import com.isofh.his.service.category.ConstService;
import com.isofh.his.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    private static APIKey currentAPIKey = null;

    @Autowired
    private ConstService constService;

    @Autowired
    private RestClientService restClientService;

    public APIKey getToken() {
        if (currentAPIKey != null && DateUtil.addMinutes(currentAPIKey.getExpires_in(), 1).compareTo(DateUtil.getNow()) > 0) {
            return currentAPIKey;
        }

        return getTokenFromPortal();
    }

    private APIKey getTokenFromPortal() {
        String userName = constService.getInsuranceUsername();
        String password = constService.getInsurancePassword();

        ResponseEntity<KetQua> responseEntity = restClientService.doPost(URL_TOKEN, null, new Login(userName, password), KetQua.class);

        if (responseEntity.getBody() == null) {
            throw new ConnectionException("Cannot get token from insurance portal");
        }

        KetQua kq = responseEntity.getBody();
        if (kq.getAPIKey() == null || !"200".equals(kq.getMaKetQua())) {
            throw new InsurancePortalException("Cannot get token from insurance portal", kq);
        }

        currentAPIKey = kq.getAPIKey();
        return currentAPIKey;
    }
}
