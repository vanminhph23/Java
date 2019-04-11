package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.InsuranceCardDto;
import com.isofh.his.service.category.InsuranceCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class InsuranceCardController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(InsuranceCardController.class);

    @Autowired
    private InsuranceCardService service;

    @GetMapping("/insurance-cards/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("assuranceCard", service.getAndTransfer(id));
    }

    @PostMapping("/insurance-cards")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody InsuranceCardDto dto) {
        return response("assuranceCard", service.saveAndTransfer(dto));
    }

    @PutMapping("/insurance-cards")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody InsuranceCardDto dto) {
        return response("assuranceCard", service.saveAndTransfer(dto));
    }

    @PostMapping("/assurance-cards/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
