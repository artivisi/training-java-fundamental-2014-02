/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.dao;

import com.artivisi.training.domain.Ujian;
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
 * @author CEISA12_2
 */
public class UjianDao {

    private static final String SQL_INSERT
            = "insert into ujian (tanggal_diselenggarakan)"
            + "values(?)";

    private static final String SQL_UPDATE
            = "update ujian set tangal_diselenggarakan = ? where id = ?";

    private static final String SQL_SELECT_BY_ID
            = "select * from ujian where id = ?";

    private static final String SQL_DELETE_BY_ID
            = "delete from ujian where id = ?";

    private static final String SQL_SELECT_ALL
            = "select * from ujian";

    public void simpan(Ujian u) {
        try {
            Connection c = KoneksiHelper.bukaKoneksi();
            if (u.getId() == null) {
                PreparedStatement ps = c.prepareStatement(SQL_INSERT);
                ps.setDate(1, new java.sql.Date(u.getTanggalDiselenggarakan().getTime()));
                ps.executeUpdate();
            } else {
                PreparedStatement ps = c.prepareStatement(SQL_UPDATE);
                ps.setDate(1, new java.sql.Date(u.getTanggalDiselenggarakan().getTime()));
                ps.setInt(2, u.getId());
                ps.executeUpdate();
            }
            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(UjianDao.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void hapus(Ujian u) {
        try {
            Connection c = KoneksiHelper.bukaKoneksi();
            PreparedStatement ps = c.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, u.getId());
            ps.executeUpdate();
            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(UjianDao.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public Ujian cariById(Integer id) {
        Ujian u = null;
        try {
            Connection c = KoneksiHelper.bukaKoneksi();
            PreparedStatement ps = c.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = konversiResultSetKeUjian(rs);
            }
            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(UjianDao.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return u;
    }

    public List<Ujian> cariSemua() {
        try {
            List<Ujian> hasil = new ArrayList<Ujian>();
            Connection c = KoneksiHelper.bukaKoneksi();
            PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ujian u = konversiResultSetKeUjian(rs);
                hasil.add(u);

            }
            KoneksiHelper.tutupKoneksi(c);
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(UjianDao.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return null;
    }

    private Ujian konversiResultSetKeUjian(ResultSet rs) throws SQLException {
        Ujian u = new Ujian();
        u.setId(rs.getInt("id"));
        u.setTanggalDiselenggarakan(rs.getDate("tanggal_diselenggarakan"));
        return u;
    }

}
