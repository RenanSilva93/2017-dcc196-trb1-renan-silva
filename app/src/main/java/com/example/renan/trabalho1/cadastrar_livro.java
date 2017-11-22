package com.example.renan.trabalho1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class cadastrar_livro extends AppCompatActivity {
    private EditText titulo;
    private EditText editora;
    private EditText ano;
    private Button btnAdicionar;
    private Livro livro;
    private ListView listaLivro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_livro);

        livro = new Livro();

        titulo = (EditText) findViewById(R.id.idTitulo);
        editora = (EditText) findViewById(R.id.idEditora);
        ano = (EditText) findViewById(R.id.idAno);
        btnAdicionar = (Button) findViewById(R.id.idAdicionarLivro);
        listaLivro  = (ListView) findViewById(R.id.idListaLivro);


        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titulo.getText().toString().isEmpty()) {
                    titulo.requestFocus();
                } else  if (editora.getText().toString().isEmpty()) {
                    editora.requestFocus();
                } else if(ano.getText().toString().isEmpty()) {
                    ano.requestFocus();
                } else {
                    Livro livroNovo = new Livro(titulo.getText().toString(), editora.getText().toString(), Integer.parseInt(ano.getText().toString()));
                    MainActivity.livro.addLivro(livroNovo);
                    titulo.setText("");
                    editora.setText("");
                    ano.setText("");

                    Toast.makeText(cadastrar_livro.this, "Livro cadastrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listaLivro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Livro> livros = new ArrayList<>();
                livros = MainActivity.livro.getLivros();
                Livro livro = livros.get(i);

                Intent atividade = new Intent(cadastrar_livro.this, DadosLivros.class);
                atividade.putExtra("livro", livro.getTitulo());
                startActivity(atividade);
            }
        });

        obterLivros();

    }

    public void obterLivros() {
        ArrayAdapter<Livro> adapter = new ArrayAdapter<Livro>(this,
                android.R.layout.simple_list_item_1, MainActivity.livro.getLivros());

        listaLivro.setAdapter(adapter);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        obterLivros();
    }

}
