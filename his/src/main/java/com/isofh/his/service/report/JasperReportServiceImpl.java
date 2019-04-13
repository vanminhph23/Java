package com.isofh.his.service.report;

import com.isofh.his.report.jasper.JasperReportBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class JasperReportServiceImpl extends BaseReportService {

    private final static Logger logger = LoggerFactory.getLogger(JasperReportServiceImpl.class);

    @Autowired
    JasperReportBuilder builder;

    public File getPhieuHuongDan() {
        Map<String, Object> map = new HashMap<>();
        map.put("TableName", "HIS_PatientHistory");
        map.put("RECORD_ID", 1131249);
        return builder.buildExcel("PhieuHuongDanMain.jrxml", map);
    }
}
