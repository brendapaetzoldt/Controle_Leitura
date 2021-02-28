package com.example.myapplication.model;

import java.util.Date;

public class Avaliacao {

    private Integer idAvaliacao;
    private Livro idLivro;
    private Date dataCompra;
    private double estrelas;
    private String status;


    public Avaliacao() {
    }

    public Avaliacao(Integer idAvaliacao, Livro idLivro, Date dataCompra, double estrelas, String status) {
        this.idAvaliacao = idAvaliacao;
        this.idLivro = idLivro;
        this.dataCompra = dataCompra;
        this.estrelas = estrelas;
        this.status = status;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Livro getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Livro idLivro) {
        this.idLivro = idLivro;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(double estrelas) {
        this.estrelas = estrelas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
