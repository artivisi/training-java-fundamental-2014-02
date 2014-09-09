/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.com.id.djbc;

/**
 *
 * @author Andi Zulkifli
 */
public class Pertanyaan {
    private int id;
    private String isi;
    private Materi materi;
    private String tingkatKesulitan;

    public Pertanyaan() {
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
