package com.artivisi.training.demo;

import com.artivisi.training.dao.MateriDao;
import com.artivisi.training.domain.HasilImportMateri;
import com.artivisi.training.domain.ImportError;
import com.artivisi.training.domain.Materi;
import com.artivisi.training.importer.MateriImporter;
import java.io.File;
import java.util.List;

public class MateriImporterDemo {
    public static void main(String[] args) {
        File f = new File("src/main/resources/materi.csv");
        
        HasilImportMateri hasilImport = MateriImporter.proses(f);
        
        MateriDao md = new MateriDao();
        System.out.println("===== Hasil Import Sukses =====");
        for (Materi materi : hasilImport.getSukses()) {
            System.out.println("Kode : "+materi.getKode());
            System.out.println("Nama : "+materi.getNama());
            System.out.println("---------------------------");
            md.simpan(materi);
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
