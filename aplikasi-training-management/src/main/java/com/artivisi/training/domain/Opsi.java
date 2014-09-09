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
public class Opsi {
    private Integer id;
    private Pertanyaan idPertanyaan;
    private Integer noUrut;
    private String isi;
    private Boolean benarSalah;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pertanyaan getIdPertanyaan() {
        return idPertanyaan;
    }

    public void setIdPertanyaan(Pertanyaan idPertanyaan) {
        this.idPertanyaan = idPertanyaan;
    }

    public Integer getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(Integer noUrut) {
        this.noUrut = noUrut;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public Boolean isBenarSalah() {
        return benarSalah;
    }

    public void setBenarSalah(Boolean benarSalah) {
        this.benarSalah = benarSalah;
    }
    
    
}
