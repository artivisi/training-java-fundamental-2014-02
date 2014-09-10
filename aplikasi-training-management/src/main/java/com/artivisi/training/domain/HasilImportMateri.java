package com.artivisi.training.domain;

import java.util.ArrayList;
import java.util.List;

public class HasilImportMateri {
    private List<Materi> sukses = new ArrayList<Materi>();
    private List<ImportError> gagal = new ArrayList<ImportError>();

    public List<Materi> getSukses() {
        return sukses;
    }

    public void setSukses(List<Materi> sukses) {
        this.sukses = sukses;
    }

    public List<ImportError> getGagal() {
        return gagal;
    }

    public void setGagal(List<ImportError> gagal) {
        this.gagal = gagal;
    }
}
