package com.isofh.his.client;

import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class RestClientServiceImpl implements RestClientService {

    public <T> ResponseEntity<T> doPost(HttpComponentsClientHttpRequestFactory requestFactory, HttpHeaders headers, String url, Map<String, String> paras, Object body, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        if (paras != null && paras.size() > 0) {
            for (String key : paras.keySet()) {
                builder.queryParam(key, paras.get(key));
            }
        }

        return restTemplate.exchange(builder.toUriString(), HttpMethod.POST, new HttpEntity<>(body, headers), responseType);
    }

    public <T> ResponseEntity<T> doPost(String url, Map<String, String> paras, Object body, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectionRequestTimeout(100);
        requestFactory.setConnectTimeout(100);
        requestFactory.setReadTimeout(100);

        return doPost(requestFactory, headers, url, paras, body, responseType);
    }
}
