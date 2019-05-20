package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_report_template", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
@Audited
public class ReportTemplate extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "report_template_generator")
    @SequenceGenerator(
            name = "report_template_generator",
            sequenceName = "report_template_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "service_type")
    @Audited
    private int serviceType;

    @Column(name = "report_file")
    @Audited
    private int reportFile;

    @Column(name = "separate", nullable = false)
    @Audited
    private boolean separate;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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
