package com.artivisi.training.demo;

import com.artivisi.training.dao.MateriDao;
import com.artivisi.training.domain.Materi;
import java.util.List;

public class MateriDaoDemo {
    public static void main(String[] args) {
        Materi m = new Materi();
        //p.setId(1);
        m.setKode("M-001");
        m.setNama("Java Fundamental");
        
        MateriDao md = new MateriDao();
        md.simpan(m);
        
        Materi mx = md.cariById(1);
        tampilkanMateri(mx);
        
        List<Materi> semuaPeserta = md.cariSemua();
        for (Materi mz : semuaPeserta) {
            tampilkanMateri(mz);
        }
        
        md.hapus(mx);
    }

    private static void tampilkanMateri(Materi mx) {
        System.out.println("ID : "+mx.getId());
        System.out.println("Kode : "+mx.getKode());
        System.out.println("Nama : "+mx.getNama());
    }
    
}
