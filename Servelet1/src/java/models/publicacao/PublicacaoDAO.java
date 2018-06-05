/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.publicacao;

import Banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import models.usuario.UsuarioDAO;

/**
 *
 * @author kassia
 */
public class PublicacaoDAO {
    
    Connection con;

    public PublicacaoDAO() {
        this.con = ConnectionFactory.getConnection();
    }
    
    public boolean cadastrar (Publicacao publicacao){
        PreparedStatement stmt = null;
        try{
            if(new UsuarioDAO().checkIsAdmin(publicacao.getUsuario().getId())){
                stmt = con.prepareStatement("INSERT INTO publicacao (imagem, video, texto, data_publicacao, usuarios_id) values( ?, ?, ?, ?, ?)");
                stmt.setString(1, publicacao.getImagem());
                stmt.setString(2, publicacao.getVideo());
                stmt.setString(3, publicacao.getTexto());
                stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
                stmt.setInt(5, publicacao.getUsuario().getId());
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao Cadastrar Publicacao: "+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
}
