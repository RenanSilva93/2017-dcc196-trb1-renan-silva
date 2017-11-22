package com.example.renan.trabalho1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button btnCadastrarParticipante;
    private Button btnCadastrarReserva;
    private Button btnCadastrarLivro;
    private ListView listaParticipantes;
    public static Livro livro = new Livro();
    public static Participante participante = new Participante();
    public static Reserva reservas = new Reserva();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaParticipantes = (ListView) findViewById(R.id.idListaParticipantes);
        obterDados();
        btnCadastrarParticipante = (Button) findViewById(R.id.idCadastrarParticipante);
        btnCadastrarReserva = (Button) findViewById(R.id.idCadastrarReserva);
        btnCadastrarLivro = (Button) findViewById(R.id.idCadastrarLivro);

        btnCadastrarParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, cadastrar_participante.class);
                startActivity(intent);
            }
        });

        btnCadastrarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, cadastrar_reserva.class);
                startActivity(intent);
            }
        });

        btnCadastrarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, cadastrar_livro.class);
                startActivity(intent);
            }
        });

        listaParticipantes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Participante> participantes = new ArrayList<>();
                participantes = participante.getParticipantes();
                Participante p = participantes.get(i);

                if(p.getEntrada() == null){
                    p.setEntrada(Calendar.getInstance().getTime());
                    Toast.makeText(MainActivity.this, "Hora Entrada: "+p.getEntrada(), Toast.LENGTH_SHORT).show();

                } else if(p.getSaida() == null){
                    p.setSaida(Calendar.getInstance().getTime());
                    Toast.makeText(MainActivity.this, "Hora Saída: "+p.getSaida(), Toast.LENGTH_SHORT).show();

                } else {
                    p.setSaida(null);
                    p.setEntrada(null);
                    Toast.makeText(MainActivity.this, "Horas Apagadas!", Toast.LENGTH_SHORT).show();
                }
                return  true;
            }
        });

        listaParticipantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Participante> participantes = new ArrayList<>();
                participantes = participante.getParticipantes();
                Participante p = participantes.get(i);

                Intent atividade = new Intent(MainActivity.this, DadosParticipantes.class);
                atividade.putExtra("participante", p.getNome());
                startActivity(atividade);
            }
        });

    }

    private void obterDados() {
        ArrayAdapter<Participante> adapter = new ArrayAdapter<Participante>(this,
                android.R.layout.simple_list_item_1, participante.getParticipantes());

        listaParticipantes.setAdapter(adapter);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        obterDados();
    }
}
