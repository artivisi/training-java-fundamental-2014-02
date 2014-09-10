/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.dao;

import com.artivisi.training.domain.Materi;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ceisa-djbc
 */
public class MateriDao {
    private static final String SQL_INSERT 
            = "INSERT INTO materi (id,kode,nama) values (materi_id_seq.nextval,?,?)";
    
    private static final String SQL_UPDATE
            = "UPDATE materi set kode = ?, nama = ? WHERE id = ?";
    
    private static final String SQL_SELECT_BY_ID
            = "SELECT * FROM materi WHERE id = ?";
    
    private static final String SQL_DELETE_BY_ID
            = "DELETE FROM materi WHERE id = ?";
    
    private static final String SQL_SELECT_ALL
            = "SELECT * FROM materi";
            
    public void simpan(Materi m) {
        try {
            Connection c = KoneksiHelper.bukaKoneksi();
            
            if (m.getId() == null) {
                PreparedStatement ps = c.prepareStatement(SQL_INSERT);
                ps.setString(1, m.getKode());
                ps.setString(2, m.getNama());
                ps.executeUpdate();
            } else {
                PreparedStatement ps = c.prepareStatement(SQL_UPDATE);
                ps.setString(1, m.getKode());
                ps.setString(2, m.getNama());
                ps.setInt(3, m.getId());
                ps.executeUpdate();
            }
            KoneksiHelper.tutupKoneksi(c);
        } catch (Exception e) {
            Logger.getLogger(MateriDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public void hapus(Materi m) {
        try {
            Connection c = KoneksiHelper.bukaKoneksi();
            PreparedStatement ps = c.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, m.getId());
            ps.executeUpdate();
            
            KoneksiHelper.tutupKoneksi(c);
        } catch (Exception e) {
            Logger.getLogger(MateriDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public Materi cariById(Integer id) {
        Materi p = null;
        try {
            Connection c = KoneksiHelper.bukaKoneksi();

            PreparedStatement ps = c.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = konversiResultSetKeMateri(rs);
            }

            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(MateriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public List<Materi> cariSemua() {
        try {
            List<Materi> hasil = new ArrayList<Materi>();
            
            Connection c = KoneksiHelper.bukaKoneksi();
            
            PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materi p = konversiResultSetKeMateri(rs);
                hasil.add(p);
            }
            
            KoneksiHelper.tutupKoneksi(c);
            
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(MateriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private Materi konversiResultSetKeMateri(ResultSet rs) throws SQLException {
        Materi m = new Materi();
        m.setId(rs.getInt("id"));
        m.setKode(rs.getString("kode"));
        m.setNama(rs.getString("nama"));
        return m;
    }
    
}
