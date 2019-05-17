package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.model.category.ProductClassify;
import com.isofh.his.model.category.ProductGroup;
import com.isofh.his.model.category.ProductType;
import com.isofh.his.model.category.UOM;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_service_product")
public class ServiceProduct extends BaseCategoryModel {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ServiceSource service;

    @Column(name = "high_tech", nullable = false)
    @Audited
    private boolean highTech;

    @Column(name = "original_value", nullable = false)
    @Audited
    private String originalValue;

    @Column(name = "original_name", nullable = false)
    @Audited
    private String originalName;

    @Column(name = "secondary_uom_id")
    @Audited
    private Long secondaryUomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "secondary_uom_id", insertable = false, updatable = false)
    private UOM secondaryUom;

    @Column(name = "secondary_uom_multiplier")
    @Audited
    private Long secondaryUomMultiplier;

    @Column(name = "active_ingredient", nullable = false)
    @Audited
    private String activeIngredient;

    @Column(name = "measure", nullable = false)
    @Audited
    private String measure;

    @Column(name = "short_active_ingredient", nullable = false)
    @Audited
    private String shortActiveIngredient;

    @Column(name = "short_measure", nullable = false)
    @Audited
    private String shortMeasure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_product_group_id")
    @Audited
    private ProductGroup parentProductGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_group_id")
    @Audited
    private ProductGroup productGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_product_group_id")
    @Audited
    private ProductGroup childProductGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_classify_id")
    @Audited
    private ProductClassify productClassify;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id")
    @Audited
    private ProductType productType;

    @Column(name = "packing", nullable = false)
    @Audited
    private String packing;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
