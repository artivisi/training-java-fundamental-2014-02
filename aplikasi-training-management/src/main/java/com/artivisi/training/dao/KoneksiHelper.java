package com.artivisi.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KoneksiHelper {
    private static final String DATABASE_DRIVER 
            = "oracle.jdbc.OracleDriver";
//              = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL
            = "jdbc:oracle:thin:@localhost:1521:xe";
//              = "jdbc:mysql://localhost/pelatihan";
    private static final String DATABASE_USERNAME
            = "pelatihan";
    private static final String DATABASE_PASSWORD
            = "1";
    
    
    public static Connection bukaKoneksi() throws SQLException{
        try {
            Class.forName(DATABASE_DRIVER);
            Connection koneksi 
                    = DriverManager
                            .getConnection(
                                    DATABASE_URL,
                                    DATABASE_USERNAME,
                                    DATABASE_PASSWORD);
            return koneksi;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KoneksiHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void tutupKoneksi(Connection c) throws SQLException{
        c.close();
    }
}
