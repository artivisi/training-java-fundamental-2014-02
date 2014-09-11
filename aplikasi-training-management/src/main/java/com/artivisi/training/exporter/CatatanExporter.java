/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.exporter;

import com.artivisi.training.domain.Catatan;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA3
 */
public class CatatanExporter {

    public static File export(List<Catatan> data, String lokasiFile) {
        try {
            File tujuan = new File(lokasiFile);

            FileWriter fw = new FileWriter(tujuan);
            String header = "id, isi, judul, no_urut, terakhir_update";
            fw.write(header);
            fw.write("\r\n");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            for (Catatan catatan : data) {
                fw.write(catatan.getId().toString());
                fw.write(",");
                fw.write(catatan.getIsi());
                fw.write(",");
                fw.write(catatan.getJudul());
                fw.write(",");
                fw.write(catatan.getNoUrut());
                fw.write(",");
                fw.write(formatter.format(catatan.getTerakhirUpdate()));
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
