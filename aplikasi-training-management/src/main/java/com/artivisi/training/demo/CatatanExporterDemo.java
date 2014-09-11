/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.demo;

import com.artivisi.training.dao.CatatanDao;
import com.artivisi.training.domain.Catatan;
import com.artivisi.training.exporter.CatatanExporter;
import java.util.List;

/**
 *
 * @author CEISA3
 */
public class CatatanExporterDemo {
    public static void main(String[] args){
        CatatanDao cd = new CatatanDao();
        List<Catatan> data = cd.cariSemua();
        CatatanExporter.export(data, "target/catatan-output.csv");
    }
}
