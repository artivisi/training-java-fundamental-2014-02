/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.exporter;

import com.artivisi.training.domain.Institusi;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ceisa-djbc
 */
public class InstitusiExporter {
    public static File export(List<Institusi> data, String lokasiFile){
        try {
            File tujuan = new File(lokasiFile);
            
            FileWriter fw = new FileWriter(tujuan);
            String header = "id,kode,nama,alamat,telepon,website";
            fw.write(header);
            fw.write("\r\n");
            
            
            for (Institusi institusi : data) {
                fw.write(institusi.getId().toString());
                fw.write(",");
                fw.write(institusi.getKode());
                fw.write(",");
                fw.write(institusi.getNama());
                fw.write(",");
                fw.write(institusi.getAlamat());
                fw.write(",");
                fw.write(institusi.getTelepon());
                fw.write(",");
                fw.write(institusi.getWebsite());
                fw.write("\r\n");
            }
            
            fw.close();
            
            return tujuan;
        } catch (IOException ex) {
            Logger.getLogger(InstitusiExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
