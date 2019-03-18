/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his.utils;

import com.his.exception.DatabaseException;
import com.his.model.entity.ID;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DinhThap
 */
public class Session {

    private Connection con;
    private PreparedStatement stm;

    public Session(Connection con) {
        this.con = con;
    }

    @SuppressWarnings("unchecked")
    public <T> T insert(T object) throws IllegalArgumentException, IllegalAccessException {

        int lenfilds = object.getClass().getDeclaredFields().length;
        int index = 1;
        Field[] fs = object.getClass().getDeclaredFields();
        char[] values = new char[fs.length];
        StringBuilder builderInterrogacoes = new StringBuilder();
        StringBuilder bulderFilers = new StringBuilder();

        for (int i = 1; i < values.length; ++i) {
            builderInterrogacoes.append("?");
            builderInterrogacoes.append(",");
        }
        builderInterrogacoes.deleteCharAt(builderInterrogacoes.length() - 1);

        Object[] fildesValues = new Object[lenfilds];

        for (; index < lenfilds; index++) {
            Field f = object.getClass().getDeclaredFields()[index];
            f.setAccessible(true);
            fildesValues[index] = f.get(object);
            bulderFilers.append(f.getName());
            bulderFilers.append(",");
        }

        bulderFilers.deleteCharAt(bulderFilers.length() - 1);

        String sql = "insert into "
                + object.getClass().getSimpleName().toLowerCase() + " ("
                + bulderFilers.toString() + ")" + " values " + "( "
                + builderInterrogacoes.toString() + " )";

        ResultSet rs = null;
        try {
            stm = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            for (int i = 1; i < index; i++) {
                if (fildesValues[i].getClass().isEnum()) {
                    stm.setObject(i, fildesValues[i].toString());
                    continue;
                }
                stm.setObject(i, fildesValues[i]);
            }
            stm.execute();

            rs = stm.getGeneratedKeys();
            rs.next();

            return (T) getById(object.getClass(), rs.getInt(1));

        } catch (Exception e) {
            DatabaseUtils.closeAll(stm, rs);
            throw new DatabaseException(e);
        }

    }

    public <T> List<T> getAllForInput(Class<T> type, final T object, String column, boolean asc) throws IllegalArgumentException, IllegalAccessException {
        Field[] fs = object.getClass().getDeclaredFields();
        int index = 0;
        int lengthFields = fs.length;
        StringBuilder bulderFilers = new StringBuilder();

        Object[] fildesValues = new Object[lengthFields];

        for (; index < lengthFields; index++) {
            Field f = object.getClass().getDeclaredFields()[index];
            f.setAccessible(true);
            Object value = f.get(object);

            if (f.getType().isAssignableFrom(ID.class)) {
                if (value != null) {
                    value = ((ID) value).getId();
                }
            }

            if (value != null) {
                fildesValues[index] = value;
                bulderFilers.append(" and ").append(f.getName().concat(" = ? "));
            }

        }

        String sql = "select * from  "
                + object.getClass().getSimpleName().toLowerCase() + " where 1=1 "
                + bulderFilers.toString() + " order by " + column;
        if (asc) {
            sql += " asc";
        } else {
            sql += " dsc";
        }
        ResultSet rs = null;
        try {

            stm = con.prepareStatement(sql);

            for (int i = 1; i < index; i++) {
                if (fildesValues[i] != null) {
                    if (fildesValues[i].getClass().isEnum()) {
                        stm.setObject(i, fildesValues[i].toString());
                        continue;
                    }
                    stm.setObject(i, fildesValues[i]);
                }
            }

            rs = stm.executeQuery();
            List<T> results = new ArrayList<>();
            while (rs.next()) {
                T newInstance = type.newInstance();
                for (int i = 0; i < newInstance.getClass().getDeclaredFields().length; i++) {

                    Field f = newInstance.getClass().getDeclaredFields()[i];
                    f.setAccessible(true);
                    if (f.getType().isAssignableFrom(ID.class)) {
                        f.set(newInstance, new ID(rs.getLong(f.getName())));
                    } else {
                        f.set(newInstance, rs.getObject(f.getName()));
                    }
                }
                results.add(newInstance);
            }

            return results;

        } catch (Exception e) {
            DatabaseUtils.closeAll(stm, rs);
            throw new DatabaseException(e);
        }

    }

