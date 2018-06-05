/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.usuario;

import Banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kassia
 */
public class UsuarioDAO {
    
    Connection con;

    public UsuarioDAO() {
        this.con = ConnectionFactory.getConnection();
    }
    
    public boolean cadastrar (Usuario usuario){
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO Usuario (login, senha, email, endereco) values(?,?,?,?)");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(3, usuario.getEndereco());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao Cadastrar: "+ ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
