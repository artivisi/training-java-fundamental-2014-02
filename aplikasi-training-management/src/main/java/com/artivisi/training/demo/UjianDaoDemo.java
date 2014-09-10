/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.demo;

import com.artivisi.training.dao.UjianDao;
import com.artivisi.training.domain.Ujian;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CEISA12_2
 */
public class UjianDaoDemo {

    public static void main(String[] args) {
        Ujian u = new Ujian();
        u.setId(1);
        u.setTanggalDiselenggarakan(new Date());

        UjianDao ud = new UjianDao();
        ud.simpan(u);

        Ujian ux = ud.cariById(1);
        tampilkanUjian(ux);

        List<Ujian> semuaUjian = ud.cariSemua();
        for (Ujian uz : semuaUjian) {
            tampilkanUjian(uz);
        }
        ud.hapus(ux);
    }

    private static void tampilkanUjian(Ujian ux) {
        System.out.println("ID : " + ux.getId());
        System.out.println("Tanggal Diselenggarakan : " + ux.getTanggalDiselenggarakan());
    }
}
