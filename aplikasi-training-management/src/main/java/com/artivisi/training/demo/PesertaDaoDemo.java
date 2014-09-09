package com.artivisi.training.demo;

import com.artivisi.training.dao.PesertaDao;
import com.artivisi.training.domain.Peserta;
import java.util.Date;

public class PesertaDaoDemo {
    public static void main(String[] args) {
        Peserta p = new Peserta();
        p.setId(1);
        p.setKode("P-001x");
        p.setNama("Peserta 001x");
        p.setEmail("p1x@gmail.com");
        p.setTanggalBergabung(new Date());
        
        PesertaDao pd = new PesertaDao();
        pd.simpan(p);
        
        Peserta px = pd.cariById(1);
        System.out.println("ID : "+px.getId());
        System.out.println("Kode : "+px.getKode());
        System.out.println("Nama : "+px.getNama());
        System.out.println("Email : "+px.getEmail());
        System.out.println("Tanggal Bergabung : "+px.getTanggalBergabung());
    }
}
