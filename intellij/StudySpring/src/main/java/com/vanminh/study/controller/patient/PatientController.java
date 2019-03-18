package com.vanminh.study.controller.patient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @RequestMapping("/patient")
    public String createPatient(@RequestParam(value = "name") String name) {
        return name;
    }

}
