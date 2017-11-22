package com.example.renan.trabalho1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastrar_reserva extends AppCompatActivity {
    private EditText nome;
    private EditText livro;
    private Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_reserva);

        nome = (EditText) findViewById(R.id.idNomeReserva);
        livro = (EditText) findViewById(R.id.idLivroReserva);
        btnAdicionar = (Button) findViewById(R.id.idAdicionarReserva);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nome.getText().toString().isEmpty()) {
                    nome.requestFocus();
                } else  if (livro.getText().toString().isEmpty()) {
                    livro.requestFocus();
                } else {
                    if(MainActivity.participante.verificaParticipante(nome.getText().toString()) &&
                        MainActivity.livro.verificaLivro(livro.getText().toString())) {
                            Reserva reserva = new Reserva(nome.getText().toString(), livro.getText().toString());
                            MainActivity.reservas.addReserva(reserva);
                            nome.setText("");
                            livro.setText("");

                            Toast.makeText(cadastrar_reserva.this, "Reservado com sucesso!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(cadastrar_reserva.this, "Participante ou Livro não existe!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

}
