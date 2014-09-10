/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.importer;

import com.artivisi.training.domain.Ujian;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA12_2
 */
public class UjianImporter {

    public static List<Ujian> proses(File f) {
        try {
            List<Ujian> hasil = new ArrayList<Ujian>();

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String data = br.readLine();

            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

            while ((data = br.readLine()) != null) {
                System.out.println("Data : " + data);
                String[] kolom = data.split(",");
                System.out.println("Jumlah kolom : " + kolom.length);
                Ujian u = new Ujian();
                try {
                    u.setTanggalDiselenggarakan(parser.parse(kolom[0]));
                } catch (ParseException ex) {
                    Logger.getLogger(UjianImporter.class.getName()).log(Level.SEVERE, null, ex);
                }
                hasil.add(u);
            }
            br.close();
            return hasil;
        } catch (IOException ex) {
            Logger.getLogger(UjianImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
