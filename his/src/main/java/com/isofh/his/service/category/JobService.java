package com.isofh.his.service.category;

import com.isofh.his.dto.category.JobDto;
import com.isofh.his.model.category.Job;
import com.isofh.his.repository.category.JobRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface JobService extends BaseCategoryService<Job, JobDto, JobRepository> {
}
