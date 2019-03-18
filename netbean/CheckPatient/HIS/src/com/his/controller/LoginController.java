/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his.controller;

import com.his.model.daoimpl.LoginDAOImpl;
import com.his.model.entity.Login;

/**
 *
 * @author DinhThap
 */
public class LoginController {
    LoginDAOImpl dao = new LoginDAOImpl();

    public LoginController() {
        
    }
    
    public boolean checkUserExists(Login login) throws Exception{
        Long count = dao.countAllForInput(login);
        if(count == 1){
            return true;
        }else{
            return false;
        }
    }
    
}
