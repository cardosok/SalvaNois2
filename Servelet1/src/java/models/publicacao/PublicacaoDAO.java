/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.publicacao;

import Banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import models.usuario.Usuario;
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
    public int pegaId(String login){
        int id = 0;
       PreparedStatement stmt = null;
       ResultSet rs = null;
       String sql = "select id from usuario as usu where usu.login = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                return id;
            }
        } catch (Exception ex) {
            System.err.println("Erro ao pesquisar id Publicacao: "+ ex);
        }
        return id;
    }
    public boolean cadastrar (Publicacao publicacao){
        PreparedStatement stmt = null;
        try{
            if(new UsuarioDAO().checkIsAdmin(publicacao.getUsuario().getId())){
                stmt = con.prepareStatement("INSERT INTO publicacao (imagem, video, texto, usuarios_id) values( ?, ?, ?, ?)");
                stmt.setString(1, publicacao.getImagem());
                stmt.setString(2, publicacao.getVideo());
                stmt.setString(3, publicacao.getTexto());
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

    public ArrayList<Publicacao> pesquisar (String texto) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String sqlQuery = "SELECT id, imagem, video, texto, usuarios_id FROM publicacao WHERE texto like concat(?,'%') GROUP BY data_publicacao";
        ArrayList<Publicacao> publicacao = new ArrayList<>();
        try{
            stmt = con.prepareStatement(sqlQuery);
            stmt.setString(1, texto);
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario user = new UsuarioDAO().encontraUsuario(rs.getInt("usuarios_id"));
                Publicacao publi = new Publicacao(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), user);
            }
            return publicacao;
        }catch(SQLException ex){
            System.err.println("Erro ao procurar periodo do consumo: "+ ex);
        }
        return null;
    }
}
