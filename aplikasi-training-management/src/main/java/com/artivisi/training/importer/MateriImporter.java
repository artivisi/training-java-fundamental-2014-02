package com.artivisi.training.importer;

import com.artivisi.training.domain.HasilImportMateri;
import com.artivisi.training.domain.ImportError;
import com.artivisi.training.domain.Materi;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;

public class MateriImporter {
    public static HasilImportMateri proses(File f){
        try {
            List<Materi> sukses = new ArrayList<Materi>();
            List<ImportError> gagal = new ArrayList<ImportError>();
            HasilImportMateri hasil = new HasilImportMateri();
            hasil.setSukses(sukses);
            hasil.setGagal(gagal);
            
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String data = br.readLine();
            
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
            
            Integer noBaris = 1;
            
            while((data = br.readLine()) != null) {
                noBaris++;
                System.out.println("Data : "+data);
                String[] kolom = data.split(",");
                System.out.println("Jumlah kolom : "+kolom.length);
                
                if(kolom.length != 2) {
                    ImportError eror = new ImportError();
                    eror.setBaris(noBaris);
                    eror.setData(data);
                    eror.setKeterangan("Jumlah field salah " +kolom.length);
                    gagal.add(eror);
                    continue;
                }
                
                Materi m = new Materi();
                m.setKode(kolom[0]);
                m.setNama(kolom[1]);
                
                sukses.add(m);
            }
            br.close();
            return hasil;    
        } catch (Exception e) {
            Logger.getLogger(MateriImporter.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
}
