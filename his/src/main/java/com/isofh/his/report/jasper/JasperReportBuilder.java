package com.isofh.his.jasper;

import com.isofh.his.exception.JasperException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.LocalJasperReportsContext;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.util.Map;
import java.util.UUID;

@Service
public class JasperReportBuilder {

    private final static Logger logger = LoggerFactory.getLogger(JasperReportBuilder.class);

    @Value("${app.report.jrxml}")
    private String BASE_DIR;

    @Value("${app.report.exportFile}")
    private String EXPORT_DIR;

    @Qualifier("firstDatasource")
    @Autowired
    DataSource firstDatasource;

    @Qualifier("secondDatasource")
    @Autowired
    DataSource dataSource;


    public File build(String jrxmlFile, Map<String, Object> parameters) {
        logger.info("Start build report: {}, {}", jrxmlFile, parameters);
        try {
            JasperPrint print = compileAndFillReport(jrxmlFile, parameters);
            File f = exportToPdf(print);
            logger.info("Finish build report: {}, {}", jrxmlFile, parameters);
            return f;
        } catch (Exception e) {
            throw new JasperException("Cannot build report", e);
        }
    }

    private JasperPrint compileAndFillReport(String jrxmlFile, Map<String, Object> parametros) throws JRException {
        ReportFile file = new ReportFile(BASE_DIR, jrxmlFile);
        return fillReport(parametros, file.compile());
    }

    private File exportToPdf(JasperPrint print) throws JRException {
        logger.info("Start build export pdf: {}", print.getName() + ".pdf");
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(print));

        File file = new File(EXPORT_DIR, UUID.randomUUID() + "_" + print.getName() + ".pdf");

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

        logger.info("Finish build export pdf: {}", print.getName() + ".pdf");

        return file;
    }

    private JasperPrint fillReport(Map<String, Object> parametros, JasperReport report) throws JRException {
        Connection connection = null;
        try {
            connection = getConnection();

            LocalJasperReportsContext context = new LocalJasperReportsContext(DefaultJasperReportsContext.getInstance());
            context.setClassLoader(JasperReport.class.getClassLoader());
            context.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");
            context.setFileResolver((fileName) -> {
                if (fileName.endsWith(ReportFile.JASPER_EXTENSION)) {
                    fileName = fileName.replaceAll("[/\\\\]+", "/");
                    fileName = fileName.substring(fileName.lastIndexOf("/")+1, fileName.length());

                    ReportFile file = new ReportFile(BASE_DIR, fileName);
                    return file.compileSub();
                }

                return new File(BASE_DIR, fileName);
            });

            return JasperFillManager.getInstance(context).fill(report, parametros, connection);
        } finally {
            DataSourceUtils.releaseConnection(connection, dataSource);
        }
    }

    private Connection getConnection() {
        try {
            return DataSourceUtils.getConnection(dataSource);
        } catch (Exception e) {
            throw new JasperException("Cannot get connection", e);
        }
    }
}