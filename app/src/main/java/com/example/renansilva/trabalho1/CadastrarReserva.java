package com.example.renansilva.trabalho1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarReserva extends AppCompatActivity {

    private EditText participante;
    private EditText livro;
    private Button btnSalvar;
    private Participante listaParticipantes;
    private Livro listaLivros;
    private Reserva reserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_reserva);

        reserva = new Reserva();
        participante = (EditText) findViewById(R.id.idParticipanteReserva);
        livro = (EditText) findViewById(R.id.idLivroReserva);
        btnSalvar = (Button) findViewById(R.id.idSalvarReserva);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaParticipantes.verificaParticipante(participante.getText().toString()) &&
                        listaLivros.verificaLivro(livro.getText().toString())) {

                    Reserva novaReserva = new Reserva(listaLivros.getLivro(livro.getText().toString()),
                            listaParticipantes.getParticipante(participante.getText().toString()));

                    reserva.addReserva(novaReserva);

                } else {
                    participante.setText("");
                    livro.setText("");
                    participante.requestFocus();
                }

            }
        });
    }

}
