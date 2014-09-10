package com.artivisi.training.exporter;

import com.artivisi.training.domain.Materi;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class MateriExporter {
    public static File export(List<Materi> data, String lokasiFile){
        try {
            File tujuan = new File(lokasiFile);
            
            FileWriter fw = new FileWriter(tujuan);
            String header = "id,kode,nama";
            fw.write(header);
            fw.write("\r\n");
            
            for(Materi materi : data) {
                fw.write(materi.getId().toString());
                fw.write(",");
                fw.write(materi.getKode());
                fw.write(",");
                fw.write(materi.getNama());
                fw.write("\r\n");
            }
            fw.close();
            return tujuan;
        } catch (Exception e) {
            Logger.getLogger(MateriExporter.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
}
