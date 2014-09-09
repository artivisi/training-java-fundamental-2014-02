package com.artivisi.training.demo;

import com.artivisi.training.dao.PesertaDao;
import com.artivisi.training.domain.Peserta;
import java.util.Date;

public class PesertaDaoDemo {
    public static void main(String[] args) {
        Peserta p = new Peserta();
        p.setKode("P-001");
        p.setNama("Peserta 001");
        p.setEmail("p1@gmail.com");
        p.setTanggalBergabung(new Date());
        
        PesertaDao pd = new PesertaDao();
        pd.simpan(p);
    }
}
