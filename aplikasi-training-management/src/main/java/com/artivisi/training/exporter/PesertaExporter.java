package com.artivisi.training.exporter;

import com.artivisi.training.domain.Peserta;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PesertaExporter {
    public static File export(List<Peserta> data, String lokasiFile){
        try {
            File tujuan = new File(lokasiFile);
            
            FileWriter fw = new FileWriter(tujuan);
            String header = "id,kode,nama,email,tanggalBergabung";
            fw.write(header);
            fw.write("\r\n");
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            
            for (Peserta peserta : data) {
                fw.write(peserta.getId().toString());
                fw.write(",");
                fw.write(peserta.getKode());
                fw.write(",");
                fw.write(peserta.getNama());
                fw.write(",");
                fw.write(peserta.getEmail());
                fw.write(",");
                fw.write(formatter.format(peserta.getTanggalBergabung()));
                fw.write("\r\n");
            }
            
            fw.close();
            
            return tujuan;
        } catch (IOException ex) {
            Logger.getLogger(PesertaExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
