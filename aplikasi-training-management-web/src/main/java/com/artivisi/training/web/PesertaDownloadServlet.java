package com.artivisi.training.web;

import com.artivisi.training.dao.PesertaDao;
import com.artivisi.training.domain.Peserta;
import com.artivisi.training.exporter.PesertaExporter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesertaDownloadServlet extends HttpServlet {

    private PesertaDao dao = new PesertaDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Peserta> dataPeserta = dao.cariSemua();
        
        String lokasiFolderTemp = System.getProperty("java.io.tmpdir");
        System.out.println("Temp Folder : "+lokasiFolderTemp);
        
        String namaFile = lokasiFolderTemp + File.separator + "peserta-download.csv";
        
        File filePeserta = PesertaExporter.export(dataPeserta, namaFile);
        
        resp.setContentType("text/csv");
        resp.setHeader("Content-Disposition", "attachment;filename=data-peserta.csv");
        //resp.setHeader("Content-Disposition", "inline");
        
        OutputStream output = resp.getOutputStream();
        FileInputStream fis = new FileInputStream(filePeserta);
        int data;
        while((data = fis.read()) != -1){
            output.write(data);
        }
        output.close();
        fis.close();
    }
    
}
