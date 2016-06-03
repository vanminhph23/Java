/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

/**
 *
 * @author vanminh
 */
public interface IModel<T> {
    String columnNameID = null;
    
    default String getFromClause(){
        return getClass().toString();
    }
    
    
}
