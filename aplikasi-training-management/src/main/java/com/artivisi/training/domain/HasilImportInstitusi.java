/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.training.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ceisa-djbc
 */
public class HasilImportInstitusi {
    private List<Institusi> sukses = new ArrayList<Institusi>();
    private List<ImportError> gagal = new ArrayList<ImportError>();

    public List<Institusi> getSukses() {
        return sukses;
    }

    public void setSukses(List<Institusi> sukses) {
        this.sukses = sukses;
    }

    public List<ImportError> getGagal() {
        return gagal;
    }

    public void setGagal(List<ImportError> gagal) {
        this.gagal = gagal;
    }
}
