/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.importer;

import com.artivisi.training.domain.HasilImportInstitusi;
import com.artivisi.training.domain.ImportError;
import com.artivisi.training.domain.Institusi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ceisa-djbc
 */
public class InstitusiImporter {
    public static HasilImportInstitusi proses(File f){
        try {
            List<Institusi> sukses = new ArrayList<Institusi>();
            List<ImportError> gagal = new ArrayList<ImportError>();
            HasilImportInstitusi hasil = new HasilImportInstitusi();
            hasil.setSukses(sukses);
            hasil.setGagal(gagal);
            
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String data = br.readLine(); // tidak diproses, header
            
           
            
            Integer noBaris = 1;
            // selama tidak null (ada data), proses
            while((data = br.readLine()) != null){
                noBaris++;
                System.out.println("Data : "+data);
                String[] kolom = data.split(",");
                System.out.println("Jumlah kolom : "+kolom.length);
                
                if(kolom.length != 5){
                    ImportError err = new ImportError();
                    err.setBaris(noBaris);
                    err.setData(data);
                    err.setKeterangan("Jumlah field salah, seharusnya ada 5 field, ternyata ada "+kolom.length);
                    gagal.add(err);
                    continue;
                }
                
                Institusi i = new Institusi();
                i.setKode(kolom[0]);
                i.setNama(kolom[1]);
                i.setAlamat(kolom[2]);
                i.setTelepon(kolom[3]);
                i.setWebsite(kolom[4]);
//                try {
//                   
//                } catch (ParseException ex) {
//                    Logger.getLogger(InstitusiImporter.class.getName()).log(Level.SEVERE, null, ex);
//                    ImportError err = new ImportError();
//                    err.setBaris(noBaris);
//                    err.setData(data);
//                    err.setKeterangan("Format penulisan salah, seharusnya INS-No Urut Instansi");
//                    gagal.add(err);
//                    continue;
//                }
                sukses.add(i);
            }
            
            br.close();
            
            return hasil;
        } catch (IOException ex) {
            Logger.getLogger(InstitusiImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
