/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his.model.daoimpl;

import com.his.model.idao.GenericDAO;
import com.his.utils.DatabaseUtils;
import com.his.utils.Session;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DinhThap
 * @param <T>
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    public static DatabaseUtils db = DatabaseUtils.getInstance();
    private Connection con;
    public Class<T> type;

    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public List<T> getAll() throws Exception{
        try {
            this.con = db.openConnection();
            return new Session(con).getAll(type);
        } catch (Exception e) {
            try {
                db.closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        return null;
    }

    @Override
    public T insert(T t) throws Exception{
        try {
            this.con = db.openConnection();
            return new Session(con).insert(t);
        } catch (Exception ex) {
            try {
                db.closeConnection();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean delete(T id) throws Exception{
        try {
            this.con = db.openConnection();
            return new Session(con).delete(id);
        } catch (Exception ex) {
            try {
                db.closeConnection();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public T findById(Object id) throws Exception{
        try {
            this.con = db.openConnection();
            return new Session(con).getById(type, id);
        } catch (Exception ex) {
            try {
                db.closeConnection();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public T update(T t) throws Exception{
        try {
            this.con = db.openConnection();
            return new Session(con).update(t);
        } catch (Exception ex) {
            try {
                db.closeConnection();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Long countAll() throws Exception{
        try {
            this.con = db.openConnection();
            return new Session(con).count(type);
        } catch (Exception ex) {
            try {
                db.closeConnection();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<T> getAllForInput(T t,String column,boolean asc) throws Exception{
        try {
            this.con = db.openConnection();
            return new Session(con).getAllForInput(type, t, column, asc);
        } catch (Exception ex) {
            try {
                db.closeConnection();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Long countAllForInput(T t) throws Exception{
        try {
            this.con = db.openConnection();
            return new Session(con).countForInput(t);
        } catch (Exception ex) {
            try {
                db.closeConnection();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        return null;
    }

}
