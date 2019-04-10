package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.AssuranceCardDto;
import com.isofh.his.service.category.AssuranceCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/assurance-card")
public class AssuranceCardController extends BaseController {

    @Autowired
    private AssuranceCardService service;

    @GetMapping("/assurance-cards/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("assuranceCard", service.getAndTransfer(id));
    }

    @PostMapping("/assurance-cards")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody AssuranceCardDto dto) {
        return response("assuranceCard", service.saveAndTransfer(dto));
    }

    @PutMapping("/assurance-cards")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody AssuranceCardDto dto) {
        return response("assuranceCard", service.saveAndTransfer(dto));
    }

    @PostMapping("/assurance-cards/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
