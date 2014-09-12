package com.artivisi.training.web;

import com.artivisi.training.dao.PesertaDao;
import com.artivisi.training.domain.Institusi;
import com.artivisi.training.domain.Peserta;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesertaFormServlet extends HttpServlet {

    private PesertaDao dao = new PesertaDao();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();
        
        String kode = req.getParameter("kode");
        if(kode == null || kode.trim().length() < 1){
            errors.put("kode", "Kode tidak boleh kosong");
        }
        
        String name = req.getParameter("nama");
        if(name == null || name.trim().length() < 1){
            errors.put("nama", "Nama tidak boleh kosong");
        }
        
        String email = req.getParameter("email");
        String strTanggalBergabung = req.getParameter("tanggalBergabung");
        
        Peserta p  = new Peserta();
        p.setKode(kode);
        p.setNama(name);
        p.setEmail(email);
        
        SimpleDateFormat parserTanggal 
                = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date tanggalBergabung = parserTanggal.parse(strTanggalBergabung);
            p.setTanggalBergabung(tanggalBergabung);
        } catch (ParseException ex) {
            Logger.getLogger(PesertaFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Institusi i = new Institusi();
        i.setId(1);
        p.setInstitusi(i);
        
        if(!errors.isEmpty()){
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/templates/jsp/peserta/form.jsp")
                    .forward(req, resp);
            return;
        }
        
        dao.simpan(p);
        
        resp.sendRedirect("list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/templates/jsp/peserta/form.jsp")
                .forward(req, resp);
    }
    
}
