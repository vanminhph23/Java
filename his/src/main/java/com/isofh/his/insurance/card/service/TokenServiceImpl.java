package com.isofh.his.insurance.card.service;

import com.isofh.his.exception.connection.ConnectionException;
import com.isofh.his.exception.insurance.InsurancePortalException;
import com.isofh.his.insurance.card.model.APIKey;
import com.isofh.his.insurance.card.model.KetQua;
import com.isofh.his.insurance.card.model.Login;
import com.isofh.his.service.category.ConstService;
import com.isofh.his.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenServiceImpl implements TokenService {

    private static APIKey currentAPIKey = null;

    @Autowired
    private ConstService constService;

    public APIKey getToken() {
        if (currentAPIKey != null && currentAPIKey.getExpires_in().compareTo(DateUtil.getNow()) > 0) {
            return currentAPIKey;
        }

        return getTokenFromPortal();
    }

    private APIKey getTokenFromPortal() {
        String userName = constService.getInsuranceUsername();
        String password = constService.getInsurancePassword();

        Login login = new Login(userName, password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Login> request = new HttpEntity<>(login, headers);

        RestTemplate restTemplate = new RestTemplate();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        restTemplate.setRequestFactory(requestFactory);

        ResponseEntity<KetQua> responseEntity = restTemplate.exchange("http://egw.baohiemxahoi.gov.vn/api/token/take", HttpMethod.POST, request, KetQua.class);

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
