package com.isofh.his.model.category.service;

import javax.persistence.*;

@Entity
@Table(name = "his_bed_service")
public class BedService {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @MapsId
    private Service service;
}
