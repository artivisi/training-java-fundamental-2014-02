package com.artivisi.training.web;

import com.artivisi.training.domain.HasilImportPeserta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesertaHasilUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HasilImportPeserta hasil = (HasilImportPeserta) req.getSession().getAttribute("hasilUpload");
        
        if(hasil!=null){
            req.setAttribute("hasilUpload", hasil);
            req.getSession().removeAttribute("hasilUpload");
        }
        
        req.getRequestDispatcher("/WEB-INF/templates/jsp/peserta/import.jsp")
                .forward(req, resp);
    }
    
}
