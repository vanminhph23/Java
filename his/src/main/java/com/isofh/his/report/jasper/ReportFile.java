package com.isofh.his.report.jasper;

import com.isofh.his.exception.JasperException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ReportFile {

    private final static Logger logger = LoggerFactory.getLogger(ReportFile.class);

    public final static String JASPER_EXTENSION = ".jasper";
    public final static String XML_EXTENSION = ".jrxml";

    private final File sourceFile;
    private final File compiledFile;

    public ReportFile(String path, String fileName) {
        String filename = extractFilename(fileName);
        this.compiledFile = new File(path, filename + JASPER_EXTENSION);
        this.sourceFile = new File(path, filename + XML_EXTENSION);
    }

    public String getJRXmlFileName() {
        return sourceFile.getName();
    }

    public String getJRXmlFilePath() {
        return sourceFile.getAbsolutePath();
    }

    public String getJRJasperFileName() {
        return compiledFile.getName();
    }

    public String getJRJasperFilePath() {
        return compiledFile.getAbsolutePath();
    }

    private boolean shouldCompile() {
        if (!compiledFile.exists()) {
            return true;
        }

        return (compiledFile.lastModified() < sourceFile.lastModified());
    }

    private String extractFilename(String fileName) {
        if (fileName.endsWith(JASPER_EXTENSION)) {
            return fileName.substring(0, fileName.length() - 7);
        }

        if (fileName.endsWith(XML_EXTENSION)) {
            return fileName.substring(0, fileName.length() - 6);
        }

        throw new JasperException("Not match file pattern: " + fileName);
    }

    public File compileSub() {
        try {
            if (shouldCompile()) {
                logger.warn("Start compile report file: {}", getJRXmlFilePath());
                JasperCompileManager.compileReportToFile(getJRXmlFilePath(), getJRJasperFilePath());
                logger.warn("Finish compile sub report file: {}", getJRXmlFilePath());
            }
        } catch (JRException e) {
            throw new JasperException("Cannot compile sub report file: " + getJRJasperFilePath(), e);
        }
        return compiledFile;
    }

    public JasperReport compile() {
        try {
            if (shouldCompile()) {
                logger.warn("Start compile report file: {}", getJRXmlFilePath());
                JasperReport jasperReport = JasperCompileManager.compileReport(getJRXmlFilePath());
                JRSaver.saveObject(jasperReport, getJRJasperFilePath());
                logger.warn("Finish compile report file: {}", getJRXmlFilePath());
                return jasperReport;
            } else {
                return (JasperReport) JRLoader.loadObject(compiledFile);
            }
        } catch (JRException e) {
            throw new JasperException("Cannot compile report file: " + getJRJasperFilePath(), e);
        }
    }
}