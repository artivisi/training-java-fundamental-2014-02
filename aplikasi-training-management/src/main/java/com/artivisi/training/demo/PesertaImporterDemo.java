package com.artivisi.training.demo;

import com.artivisi.training.dao.PesertaDao;
import com.artivisi.training.domain.HasilImportPeserta;
import com.artivisi.training.domain.ImportError;
import com.artivisi.training.domain.Peserta;
import com.artivisi.training.importer.PesertaImporter;
import java.io.File;
import java.util.List;

public class PesertaImporterDemo {
    public static void main(String[] args) {
        File f = new File("src/main/resources/peserta.csv");
        
        HasilImportPeserta hasilImport 
                = PesertaImporter.proses(f);
        
        PesertaDao pd = new PesertaDao();
        System.out.println("===== Hasil Import Sukses =====");
        for (Peserta peserta : hasilImport.getSukses()) {
            System.out.println("Kode : "+peserta.getKode());
            System.out.println("Nama : "+peserta.getNama());
            System.out.println("Email : "+peserta.getEmail());
            System.out.println("Tanggal Bergabung : "+peserta.getTanggalBergabung());
            System.out.println("---------------------------");
            pd.simpan(peserta);
        }
        
        System.out.println("===== Hasil Import Gagal =====");
        for (ImportError err : hasilImport.getGagal()) {
            System.out.println("Baris : "+err.getBaris());
            System.out.println("Keterangan : "+err.getKeterangan());
            System.out.println("Data : "+err.getData());
            System.out.println("---------------------------");
        }
    }
}
