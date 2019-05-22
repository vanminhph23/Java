package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.JobDto;
import com.isofh.his.service.category.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/jobs")
public class JobController extends BaseCategoryController<JobDto, JobService> {

    private final static Logger logger = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private JobService service;

    @Override
    protected JobService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
