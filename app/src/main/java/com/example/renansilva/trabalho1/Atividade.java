package com.example.renansilva.trabalho1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Atividade extends AppCompatActivity {
    private TextView nome;
    private TextView email;
    private TextView entrada;
    private TextView saida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade);

        nome = (TextView) findViewById(R.id.idnomeAtividade);
        email = (TextView) findViewById(R.id.idemailAtividade);
        entrada = (TextView) findViewById(R.id.idEntrada);
        saida = (TextView) findViewById(R.id.idSaida);

        Participante p = (Participante) getIntent().getSerializableExtra("participante");

        nome.setText(p.getNome());
        email.setText(p.getEmail());
        entrada.setText(p.getEntrada().toString());
        saida.setText(p.getSaida().toString());
    }

}
