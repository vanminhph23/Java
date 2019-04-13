package com.isofh.his.report;

import java.io.File;
import java.util.Map;

public interface ReportBuilder {

    File buildPdf(String name, Map<String, Object> parameters, boolean isFirstDatasource);
    File buildExcel(String name, Map<String, Object> parameters, boolean isFirstDatasource);

    default File buildPdf(String name, Map<String, Object> parameters) {
        return buildPdf(name, parameters, false);
    }

    default File buildExcel(String name, Map<String, Object> parameters) {
        return buildExcel(name, parameters, false);
    }
}
