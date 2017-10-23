package com.example.renansilva.trabalho1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarParticipante extends AppCompatActivity {
    private EditText nome;
    private EditText email;
    private Button btnOK;
    private Participante part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_participante);

        part = new Participante();

        nome = (EditText) findViewById(R.id.idNomeParticipante);
        email = (EditText) findViewById(R.id.idEmailParticipante);
        btnOK = (Button) findViewById(R.id.idBtnParticipante);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nome.getText().toString().isEmpty()) {
                    nome.requestFocus();
                } else  if (email.getText().toString().isEmpty()) {
                    email.requestFocus();
                } else {

                    Participante participante = new Participante(nome.getText().toString(), email.getText().toString());
                    part.addParticipantes(participante);
                    nome.setText("");
                    email.setText("");
                }

            }
        });


    }

}
