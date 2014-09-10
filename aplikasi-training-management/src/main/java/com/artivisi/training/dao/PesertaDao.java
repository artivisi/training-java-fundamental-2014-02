package com.artivisi.training.dao;

import com.artivisi.training.domain.Institusi;
import com.artivisi.training.domain.Peserta;
import com.artivisi.training.exception.DataTidakAdaException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PesertaDao {
    // Oracle pakai sequence
    // private static final String SQL_INSERT
    //        = "insert into peserta (id,kode, nama, email, tanggal_bergabung) "
    //        + "values(peserta_id_seq.nextval,?,?,?,?)";

    // MySQL tidak pakai sequence
    private static final String SQL_INSERT
            = "insert into peserta (kode, nama, email, tanggal_bergabung, id_institusi) "
            + "values(?,?,?,?,?)";

    private static final String SQL_UPDATE
            = "update peserta set kode = ?,"
            + "nama = ?, email = ?,"
            + "tanggal_bergabung = ? "
            + "id_institusi = ? "
            + "where id = ?";

    private static final String SQL_SELECT_BY_ID
            = "select " +
            "p.*, " +
            "i.kode as institusi_kode, i.nama as institusi_nama, " +
            "i.alamat, i.telepon, i.website " +
            "from peserta p " +
            "inner join institusi i " +
            "on p.id_institusi = i.id " +
            "where p.id = ?";
    
    private static final String SQL_DELETE_BY_ID
            = "delete from peserta where id = ?";

    private static final String SQL_SELECT_ALL
            = "select " +
            "p.id, p.kode, p.nama, p.email, p.tanggal_bergabung, p.id_institusi, " +
            "i.id as institusi_id, i.kode as institusi_kode, i.nama as institusi_nama, " +
            "i.alamat, i.telepon, i.website " +
            "from peserta p " +
            "inner join institusi i " +
            "on p.id_institusi = i.id ";

    public void simpan(Peserta p) {
        try {
            Connection c = KoneksiHelper.bukaKoneksi();

            if (p.getId() == null) {
                PreparedStatement ps = c.prepareStatement(SQL_INSERT);
                ps.setString(1, p.getKode());
                ps.setString(2, p.getNama());
                ps.setString(3, p.getEmail());
                ps.setDate(4, new java.sql.Date(p.getTanggalBergabung().getTime()));
                ps.setInt(5, p.getInstitusi().getId());
                ps.executeUpdate();
            } else {
                PreparedStatement ps = c.prepareStatement(SQL_UPDATE);
                ps.setString(1, p.getKode());
                ps.setString(2, p.getNama());
                ps.setString(3, p.getEmail());
                ps.setDate(4, new java.sql.Date(p.getTanggalBergabung().getTime()));
                ps.setInt(5, p.getInstitusi().getId());
                ps.setInt(6, p.getId());
                ps.executeUpdate();
            }

            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapus(Peserta p) {
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

    public Peserta cariById(Integer id) {
        Peserta p = null;
        try {
            Connection c = KoneksiHelper.bukaKoneksi();

            PreparedStatement ps = c.prepareStatement(SQL_SELECT_BY_ID);
            System.out.println(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = konversiResultSetKePeserta(rs);
            } else {
                throw new DataTidakAdaException("Peserta dengan id "+id+" tidak ada dalam database");
            }

            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public List<Peserta> cariSemua() {
        try {
            List<Peserta> hasil = new ArrayList<Peserta>();
            
            Connection c = KoneksiHelper.bukaKoneksi();
            
            PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Peserta p = konversiResultSetKePeserta(rs);
                hasil.add(p);
            }
            
            KoneksiHelper.tutupKoneksi(c);
            
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Peserta konversiResultSetKePeserta(ResultSet rs) throws SQLException {
        Peserta p = new Peserta();
        p.setId(rs.getInt("id"));
        p.setKode(rs.getString("kode"));
        p.setNama(rs.getString("nama"));
        p.setEmail(rs.getString("email"));
        p.setTanggalBergabung(rs.getDate("tanggal_bergabung"));
        
        Institusi i = new Institusi();
        i.setId(rs.getInt("id_institusi"));
        i.setKode(rs.getString("institusi_kode"));
        i.setNama(rs.getString("institusi_nama"));
        i.setAlamat(rs.getString("alamat"));
        i.setTelepon(rs.getString("telepon"));
        i.setWebsite(rs.getString("website"));
        
        p.setInstitusi(i);
        return p;
    }
}
