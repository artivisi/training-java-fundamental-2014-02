/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.com.id.djbc;

/**
 *
 * @author Andi Zulkifli
 */
public class Institusi {
    private Integer id;
    private String kode;
    private String nama;
    private String alamat;
    private String telpon;
    private String website;

    public Institusi() {
    }

    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

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

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    
    
}
