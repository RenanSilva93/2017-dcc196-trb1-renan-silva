package com.example.renansilva.trabalho1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrarParticipante;
    private Button btnCadastroReserva;
    private Button btnCadastrarLivro;
    private ListView listaParticipantes;
    private Participante participantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        participantes = new Participante();

        listaParticipantes = (ListView) findViewById(R.id.idList);

        btnCadastrarParticipante = (Button) findViewById(R.id.idCadastrarParticipante);
        btnCadastroReserva = (Button) findViewById(R.id.idCcadastroReserva);
        btnCadastrarLivro = (Button) findViewById(R.id.idCadastrarLivro);

        ArrayList<String> arrayParticipantes = obterDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayParticipantes);
        listaParticipantes.setAdapter(arrayAdapter);

        btnCadastrarParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastrarParticipante.class);
                startActivity(intent);
            }
        });

        btnCadastroReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastrarReserva.class);
                startActivity(intent);
            }
        });

        btnCadastrarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastrarLivro.class);
                startActivity(intent);
            }
        });

        listaParticipantes.setOnLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Participante p = participantes.getParticipantes().get(i);
                Date data = new Date();
                if(p.getEntrada() == null){
                    p.setEntrada(data);
                } else if(p.getSaida() == null){
                    p.setSaida(data);
                } else {
                    p.setSaida(null);
                    p.setEntrada(null);
                }
                return  true;
            }
        });

        listaParticipantes.setOnClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent atividade = new Intent(MainActivity.this, Atividade.class);
                atividade.putExtra("participante", participantes.getParticipantes().get(i).getNome());
                startActivity(atividade);
            }
        });
    }

    public ArrayList<String> obterDados(){
        ArrayList<String> dados = new ArrayList<>();
        for(Participante p: participantes.getParticipantes()){
            dados.add(p.getNome());
        }
        return dados;

    }
}
