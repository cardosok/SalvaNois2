/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.publicacao;

import models.usuario.Usuario;

/**
 *
 * @author kassia
 */
public class Publicacao {
    private int id;
    private String imagem;
    private String video;
    private String texto;
    private String dataPublicacao;
    private Usuario usuario;

    public Publicacao(int id, String imagem, String video, String texto, String dataPublicacao, Usuario usuario) {
        this.id = id;
        this.imagem = imagem;
        this.video = video;
        this.texto = texto;
        this.dataPublicacao = dataPublicacao;
        this.usuario = usuario;
    }

    public Publicacao(String imagem, String video, String texto, String dataPublicacao, Usuario usuario) {
        this.imagem = imagem;
        this.video = video;
        this.texto = texto;
        this.dataPublicacao = dataPublicacao;
        this.usuario = usuario;
    }

    public Publicacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
