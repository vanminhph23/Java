package com.isofh.his.model.category.service;

import javax.persistence.*;

@Entity
@Table(name = "his_service_bed")
public class ServiceBed {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @MapsId
    private Service service;
}
