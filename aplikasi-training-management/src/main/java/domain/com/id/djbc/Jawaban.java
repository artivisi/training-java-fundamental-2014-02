/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.com.id.djbc;

/**
 *
 * @author Andi Zulk
 */
public class Jawaban {
    private int id;
    private PesertaUjian pesertaUjian;
    private Pertanyaan pertanyaan;
    private Opsi opsi;

    public Jawaban() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Opsi getOpsi() {
        return opsi;
    }

    public void setOpsi(Opsi opsi) {
        this.opsi = opsi;
    }

    public Pertanyaan getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(Pertanyaan pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public PesertaUjian getPesertaUjian() {
        return pesertaUjian;
    }

    public void setPesertaUjian(PesertaUjian pesertaUjian) {
        this.pesertaUjian = pesertaUjian;
    }
    
    
}
