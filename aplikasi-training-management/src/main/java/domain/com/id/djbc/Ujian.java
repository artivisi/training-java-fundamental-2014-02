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
public class Ujian {
    private int id;
    private Materi materi;
    private Date tglDiselenggarakan;

    public Ujian() {
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

    public Date getTglDiselenggarakan() {
        return tglDiselenggarakan;
    }

    public void setTglDiselenggarakan(Date tglDiselenggarakan) {
        this.tglDiselenggarakan = tglDiselenggarakan;
    }
    
    
}
