/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanminh.model;

import com.vanminh.logger.CLogger;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vanminh
 */
public interface IModel<T> {

    String tableName = null;
    String IDColumnName = null;
    Transaction transaction = null;
    Session session = null;
    boolean isIgnoreLogic = false;
    CLogger logger = CLogger.getLogger(IModel.class.getName());

    default String getFromClause() {
        return "From " + tableName + " t ";
    }

    String getWhereClause();

    default boolean save() {
        logger.debug("save " + tableName);
        if (session == null) {
            logger.error("Session is null!");
            return false;
        }

        boolean isOK = true;
        if (isOK) {
            isOK = beforeSave();
        }
        
        session.persist(this);

        if (isOK) {
            isOK = afterSave();
        }
        return isOK;
    }

    boolean beforeSave();

    boolean afterSave();

    default boolean delete() {
        logger.debug("delete " + tableName);
        if (session == null) {
            logger.error("Session is null!");
            return false;
        }

        boolean isOK = true;
        if (isOK) {
            isOK = beforeDelete();
        }

        if (isOK) {
            isOK = afterDelete();
        }
        return isOK;
    }

    boolean beforeDelete();

    boolean afterDelete();
}
