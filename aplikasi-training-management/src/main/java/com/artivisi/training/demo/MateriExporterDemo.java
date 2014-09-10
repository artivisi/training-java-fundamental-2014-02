package com.artivisi.training.demo;

import java.util.List;
import com.artivisi.training.dao.MateriDao;
import com.artivisi.training.domain.Materi;
import com.artivisi.training.exporter.MateriExporter;

public class MateriExporterDemo {
    public static void main(String[] args) {
        MateriDao md = new MateriDao();
        List<Materi> data = md.cariSemua();
        MateriExporter.export(data, "target/materi-output.csv");
    }
}