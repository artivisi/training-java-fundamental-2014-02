/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.demo;

import com.artivisi.training.domain.Catatan;
import com.artivisi.training.importer.CatatanImporter;
import java.io.File;
import java.util.List;

/**
 *
 * @author CEISA3
 */
public class CatatanImporterDemo {
    public static void main(String[] args){
        File f = new File("src/main/resources/catatan.csv");
        
        List<Catatan> hasilImport = CatatanImporter.proses(f);
        System.out.println("===== Hasil Import =====");
        for (Catatan catatan : hasilImport) {
            System.out.println("Isi : "+catatan.getIsi());
            System.out.println("Judul : "+catatan.getJudul());
            System.out.println("No Urut : "+catatan.getNoUrut());
            System.out.println("Terakhir Update : "+catatan.getTerakhirUpdate());
            System.out.println("---------------------------");
        }
        
    }
}
