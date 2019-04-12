package com.isofh.his.jasper;

import com.isofh.his.exception.JasperException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRElementsVisitor;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JasperReportBuilder {

    private final DataSource dataSource;

    public JasperReportBuilder(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public File build(String jrxmlFile, Map<String, Object> parameters) {
        try {
            JasperPrint print = compileAndFillReport(jrxmlFile, parameters);
            return exportToPdf(print);
        } catch (Exception e) {
            throw new JasperException("Cannot build report", e);
        }
    }

    private JasperPrint compileAndFillReport(String jrxmlFile, Map<String, Object> parametros) throws JRException {

        JasperReport report = JasperCompileManager.compileReport(jrxmlFile);
        JRElementsVisitor.visitReport(report, new SubReportVisitor("/mnt/workspace/workspace/his-refactor/198/vn.isofh.jr.design/")); // the magic is here!

        JasperPrint print = fillReport(parametros, report);
        return print;
    }

    private File exportToPdf(JasperPrint print) throws JRException {
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(print));

        File file = new File(print.getName());

        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));

        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);
        exporter.setConfiguration(reportConfig);

        SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("iSofH");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();

        return file;
    }

    private JasperPrint fillReport(Map<String, Object> parametros, JasperReport report) throws JRException {
        Connection connection = null;
        try {
            connection = getConnection();
            return JasperFillManager.fillReport(report, parametros, connection);
        } finally {
            DataSourceUtils.releaseConnection(connection, dataSource);
        }
    }

    private Connection getConnection() {
        try {
//            return DataSourceUtils.getConnection(dataSource);

            String url = "jdbc:postgresql://10.0.0.85:5432/198_test_201904121059";
            Properties props = new Properties();
            props.setProperty("user","adempiere");
            props.setProperty("password","1");
            return DriverManager.getConnection(url, props);

        } catch (Exception e) {
            throw new JasperException("Cannot get connection", e);
        }
    }

    public static void main(String[] args) {
//        DataSource dataSource = DataSourceFactory.; // your datasource
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("RECORD_ID", 1095432);
        parameters.put("TableName", "HIS_Reception");
        parameters.put("SUBREPORT_DIR", "/mnt/workspace/workspace/his-refactor/198/vn.isofh.jr.design/");

        JasperReportBuilder builder = new JasperReportBuilder(null);
        File f = builder.build("/mnt/workspace/workspace/his-refactor/198/vn.isofh.jr.design/PhieuHuongDanMain.jrxml", parameters);

        System.out.println(f.getAbsoluteFile());

    }

}