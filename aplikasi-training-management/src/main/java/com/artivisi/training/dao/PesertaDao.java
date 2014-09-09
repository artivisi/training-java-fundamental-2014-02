package com.artivisi.training.dao;

import com.artivisi.training.domain.Peserta;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return null;
    }
    
    public List<Peserta> cariSemua(){
        List<Peserta> hasil = new ArrayList<Peserta>();
        
        
        return hasil;
    }
}
