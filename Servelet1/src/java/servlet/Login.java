/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import models.usuario.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author César
 */
@WebServlet(urlPatterns = {"/loginSer"}, name="loginSer")
public class Login extends HttpServlet {
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                   PrintWriter writer = response.getWriter();

        String Login = request.getParameter("login");
        String Senha = request.getParameter("senha");
        UsuarioDAO dao = new UsuarioDAO();
        
        
        if(dao.encontraUsuarioLoginEsenha(Login,Senha)){ 
            request.getSession().setAttribute("logado", new Boolean(true));
            request.getSession().setAttribute("login", Login);
            dao.login(Login, Senha);
            System.out.println("TRansferindo");
            response.sendRedirect("/Servelet1/login2");
        }else{
            response.sendRedirect("/Servelet1/html/login.html");
        }
    }
 
}
