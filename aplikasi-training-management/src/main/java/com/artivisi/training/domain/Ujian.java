/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.domain;

import java.util.Date;

/**
 *
 * @author CEISA-DJBC
 */
public class Ujian {

     private Integer id;
     private Materi materi;
     private Date tanggalDiselenggarakan;
     
     
     public Ujian(){
         
     }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Materi getMateri() {
        return materi;
    }

    public void setMateri(Materi materi) {
        this.materi = materi;
    }

    public Date getTanggalDiselenggarakan() {
        return tanggalDiselenggarakan;
    }

    public void setTanggalDiselenggarakan(Date tanggalDiselenggarakan) {
        this.tanggalDiselenggarakan = tanggalDiselenggarakan;
    }
}
