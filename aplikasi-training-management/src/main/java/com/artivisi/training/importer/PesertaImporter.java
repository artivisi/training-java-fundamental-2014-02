package com.artivisi.training.importer;

import com.artivisi.training.domain.Peserta;
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

public class PesertaImporter {
    public static List<Peserta> proses(File f){
        try {
            List<Peserta> hasil = new ArrayList<Peserta>();
            
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String data = br.readLine(); // tidak diproses, header
            
            SimpleDateFormat parser
                    = new SimpleDateFormat("yyyy-MM-dd");
            
            // selama tidak null (ada data), proses
            while((data = br.readLine()) != null){
                System.out.println("Data : "+data);
                String[] kolom = data.split(",");
                System.out.println("Jumlah kolom : "+kolom.length);
                Peserta p = new Peserta();
                p.setKode(kolom[0]);
                p.setNama(kolom[1]);
                p.setEmail(kolom[2]);
                try {
                    p.setTanggalBergabung(parser.parse(kolom[3]));
                } catch (ParseException ex) {
                    Logger.getLogger(PesertaImporter.class.getName()).log(Level.SEVERE, null, ex);
                }
                hasil.add(p);
            }
            
            br.close();
            
            return hasil;
        } catch (IOException ex) {
            Logger.getLogger(PesertaImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
