package com.artivisi.training.web;

import com.artivisi.training.dao.PesertaDao;
import com.artivisi.training.domain.HasilImportPeserta;
import com.artivisi.training.domain.Institusi;
import com.artivisi.training.domain.Peserta;
import com.artivisi.training.importer.PesertaImporter;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class PesertaUploadServlet extends HttpServlet {

    private PesertaDao dao = new PesertaDao();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // tempat penyimpanan sementara kalau file terlalu besar
            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            // konfigurasi tempat penyimpanan
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            System.out.println("Temp Folder : "+repository.getAbsolutePath());
            factory.setRepository(repository);
            
            // Object yang bertugas menangani upload
            ServletFileUpload uploadHandler = new ServletFileUpload(factory);
            
            List<FileItem> hasilUpload = uploadHandler.parseRequest(req);
            for (FileItem fileItem : hasilUpload) {
                System.out.println("Nama File : "+fileItem.getName());
                System.out.println("Nama Variabel : "+fileItem.getFieldName());
                System.out.println("Ukuran : "+fileItem.getSize());
                System.out.println("Tipe File : "+fileItem.getContentType());
                
                //File sementara = File.createTempFile("peserta", "csv");
                String lokasi = servletContext.getRealPath("/upload");
                System.out.println("Lokasi penyimpanan : "+lokasi);
                File sementara = new File(lokasi + File.separator + fileItem.getName());
                fileItem.write(sementara);
                HasilImportPeserta hasil = PesertaImporter.proses(sementara);
                System.out.println("Sukses Upload : "+hasil.getSukses().size());
                System.out.println("Gagal Upload : "+hasil.getGagal().size());
                
                List<Peserta> dataPeserta = hasil.getSukses();
                for (Peserta peserta : dataPeserta) {
                    Institusi i = new Institusi();
                    i.setId(1);
                    peserta.setInstitusi(i);
                    dao.simpan(peserta);
                }
                
                req.getSession().setAttribute("hasilUpload", hasil);
            }
            
            resp.sendRedirect("import");
        } catch (FileUploadException ex) {
            Logger.getLogger(PesertaUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PesertaUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/templates/jsp/peserta/upload.jsp")
                .forward(req, resp);
    }

}
