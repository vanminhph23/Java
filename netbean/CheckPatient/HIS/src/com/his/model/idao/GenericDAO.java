/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his.model.idao;

import java.util.List;

/**
 *
 * @author DinhThap
 * @param <T>
 */
public interface GenericDAO<T> {
    Long countAll() throws Exception;
    Long countAllForInput(T t) throws Exception;
    T insert(T t) throws Exception;
    T update(T t) throws Exception;
    T findById(Object id) throws Exception;
    List<T> getAll() throws Exception;
    boolean delete(T id) throws Exception;
    List<T> getAllForInput(T t,String column,boolean asc) throws Exception;
}
