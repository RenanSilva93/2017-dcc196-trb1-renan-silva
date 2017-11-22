package com.example.renan.trabalho1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;

public class DadosParticipantes extends AppCompatActivity {
    private Participante participante;
    private TextView nome;
    private TextView email;
    private TextView entrada;
    private TextView saida;
    private ListView lista;
    private String selecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_participantes);

        selecionado = (String) getIntent().getSerializableExtra("participante");
        participante = MainActivity.participante.getParticipante(selecionado);

        DateFormat df = android.text.format.DateFormat.getDateFormat(getApplicationContext());

        nome = (TextView) findViewById(R.id.idNomeDados);
        email = (TextView) findViewById(R.id.idEmailDados);
        entrada = (TextView) findViewById(R.id.idEntradaDados);
        saida = (TextView) findViewById(R.id.idSaidaDados);
        lista = (ListView) findViewById(R.id.idListaDado);

        nome.setText(participante.getNome());
        email.setText(participante.getEmail());
        if(participante.getEntrada() != null) {
            entrada.setText(df.format(participante.getEntrada()));
        }

        if(participante.getSaida() != null) {
            saida.setText(df.format(participante.getSaida()));
        }


        ArrayList<String> livros = new ArrayList<>();
        livros = MainActivity.reservas.getLivrosParticipante(selecionado);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, livros);

        lista.setAdapter(adapter);

    }

}
