/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.demo;

import com.artivisi.training.dao.InstitusiDao;
import com.artivisi.training.domain.HasilImportInstitusi;
import com.artivisi.training.domain.ImportError;
import com.artivisi.training.domain.Institusi;
import com.artivisi.training.importer.InstitusiImporter;

import java.io.File;

/**
 *
 * @author ceisa-djbc
 */
public class InstitusiImporterDemo {
    public static void main(String[] args) {
        File f = new File("src/main/resources/institusi.csv");
        
        HasilImportInstitusi hasilImport 
                = InstitusiImporter.proses(f);
        
        InstitusiDao id = new InstitusiDao();
        System.out.println("===== Hasil Import Sukses =====");
        for (Institusi institusi : hasilImport.getSukses()) {
            System.out.println("Kode : "+institusi.getKode());
            System.out.println("Nama : "+institusi.getNama());
            System.out.println("Alamat :"+institusi.getAlamat());
            System.out.println("Telepon :"+institusi.getTelepon());
            System.out.println("Website :"+institusi.getWebsite());
            System.out.println("---------------------------");
            id.simpan(institusi);
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
