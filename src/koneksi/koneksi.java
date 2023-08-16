/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class koneksi {
    private Connection koneksi;
    
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Koneksi berhasil");
        }catch(ClassNotFoundException ex){
            System.out.println("Koneksi gagal "+ex);
        }
        
        try{
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_coba","root","");
            System.out.println("Koneksi database berhasil");
        }catch(SQLException ex){
            System.out.println("Koneski database gagal "+ex);
        }
        return koneksi;
    }
}
