/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi2.projects.biblio.model.dao;

import java.sql.*;

/**
 *
 * @author Dell
 */
public class Connexion {
    private static Connection con;
    private Connexion(){};
    public static Connection getConnexion(){
        if(con==null){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
            
        }
        catch(ClassNotFoundException e){
            System.err.println(e.getMessage());
            return null;
        }
        
       catch(SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        }
        return  con;
    }
    

}
