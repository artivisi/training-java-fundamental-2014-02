/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.com.id.djbc;

import java.util.Date;

/**
 *
 * @author Andi Zulkifli
 */
public class Batch {
    private int id;
    private Materi materi;
    private Date tglMulai;
    private Date tglSelesai;
    private String status;

    public Batch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Materi getMateri() {
        return materi;
    }

    public void setMateri(Materi materi) {
        this.materi = materi;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTglMulai() {
        return tglMulai;
    }

    public void setTglMulai(Date tglMulai) {
        this.tglMulai = tglMulai;
    }

    public Date getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(Date tglSelesai) {
        this.tglSelesai = tglSelesai;
    }
    
}
