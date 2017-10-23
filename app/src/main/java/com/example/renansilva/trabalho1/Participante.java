package com.example.renansilva.trabalho1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Renan Silva on 19/10/2017.
 */

public class Participante {
    private String nome;
    private String email;
    private List<Participante> participantes;
    private Date dataEntrada;
    private Date dataSaida;

    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Participante() {

        criarParticipantes();
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Date getEntrada() {
        return dataEntrada;
    }

    public void setEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getSaida() {
        return dataSaida;
    }

    public void setSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    private void criarParticipantes() {
        participantes = new ArrayList<>();
        participantes.add(new Participante("Fulano da Silva", "fulano@gmail.com"));
        participantes.add(new Participante("Ciclano da Silva", "ciclano@gmail.com"));
        participantes.add(new Participante("Beltrano da Silva", "beltrano@gmail.com"));
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void addParticipantes(Participante participante) {

        participantes.add(participante);
    }

    public boolean verificaParticipante(String nome) {
        for(Participante p: this.getParticipantes()){
            if(p.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public Participante getParticipante(String nome) {
        for(Participante p: this.getParticipantes()){
            if(p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }
}
