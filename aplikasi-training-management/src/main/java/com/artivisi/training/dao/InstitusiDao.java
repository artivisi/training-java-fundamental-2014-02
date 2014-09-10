package com.artivisi.training.dao;

import com.artivisi.training.domain.Institusi;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ceisa-djbc-Susilawati 
 */

public class InstitusiDao {
    // Oracle pakai sequence
     private static final String SQL_INSERT
            = "insert into institusi (id,kode, nama, alamat, telepon, website) "
            + "values(institusi_id_seq.nextval,?,?,?,?,?)";

    private static final String SQL_UPDATE
            = "update institusi set kode = ?,"
            + "nama = ?, alamat = ?,"
            + "telepon = ?, website = ?,"
            + "where id = ?";

    private static final String SQL_SELECT_BY_ID
            = "select * from institusi where id = ?";
    
    private static final String SQL_DELETE_BY_ID
            = "delete from institusi where id = ?";

    private static final String SQL_SELECT_ALL
            = "select * from institusi";

    public void simpan(Institusi i) {
        try {
            Connection c = KoneksiHelper.bukaKoneksi();

            if (i.getId() == null) {
                PreparedStatement ps = c.prepareStatement(SQL_INSERT);
                ps.setString(1, i.getKode());
                ps.setString(2, i.getNama());
                ps.setString(3, i.getAlamat());
                ps.setString(4, i.getTelepon());
                ps.setString(5, i.getWebsite());
                ps.executeUpdate();
            } else {
                PreparedStatement ps = c.prepareStatement(SQL_UPDATE);
                ps.setString(1, i.getKode());
                ps.setString(2, i.getNama());
                ps.setString(3, i.getAlamat());
                ps.setString(4, i.getTelepon());
                ps.setString(5, i.getWebsite());
                ps.setInt(6,i.getId());
                ps.executeUpdate();
            }

            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapus(Institusi p) {
        try {
            Connection c = KoneksiHelper.bukaKoneksi();
            PreparedStatement ps = c.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, p.getId());
            ps.executeUpdate();
            
            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Institusi cariById(Integer id) {
        Institusi i = null;
        try {
            Connection c = KoneksiHelper.bukaKoneksi();

            PreparedStatement ps = c.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = konversiResultSetKeInstitusi(rs);
            }

            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public List<Institusi> cariSemua() {
        try {
            List<Institusi> hasil = new ArrayList<Institusi>();
            
            Connection c = KoneksiHelper.bukaKoneksi();
            
            PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Institusi i = konversiResultSetKeInstitusi(rs);
                hasil.add(i);
            }
            
            KoneksiHelper.tutupKoneksi(c);
            
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Institusi konversiResultSetKeInstitusi(ResultSet rs) throws SQLException{
        Institusi i = new Institusi();
        i.setId(rs.getInt("id"));
        i.setKode(rs.getString("kode"));
        i.setNama(rs.getString("nama"));
        i.setTelepon(rs.getString("telepon"));
        i.setWebsite(rs.getString("website"));
        
        return i;
        
    }
}
