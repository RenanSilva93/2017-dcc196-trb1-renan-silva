package com.example.renansilva.trabalho1;

import java.util.List;

/**
 * Created by Renan Silva on 21/10/2017.
 */

public class Reserva {
    private Livro livro;
    private Participante participante;
    private List<Reserva> reservas;

    public Reserva(Livro livro, Participante participante) {
        this.livro = livro;
        this.participante = participante;
    }

    public Reserva() {

    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public List<Reserva> getRreservas() {
        return reservas;
    }

    public void addReserva(Reserva reserva) {

        reservas.add(reserva);
    }


}
