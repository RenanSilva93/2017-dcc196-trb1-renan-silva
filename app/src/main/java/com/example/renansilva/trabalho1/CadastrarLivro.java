package com.example.renansilva.trabalho1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarLivro extends AppCompatActivity {

    private EditText titulo;
    private EditText editora;
    private EditText ano;
    private Button btnSalvar;
    private Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_livro);

        livro = new Livro();

        titulo = (EditText) findViewById(R.id.idTitulo);
        editora = (EditText) findViewById(R.id.idEditora);
        btnSalvar = (Button) findViewById(R.id.idSalvarLivro);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
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
                    livro.addLivros(livroNovo);
                    titulo.setText("");
                    editora.setText("");
                    ano.setText("");
                }

            }
        });
    }

}
