/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import models.publicacao.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 *
 * @author César
 */
@WebServlet(name = "Upload", urlPatterns = {"/Upload"})
//@MultipartConfig
public class Upload extends HttpServlet {
        private String caminhoArq = null;
        private String textoArq = null;
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
            
        
        PublicacaoDAO dao =new PublicacaoDAO();
        int id = dao.pegaId((String) req.getSession().getAttribute("login"));
        
        response.setContentType("text/html;charset=UTF-8");
       // Publicacao pub = new Publicacao(caminhoArq, null, textoArq, id);
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Upload</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Upload at " + req.getContextPath() + "</h1>");
            out.println("<h1>Servlet Upload at " + req.getParameter("Imagem") + "</h1>");
            out.println("<h1>Servlet Upload at " + req.getParameter("texto") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
