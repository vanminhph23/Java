package com.isofh.his.model;

import com.isofh.his.model.base.Base2Model;

import javax.persistence.*;

@Entity
@Table(name = "his_speaker")
public class Speaker extends Base2Model {
    @Id
    @GeneratedValue(generator = "speaker_generator")
    @SequenceGenerator(
            name = "speaker_generator",
            sequenceName = "speaker_sq",
            initialValue = 1000000
    )
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
