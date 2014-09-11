/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.domain;

/**
 *
 * @author CEISA-DJBC
 */
public class Pertanyaan {

    private Integer id;
    private String isi;
    private Materi materi;
    private String tingkatKesulitan;
    
    public Pertanyaan(){
        
    }
    
    public Integer getId() {
        Peserta p = new Peserta();
        p.setNama("Endy");
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public Materi getMateri() {
        return materi;
    }

    public void setMateri(Materi materi) {
        this.materi = materi;
    }

    public String getTingkatKesulitan() {
        return tingkatKesulitan;
    }

    public void setTingkatKesulitan(String tingkatKesulitan) {
        this.tingkatKesulitan = tingkatKesulitan;
    }
}
