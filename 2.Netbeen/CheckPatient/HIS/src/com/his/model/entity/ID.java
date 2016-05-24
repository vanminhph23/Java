/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his.model.entity;

import java.io.Serializable;

/**
 *
 * @author DinhThap
 */
public class ID implements Serializable{
    private Long id;

    public ID() {
    }

    public ID(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
