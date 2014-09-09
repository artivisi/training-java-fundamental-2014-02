package com.artivisi.training.dao;

import com.artivisi.training.domain.Peserta;
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
            = "insert into peserta (kode, nama, email, tanggal_bergabung) "
            + "values(?,?,?,?)";
    
    private static final String SQL_UPDATE
            = "update peserta set kode = ?,"
            + "nama = ?, email = ?,"
            + "tanggal_bergabung = ? "
            + "where id = ?";
    
    private static final String SQL_SELECT_BY_ID
            = "select * from peserta where id = ?";
    
    public void simpan(Peserta p){
        try {
            Connection c = KoneksiHelper.bukaKoneksi();
            
            if(p.getId() == null) {
                PreparedStatement ps = c.prepareStatement(SQL_INSERT);
                ps.setString(1, p.getKode());
                ps.setString(2, p.getNama());
                ps.setString(3, p.getEmail());
                ps.setDate(4, new java.sql.Date(p.getTanggalBergabung().getTime()));
                ps.executeUpdate();
            } else {
                PreparedStatement ps = c.prepareStatement(SQL_UPDATE);
                ps.setString(1, p.getKode());
                ps.setString(2, p.getNama());
                ps.setString(3, p.getEmail());
                ps.setDate(4, new java.sql.Date(p.getTanggalBergabung().getTime()));
                ps.setInt(5, p.getId());
                ps.executeUpdate();
            }
            
            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapus(Peserta p){
        
    }
    
    public Peserta cariById(Integer id){
        Peserta p = null;
        try {
            Connection c = KoneksiHelper.bukaKoneksi();
            
            PreparedStatement ps = c.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p = new Peserta();
                p.setId(rs.getInt("id"));
                p.setKode(rs.getString("kode"));
                p.setNama(rs.getString("nama"));
                p.setEmail(rs.getString("email"));
                p.setTanggalBergabung(rs.getDate("tanggal_bergabung"));
            }
            
            KoneksiHelper.tutupKoneksi(c);
        } catch (SQLException ex) {
            Logger.getLogger(PesertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public List<Peserta> cariSemua(){
        List<Peserta> hasil = new ArrayList<Peserta>();
        
        
        return hasil;
    }
}
