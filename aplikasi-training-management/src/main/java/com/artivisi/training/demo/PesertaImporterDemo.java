package com.artivisi.training.demo;

import com.artivisi.training.dao.PesertaDao;
import com.artivisi.training.domain.Peserta;
import com.artivisi.training.importer.PesertaImporter;
import java.io.File;
import java.util.List;

public class PesertaImporterDemo {
    public static void main(String[] args) {
        File f = new File("src/main/resources/peserta.csv");
        
        List<Peserta> hasilImport 
                = PesertaImporter.proses(f);
        
        PesertaDao pd = new PesertaDao();
        System.out.println("===== Hasil Import =====");
        for (Peserta peserta : hasilImport) {
            System.out.println("Kode : "+peserta.getKode());
            System.out.println("Nama : "+peserta.getNama());
            System.out.println("Email : "+peserta.getEmail());
            System.out.println("Tanggal Bergabung : "+peserta.getTanggalBergabung());
            System.out.println("---------------------------");
            pd.simpan(peserta);
        }
    }
}
