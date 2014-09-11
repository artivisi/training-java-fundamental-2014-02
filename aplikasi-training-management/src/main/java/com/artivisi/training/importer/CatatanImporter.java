/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.importer;

import com.artivisi.training.domain.Catatan;
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
 * @author CEISA3
 */
public class CatatanImporter {

    public static List<Catatan> proses(File f) {
        try {
            List<Catatan> hasil = new ArrayList<Catatan>();

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String data = br.readLine();

            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

            while ((data = br.readLine()) != null) {
                System.out.println("Data : " + data);
                String[] kolom = data.split(",");
                System.out.println("Jumlah kolom : " + kolom.length);
                Catatan ct = new Catatan();
                ct.setIsi(kolom[0]);
                ct.setJudul(kolom[1]);
                ct.setNoUrut(Integer.parseInt(kolom[2]));
                try {
                    ct.setTerakhirUpdate(parser.parse(kolom[3]));
                } catch (ParseException ex) {
                    Logger.getLogger(PesertaImporter.class.getName()).log(Level.SEVERE, null, ex);
                }
                hasil.add(ct);
            }
            br.close();

            return hasil;
        } catch (IOException ex) {
            Logger.getLogger(PesertaImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
