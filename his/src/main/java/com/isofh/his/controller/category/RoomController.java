package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.RoomDto;
import com.isofh.his.service.category.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class RoomController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    private RoomService service;

    @GetMapping("/rooms/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("room", service.getAndTransfer(id));
    }

    @PostMapping("/rooms")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody RoomDto dto) {
        return response("room", service.saveAndTransfer(dto));
    }

    @PutMapping("/rooms")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody RoomDto dto) {
        return response("room", service.saveAndTransfer(dto));
    }

    @PostMapping("/rooms/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
