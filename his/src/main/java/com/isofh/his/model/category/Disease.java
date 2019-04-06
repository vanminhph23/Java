package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_disease")
public class Disease extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "disease_generator")
    @SequenceGenerator(
            name = "disease_generator",
            sequenceName = "disease_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "parent_disease_id")
    @Audited
    private Long parentDiseaseId;

    @ManyToOne
    @JoinColumn(name = "parent_disease_id", insertable = false, updatable = false)
    private Disease parentDisease;

    @Column(name = "disease_type")
    @Audited
    private String diseaseType;

    @Column(name = "chapter1_seq")
    @Audited
    private String chapter1Seq;

    @Column(name = "chapter2_seq")
    @Audited
    private String chapter2Seq;

    @Column(name = "chapter1_name")
    @Audited
    private String chapter1Name;

    @Column(name = "chapter2_name")
    @Audited
    private String chapter2Name;

    @Column(name = "group_value")
    @Audited
    private String groupValue;

    @Column(name = "group_name")
    @Audited
    private String groupName;

    @Column(name = "sub1_group_value")
    @Audited
    private String sub1GroupValue;

    @Column(name = "sub2_group_value")
    @Audited
    private String sub2GroupValue;

    @Column(name = "sub1_group_name")
    @Audited
    private String sub1GroupName;

    @Column(name = "sub2_group_name")
    @Audited
    private String sub2GroupName;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
