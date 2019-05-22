package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_result_template", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
@Where(clause = "deleted=0")
@Audited
public class ResultTemplate extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "result_template_generator")
    @SequenceGenerator(
            name = "result_template_generator",
            sequenceName = "result_template_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "conclusion")
    @Audited
    private int conclusion;

    @Column(name = "result")
    @Audited
    private int result;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getConclusion() {
        return conclusion;
    }

    public void setConclusion(int conclusion) {
        this.conclusion = conclusion;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
