package com.artivisi.training.domain;

import java.util.ArrayList;
import java.util.List;

public class HasilImportPeserta {
    private List<Peserta> sukses = new ArrayList<Peserta>();
    private List<ImportError> gagal = new ArrayList<ImportError>();

    public List<Peserta> getSukses() {
        return sukses;
    }

    public void setSukses(List<Peserta> sukses) {
        this.sukses = sukses;
    }

    public List<ImportError> getGagal() {
        return gagal;
    }

    public void setGagal(List<ImportError> gagal) {
        this.gagal = gagal;
    }
    
    
}
