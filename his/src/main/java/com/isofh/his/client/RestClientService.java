package com.isofh.his.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.util.Map;

public interface RestClientService {

    <T> ResponseEntity<T> doPost(HttpComponentsClientHttpRequestFactory requestFactory, HttpHeaders headers, String url, Map<String, String> paras, Object body, Class<T> responseType);

    <T> ResponseEntity<T> doPost(String url, Map<String, String> paras, Object body, Class<T> responseType);
}
