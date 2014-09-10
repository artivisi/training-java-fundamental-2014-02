/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.demo;

import com.artivisi.training.dao.InstitusiDao;
import com.artivisi.training.domain.Institusi;
import com.artivisi.training.exporter.InstitusiExporter;

import java.util.List;

/**
 *
 * @author ceisa-djbc
 */
public class InstitusiExporterDemo {
    public static void main(String[] args) {
        InstitusiDao pd = new InstitusiDao();
        List<Institusi> data = pd.cariSemua();
        InstitusiExporter.export(data, "target/institusi-output.csv");
    }
}
