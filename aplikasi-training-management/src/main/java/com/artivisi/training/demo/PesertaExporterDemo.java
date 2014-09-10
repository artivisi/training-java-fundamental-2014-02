package com.artivisi.training.demo;

import java.util.List;
import com.artivisi.training.dao.PesertaDao;
import com.artivisi.training.domain.Peserta;
import com.artivisi.training.exporter.PesertaExporter;

public class PesertaExporterDemo {
    public static void main(String[] args) {
        PesertaDao pd = new PesertaDao();
        List<Peserta> data = pd.cariSemua();
        PesertaExporter.export(data, "target/peserta-output.csv");
    }
}
