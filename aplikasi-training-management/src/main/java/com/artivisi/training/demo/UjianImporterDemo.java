/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.demo;

import com.artivisi.training.dao.UjianDao;
import com.artivisi.training.domain.Ujian;
import com.artivisi.training.importer.UjianImporter;
import java.io.File;
import java.util.List;

/**
 *
 * @author CEISA12_2
 */
public class UjianImporterDemo {
    public static void main(String[] args) {
        File f = new File("src/main/resources/ujian.csv");
        
        List<Ujian> hasilImport = UjianImporter.proses(f);
//        UjianDao ud = new UjianDao();
        System.out.println("===== HASIL IMPORT =====");
        for (Ujian ujian : hasilImport) {
            System.out.println("Tanggal Diselenggarakan : "+ujian.getTanggalDiselenggarakan());
            System.out.println("-------------------------------------");
//            ud.simpan(ujian);
        }
    }
}
