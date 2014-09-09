/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.com.id.djbc;

/**
 *
 * @author Andi Zulkifli
 */
public class Opsi {
    private int id;
    private Pertanyaan pertanyaan;
    private int noUrut;
    private String isi;
    private String benarSalah;

    public Opsi() {
    }

    public String getBenarSalah() {
        return benarSalah;
    }

    public void setBenarSalah(String benarSalah) {
        this.benarSalah = benarSalah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public int getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(int noUrut) {
        this.noUrut = noUrut;
    }

    public Pertanyaan getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(Pertanyaan pertanyaan) {
        this.pertanyaan = pertanyaan;
    }
    
    
}
