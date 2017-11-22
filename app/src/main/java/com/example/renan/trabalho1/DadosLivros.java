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

import java.util.ArrayList;

public class DadosLivros extends AppCompatActivity {
    private Livro livro;
    private TextView titulo;
    private TextView editora;
    private TextView ano;
    private ListView lista;
    private String selecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_livros);

        selecionado = (String) getIntent().getSerializableExtra("livro");
        livro = MainActivity.livro.getLivro(selecionado);

        titulo = (TextView) findViewById(R.id.idTituloDado);
        editora = (TextView) findViewById(R.id.idEditoraDado2);
        ano = (TextView) findViewById(R.id.idAnoDado);
        lista = (ListView) findViewById(R.id.idListaLivroDados);

        titulo.setText(livro.getTitulo());
        editora.setText(livro.getEditora());
        ano.setText(livro.getAno().toString());

        ArrayList<String> participantes = new ArrayList<>();
        participantes = MainActivity.reservas.getReservasParticipantes(selecionado);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, participantes);

        lista.setAdapter(adapter);

    }

}
