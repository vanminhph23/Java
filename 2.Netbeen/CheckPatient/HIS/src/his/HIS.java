/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package his;

import com.his.model.daoimpl.LoginDAOImpl;
import com.his.model.entity.Login;
import java.sql.SQLException;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author DinhThap
 */
public class HIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        BasicConfigurator.configure();
        // TODO code application logic here
        LoginDAOImpl dao = new LoginDAOImpl();
        
        Login n = new Login("admin", "admin");
        System.out.println(dao.getAllForInput(new Login(), "username", true).size());
        
    }
    
}
