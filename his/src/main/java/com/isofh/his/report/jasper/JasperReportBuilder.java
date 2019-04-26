package com.isofh.his.report.jasper;

import com.isofh.his.exception.report.JasperException;
import com.isofh.his.report.ReportBuilder;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.LocalJasperReportsContext;
import net.sf.jasperreports.export.*;
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
public class JasperReportBuilder implements ReportBuilder {

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
    DataSource secondDatasource;

    @Override
    public File buildPdf(String name, Map<String, Object> parameters, boolean isFirstDatasource) {
        logger.info("Start build pdf: {}, {}", name, parameters);
        try {
            File f = exportToPdf(compileAndFillReport(name, parameters, isFirstDatasource));
            logger.info("Finish build pdf: {}, {}", name, parameters);
            return f;
        } catch (Exception e) {
            throw new JasperException("Cannot build pdf", e);
        }
    }

    @Override
    public File buildExcel(String name, Map<String, Object> parameters, boolean isFirstDatasource) {
        logger.info("Start build excel: {}, {}", name, parameters);
        try {
            File f = exportToExcel(compileAndFillReport(name, parameters, isFirstDatasource));
            logger.info("Finish build excel: {}, {}", name, parameters);
            return f;
        } catch (Exception e) {
            throw new JasperException("Cannot build report", e);
        }
    }

    private JasperPrint compileAndFillReport(String jrxmlFile, Map<String, Object> paras, boolean isFirstDatasource) throws JRException {
        ReportFile file = new ReportFile(BASE_DIR, jrxmlFile);
        return fillReport(paras, file.compile(), isFirstDatasource);
    }

    private File exportToPdf(JasperPrint print) throws JRException {
        logger.info("Start build pdf: {}", print.getName() + ".pdf");
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

        logger.info("Finish build pdf: {}", print.getName() + ".pdf");

        return file;
    }

    private File exportToExcel(JasperPrint print) throws JRException {
        logger.info("Start build excel: {}", print.getName() + ".xls");
        JRXlsExporter exporter = new JRXlsExporter();

        exporter.setExporterInput(new SimpleExporterInput(print));

        File file = new File(EXPORT_DIR, UUID.randomUUID() + "_" + print.getName() + ".xls");

        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));

        SimpleXlsReportConfiguration reportConfig = new SimpleXlsReportConfiguration();
        exporter.setConfiguration(reportConfig);

        SimpleXlsExporterConfiguration exportConfig = new SimpleXlsExporterConfiguration();
        exportConfig.setMetadataAuthor("iSofH");
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();

        logger.info("Finish build excel: {}", print.getName() + ".xls");

        return file;
    }

    private JasperPrint fillReport(Map<String, Object> paras, JasperReport report, boolean isFirstDatasource) throws JRException {
        logger.info("Start fill report: {}, {}, {}", report.getName(), paras, isFirstDatasource);
        Connection connection = null;
        DataSource dataSource = secondDatasource;
        if (isFirstDatasource) {
            dataSource = firstDatasource;
        }

        try {
            connection = DataSourceUtils.getConnection(dataSource);

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

            JasperPrint print = JasperFillManager.getInstance(context).fill(report, paras, connection);
            logger.info("Finish fill report: {}, {}, {}", report.getName(), paras, isFirstDatasource);
            return  print;
        } catch (Exception e) {
            throw new JasperException("Cannot get connection", e);
        } finally {
            logger.info("Release connection: {}", connection);
            DataSourceUtils.releaseConnection(connection, dataSource);
        }
    }
}