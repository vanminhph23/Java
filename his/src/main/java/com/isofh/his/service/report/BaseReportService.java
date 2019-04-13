package com.isofh.his.service.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;

public abstract class BaseReportService {

    @Qualifier("firstDatasource")
    @Autowired
    DataSource firstDatasource;

    @Qualifier("secondDatasource")
    @Autowired
    DataSource secondDatasource;

    public DataSource getFirstDatasource() {
        return firstDatasource;
    }

    public void setFirstDatasource(DataSource firstDatasource) {
        this.firstDatasource = firstDatasource;
    }

    public DataSource getSecondDatasource() {
        return secondDatasource;
    }

    public void setSecondDatasource(DataSource secondDatasource) {
        this.secondDatasource = secondDatasource;
    }
}