    public <T> long countForInput(final T object) throws IllegalArgumentException, IllegalAccessException {
        Field[] fs = object.getClass().getDeclaredFields();
        int index = 0;
        int lengthFields = fs.length;
        StringBuilder bulderFilers = new StringBuilder();

        Object[] fildesValues = new Object[lengthFields];

        for (; index < lengthFields; index++) {
            Field f = object.getClass().getDeclaredFields()[index];
            f.setAccessible(true);
            if (f.getType().isAssignableFrom(ID.class)) {
                continue;
            }
            Object value = f.get(object);
            if (value != null) {
                fildesValues[index] = value;
                bulderFilers.append(" and ").append(f.getName().concat(" = ? "));
            }

        }

        String sql = "select count(*) from  "
                + object.getClass().getSimpleName().toLowerCase() + " where 1=1 "
                + bulderFilers.toString();
        ResultSet rs = null;
        try {

            stm = con.prepareStatement(sql);

            for (int i = 1; i < index; i++) {
                if (fildesValues[i] != null) {
                    if (fildesValues[i].getClass().isEnum()) {
                        stm.setObject(i, fildesValues[i].toString());
                        continue;
                    }
                    stm.setObject(i, fildesValues[i]);
                }
            }

            rs = stm.executeQuery();

            int count = 0;
            while (rs.next()) {
                count += rs.getInt(1);
            }

            return count;

        } catch (Exception e) {
            DatabaseUtils.closeAll(stm, rs);
            throw new DatabaseException(e);
        }

    }

    @SuppressWarnings("unchecked")
    public <T> T update(final T object) throws IllegalArgumentException, IllegalAccessException {

        int index = 1;
        Field[] fs = object.getClass().getDeclaredFields();
        fs[0].setAccessible(true);
        Integer id = (Integer) fs[0].get(object);

        int lenfilds = fs.length;

        StringBuilder bulderFilers = new StringBuilder();

        Object[] fildesValues = new Object[lenfilds];

        for (; index < lenfilds; index++) {
            Field f = object.getClass().getDeclaredFields()[index];
            f.setAccessible(true);
            fildesValues[index] = f.get(object);
            bulderFilers.append(f.getName().concat(" = ?,"));
        }
        bulderFilers.deleteCharAt(bulderFilers.length() - 1);

        String sql = "update "
                + object.getClass().getSimpleName().toLowerCase() + " set "
                + bulderFilers.toString() + " where id = ?";

        try {

            stm = con.prepareStatement(sql);

            stm.setLong(index, id);

            for (int i = 1; i < index; i++) {
                if (fildesValues[i].getClass().isEnum()) {
                    stm.setObject(i, fildesValues[i].toString());
                    continue;
                }
                stm.setObject(i, fildesValues[i]);
            }

            stm.execute();

            return (T) getById(object.getClass(), id);

        } catch (Exception e) {
            DatabaseUtils.closeAll(stm, null);
            throw new DatabaseException(e);
        }

    }

    public <T> T getById(final Class<T> type, final Object id) {
        ResultSet rs = null;
        try {
            T newInstance = type.newInstance();

            stm = con.prepareStatement("select * from "
                    + newInstance.getClass().getSimpleName().toLowerCase()
                    + " where id=?");

            stm.setObject(1, id);

            rs = stm.executeQuery();

            if (rs.next()) {
                for (int i = 0; i < newInstance.getClass().getDeclaredFields().length; i++) {
                    Field f = newInstance.getClass().getDeclaredFields()[i];
                    f.setAccessible(true);
                    System.out.println(f);
                    f.set(newInstance, rs.getObject(f.getName()));
                }
                return newInstance;
            }

        } catch (Exception e) {
            DatabaseUtils.closeAll(stm, rs);
            throw new DatabaseException(e);
        }
        return null;

    }

    public <T> List<T> getAll(final Class<T> type) {
        List<T> results = new ArrayList<>();
        ResultSet rs = null;
        try {
            stm = con.prepareStatement("select * from "
                    + type.getSimpleName().toLowerCase());

            rs = stm.executeQuery();
            while (rs.next()) {

                T newInstance = type.newInstance();

                for (int i = 0; i < newInstance.getClass().getDeclaredFields().length; i++) {
                    Field f = newInstance.getClass().getDeclaredFields()[i];
                    f.setAccessible(true);
                    f.set(newInstance, rs.getObject(f.getName()));
                }
                results.add(newInstance);
            }

            return results;
        } catch (Exception e) {
            DatabaseUtils.closeAll(stm, rs);
            throw new DatabaseException(e);
        }
    }

    public <T> long count(final Class<T> type) {
        ResultSet rs = null;
        try {
            T newInstance = type.newInstance();

            stm = con.prepareStatement("select count(*) as total from "
                    + newInstance.getClass().getSimpleName().toLowerCase());
            rs = stm.executeQuery();
            int count = 0;
            while (rs.next()) {
                count += rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            DatabaseUtils.closeAll(stm, rs);
            throw new DatabaseException(e);
        }
    }

    public <T> Boolean delete(T object) {

        try {

            Field field = object.getClass().getDeclaredField("id");
            field.setAccessible(true);
            ID id = (ID) field.get(object);

            if (getById(object.getClass(), id) != null) {
                stm = con.prepareStatement("delete from "
                        + object.getClass().getSimpleName().toLowerCase()
                        + " " + "where id = ?");

                stm.setLong(1, id.getId());
                stm.execute();

                return Boolean.TRUE;
            }

        } catch (Exception e) {
            DatabaseUtils.closeAll(stm, null);
            throw new DatabaseException(e);
        }
        return Boolean.FALSE;
    }
}
