/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.demo;

import com.artivisi.training.dao.CatatanDao;
import com.artivisi.training.domain.Catatan;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CEISA3
 */
public class CatatanDaoDemo {
    public static void main(String[] args) {
        Catatan ct = new Catatan();
        ct.setIsi("Halo ini catatan 2");
        ct.setJudul("Catatan-02");
        ct.setNoUrut(2);
        ct.setTerakhirUpdate(new Date());
        
        CatatanDao cd = new CatatanDao();
        cd.simpan(ct);
        
        Catatan cx = cd.cariById(1);
        tampilkanPeserta(cx);
        
        List<Catatan> semuaPeserta = cd.cariSemua();
        for (Catatan cz : semuaPeserta) {
            tampilkanPeserta(cz);
        }
        
        cd.hapus(cx);
    }
    
    private static void tampilkanPeserta(Catatan cx) {
        System.out.println("ID : "+cx.getId());
        System.out.println("Isi : "+cx.getIsi());
        System.out.println("Judul : "+cx.getJudul());
        System.out.println("No Urut : "+cx.getNoUrut());
        System.out.println("Terakhir Update : "+cx.getTerakhirUpdate());
    }
}
