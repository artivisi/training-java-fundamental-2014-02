/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.dao;

import com.artivisi.training.domain.Catatan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA3
 */
public class CatatanDao {

    private static final String SQL_INSERT
            = "insert into catatan (id,isi, judul, no_urut, terakhir_update) "
            + "values(catatan_id_seq.nextval,?,?,?,?)";

    private static final String SQL_UPDATE
            = "update catatan set isi = ?,"
            + "judul = ?, no_urut = ?,"
            + "terakhir_update = ? "
            + "where id = ?";

    private static final String SQL_SELECT_BY_ID
            = "select * from catatan where id = ?";

    private static final String SQL_DELETE_BY_ID
            = "delete from catatan where id = ?";

    private static final String SQL_SELECT_ALL
            = "select * from catatan";

    public void simpan(Catatan ct) {
        try {
            Connection c = KoneksiHelper.bukaKoneksi();

            if (ct.getId() == null) {
                PreparedStatement ps = c.prepareStatement(SQL_INSERT);
                ps.setString(1, ct.getIsi());
                ps.setString(2, ct.getJudul());
                ps.setInt(3, ct.getNoUrut());
                ps.setDate(4, new java.sql.Date(ct.getTerakhirUpdate().getTime()));
                ps.executeUpdate();
            } else {
                PreparedStatement ps = c.prepareStatement(SQL_UPDATE);
                ps.setString(1, ct.getIsi());
                ps.setString(2, ct.getJudul());
                ps.setInt(3, ct.getNoUrut());
                ps.setDate(4, new java.sql.Date(ct.getTerakhirUpdate().getTime()));
                ps.setInt(5, ct.getId());
                ps.executeUpdate();
            }

            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapus(Catatan ct) {
        try {
            Connection c = KoneksiHelper.bukaKoneksi();
            PreparedStatement ps = c.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, ct.getId());
            ps.executeUpdate();

            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Catatan cariById(Integer id) {
        Catatan ct = null;
        try {
            Connection c = KoneksiHelper.bukaKoneksi();

            PreparedStatement ps = c.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ct = konversiResultSetKeCatatan(rs);
            }

            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ct;
    }

    
    public List<Catatan> cariSemua() {
        try {
            List<Catatan> hasil = new ArrayList<Catatan>();

            Connection c = KoneksiHelper.bukaKoneksi();

            PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Catatan ct = konversiResultSetKeCatatan(rs);
                hasil.add(ct);
            }

            KoneksiHelper.tutupKoneksi(c);
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private Catatan konversiResultSetKeCatatan(ResultSet rs) throws SQLException {
        Catatan ct = new Catatan();
        ct.setId(rs.getInt("id"));
        ct.setIsi(rs.getString("isi"));
        ct.setJudul(rs.getString("judul"));
        ct.setNoUrut(rs.getInt("no_urut"));
        ct.setTerakhirUpdate(rs.getDate("terakhir_update"));
        return ct;
    }
}
