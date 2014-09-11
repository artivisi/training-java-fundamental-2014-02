package com.artivisi.training.web;

import com.artivisi.training.dao.PesertaDao;
import com.artivisi.training.domain.Peserta;
import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesertaListServlet extends HttpServlet {

    private PesertaDao dao = new PesertaDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Peserta> data = dao.cariSemua();
        req.setAttribute("dataPeserta", data);
        req.getRequestDispatcher("/WEB-INF/templates/jsp/peserta/list.jsp")
                .forward(req, resp);
    }
    
}
