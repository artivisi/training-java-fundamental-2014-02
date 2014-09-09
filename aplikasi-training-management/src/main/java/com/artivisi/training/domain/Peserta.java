package com.artivisi.training.domain;

import java.util.Date;

public class Peserta {
    private Integer id;
    private String kode;
    private String nama;
    private String email;
    private Institusi institusi;
    private Date tanggalBergabung;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Institusi getInstitusi() {
        return institusi;
    }

    public void setInstitusi(Institusi institusi) {
        this.institusi = institusi;
    }

    public Date getTanggalBergabung() {
        return tanggalBergabung;
    }

    public void setTanggalBergabung(Date tanggalBergabung) {
        this.tanggalBergabung = tanggalBergabung;
    }
}
