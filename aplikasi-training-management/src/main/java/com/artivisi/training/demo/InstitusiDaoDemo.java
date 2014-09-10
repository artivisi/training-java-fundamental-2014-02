/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.demo;

import com.artivisi.training.dao.InstitusiDao;
import com.artivisi.training.domain.Institusi;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ceisa-djbc-Susilawati 
 */
public class InstitusiDaoDemo {
    public static void main(String[] args) {
        Institusi i = new Institusi();
        //i.setId(1);
        i.setKode("INS-0001");
        i.setNama("Politeknik Telkom");
        i.setAlamat("Bandung");
        i.setTelepon("(022)-756462");
        i.setWebsite("www.politekniktelkom.ac.id");
       
        InstitusiDao id = new InstitusiDao();
        id.simpan(i);
        
        Institusi ix = id.cariById(1);
        tampilkanInstitusi(ix);
        
        List<Institusi> semuaInstitusi = id.cariSemua();
        for (Institusi iz : semuaInstitusi) {
            tampilkanInstitusi(iz);
        }
        
        id.hapus(ix);
    }

    private static void tampilkanInstitusi(Institusi ix) {
        System.out.println("ID : "+ix.getId());
        System.out.println("Kode : "+ix.getKode());
        System.out.println("Nama : "+ix.getNama());
        System.out.println("Email : "+ix.getTelepon());
        System.out.println("Website : "+ix.getWebsite());
    }
}
