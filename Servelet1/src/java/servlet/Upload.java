/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
/*@WebServlet(name = "Upload", urlPatterns = {"/Upload"})
//@MultipartConfig
public class Upload extends HttpServlet {
        private String caminhoArq = null;
    
    @Override
    public void init() throws ServletException{
        super.init();
        caminhoArq = getServletContext().getInitParameter("caminhoArq");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
       //Pega pasta do projeto
        String pastaProjeto = getServletContext().getRealPath("");
       
    //caminho completo da pasta das imagens
       String salvarEm = pastaProjeto + File.separator + caminhoArq;
        System.out.println("Salvando arquivo em" +salvarEm);
       
    // verifica se a pasta existe, caso não cria   
    File pasta = new File(salvarEm);
    if(!pasta.exists()){
        pasta.mkdir();
    }
    //pega o arquivo selecionado
    Part arquivoSelecionado = req.getPart("Imagem");
    String nomeArquivo = arquivoSelecionado.getSubmittedFileName();
    
    //grava arquivo no disco
    arquivoSelecionado.write(salvarEm + File.separator + nomeArquivo);
          response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Upload</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Upload at " + req.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
*/