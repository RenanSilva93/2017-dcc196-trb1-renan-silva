package com.example.renansilva.trabalho1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Renan Silva on 19/10/2017.
 */

public class Livro {
    private String titulo;
    private String editora;
    private Integer ano;
    private List<Livro> livros;

    public Livro(String titulo, String editora, Integer ano) {
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
    }

    public Livro() {

        criarLista();
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getEditora() {

        return editora;
    }

    public void setEditora(String editora) {

        this.editora = editora;
    }

    public Integer getAno() {

        return ano;
    }

    public void setAno(Integer ano) {

        this.ano = ano;
    }

    private void criarLista() {
        livros = new ArrayList<>();
        livros.add(new Livro("Android", "UFJF", 2017));
        livros.add(new Livro("Rede", "UFJF", 2016));
        livros.add(new Livro("PHP", "UFJF", 2017));
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void addLivros(Livro livro) {

        livros.add(livro);
    }

    public boolean verificaLivro(String nome) {
        for(Livro l: this.getLivros()){
            if(l.getTitulo().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public Livro getLivro(String nome) {
        for(Livro l: this.getLivros()){
            if(l.getTitulo().equals(nome)) {
                return l;
            }
        }
        return null;
    }

}
