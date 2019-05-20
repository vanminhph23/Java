package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;

public class ReportTemplateDto extends BaseCategoryDto {

    public ReportTemplateDto() {
    }

    private int serviceType;

    private int reportFile;

    private boolean separate;

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public int getReportFile() {
        return reportFile;
    }

    public void setReportFile(int reportFile) {
        this.reportFile = reportFile;
    }

    public boolean isSeparate() {
        return separate;
    }

    public void setSeparate(boolean separate) {
        this.separate = separate;
    }
}
