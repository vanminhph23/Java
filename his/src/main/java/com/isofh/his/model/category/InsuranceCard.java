package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_assurance_card")
public class InsuranceCard extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "assurance_card_generator")
    @SequenceGenerator(
            name = "assurance_card_generator",
            sequenceName = "assurance_card_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "assurance_percent")
    @Audited
    private int assurancePercent;

    @Column(name = "job_id")
    @Audited
    private Long jobId;

    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private Job job;

    @Column(name = "description")
    @Audited
    private String description;

    @Column(name = "check_ignore")
    @Audited
    private boolean checkIgnore;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getAssurancePercent() {
        return assurancePercent;
    }

    public void setAssurancePercent(int assurancePercent) {
        this.assurancePercent = assurancePercent;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCheckIgnore() {
        return checkIgnore;
    }

    public void setCheckIgnore(boolean checkIgnore) {
        this.checkIgnore = checkIgnore;
    }
}
