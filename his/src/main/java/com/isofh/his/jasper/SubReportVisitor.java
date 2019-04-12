package com.isofh.his.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRSubreport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.util.JRVisitorSupport;

public class SubReportVisitor extends JRVisitorSupport {

    private final String jasperPath;

    public SubReportVisitor(String jasperPath) {
        this.jasperPath = jasperPath;
    }

    @Override
    public void visitSubreport(JRSubreport subreport) {
        SubReportInfo subReportInfo = new SubReportInfo(subreport, jasperPath);
        compile(subReportInfo);
    }

    private void compile(SubReportInfo subReportInfo) {
        try {

            if (subReportInfo.shouldCompile())
                JasperCompileManager.compileReportToFile(subReportInfo.getJRXMLFilepath(), "/mnt/workspace/workspace/his-refactor/198/vn.isofh.jr.design/PhieuHuongDan.jasper");

        } catch (JRException e) {
            throw new IllegalStateException("Não foi possível compilar o subrelatório '" + subReportInfo.getJRXMLFilename() + "'.", e);
        }
    }

}