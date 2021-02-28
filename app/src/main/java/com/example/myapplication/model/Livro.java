package com.example.myapplication.model;

public class Livro {
    private Integer idLivro;
    private Integer ISBN;
    private String titulo;
    private String autor;

    public Livro() {
    }

    public Livro(Integer idLivro, Integer ISBN, String titulo, String autor) {
        this.idLivro = idLivro;
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
