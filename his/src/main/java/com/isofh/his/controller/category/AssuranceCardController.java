package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.AssuranceCardDto;
import com.isofh.his.service.category.AssuranceCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/assurance-card")
public class AssuranceCardController extends BaseController {

    @Autowired
    private AssuranceCardService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("assuranceCard", service.getDto(service.get(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody AssuranceCardDto model) {
        return response("assuranceCard", service.getDto(service.save(service.getModel(model))));
    }

    @PostMapping("/import-excel")
    public ResponseEntity<ResponseMsg> importExcel(@RequestParam("file") MultipartFile file) {
        return service.importExcel(file);
    }
}
