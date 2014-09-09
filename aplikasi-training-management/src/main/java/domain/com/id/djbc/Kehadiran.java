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
public class Kehadiran {
    private int id;
    private Date tgl;
    private Peserta peserta;
    private Batch batch;

    public Kehadiran() {
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Peserta getPeserta() {
        return peserta;
    }

    public void setPeserta(Peserta peserta) {
        this.peserta = peserta;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }
    
}
