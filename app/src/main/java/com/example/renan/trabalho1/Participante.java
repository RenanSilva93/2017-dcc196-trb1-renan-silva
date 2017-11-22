package com.example.renan.trabalho1;

import java.util.ArrayList;
import java.util.Date;

public class Participante {
    private String nome;
    private String email;
    private ArrayList<Participante> participantes = new ArrayList<>();
    private Date dataEntrada;
    private Date dataSaida;

    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.dataEntrada = null;
        this.dataSaida = null;
    }

    public Participante() {
        if(participantes.isEmpty()) {
            criarParticipantes();
        }
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

    public void criarParticipantes() {
        participantes.add(new Participante("Participante 1", "part1@part.com"));
        participantes.add(new Participante("Participante 2", "part2@part.com"));
    }

    public ArrayList<Participante> getParticipantes() {

        return participantes;
    }

    public void addParticipante(Participante participante) {

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

    public Participante getParticipanteToIndex(int index) {
        for(int i=0; i < index; i++){
            if(i == index) {
                return participantes.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {

        return nome;
    }
}
