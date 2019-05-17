package com.isofh.his.model.category.service;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_service_bed")
public class ServiceBed {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ServiceSource service;

    @Column(name = "bed_type")
    @Audited
    private int bedType;
}
