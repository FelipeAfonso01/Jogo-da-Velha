package com.example.felipe.jogo_da_velha2;

/**
 * Created by Felipe on 21/05/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class dois_jogadores extends AppCompatActivity implements View.OnClickListener {


    Button[] bot;

    private TextView jogadores;
    private TextView vitoria_x;
    private TextView vitoria_o;
    private TextView empates;
    Integer qtd_jogadas=0;
    Integer jogador=1;
    Integer venceu_x=0;
    Integer venceu_o=0;
    Integer empate=0;
    android.os.Bundle Bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dois_jogadores);
        bot = new  Button[10];
        // primeira linha
        bot[1] = (Button) findViewById(R.id.bo11);
        bot[2] = (Button) findViewById(R.id.bot12);
        bot[3] = (Button) findViewById(R.id.bot13);

        // segunda linha
        bot[4] = (Button) findViewById(R.id.bot21);
        bot[5] = (Button) findViewById(R.id.bot22);
        bot[6] = (Button) findViewById(R.id.bot23);

        // terceira linha
        bot[7] = (Button) findViewById(R.id.bot31);
        bot[8] = (Button) findViewById(R.id.bot32);
        bot[9] = (Button) findViewById(R.id.bot33);
        jogadores = (TextView) findViewById(R.id.jogador);
        vitoria_x = (TextView) findViewById(R.id.venceu_x);
        vitoria_o = (TextView) findViewById(R.id.venceu_o);
        empates = (TextView) findViewById(R.id.empate);
        for(int i=1;i<10;i++) {
            bot[i].setOnClickListener(this);
        }

    }
    public void verifica(){
        if(qtd_jogadas>=5) {

            if ((bot[1].getText().toString().trim() != "" ) && (bot[2].getText().toString().trim() != "") && (bot[3].getText().toString().trim() != "")) {
                if ((bot[1].getText().toString().trim() == bot[2].getText().toString().trim()) && (bot[1].getText().toString().trim() == bot[3].getText().toString().trim())) {
                    qtd_jogadas=0;
                    ganhou();
                }
            }
            if ((bot[4].getText().toString().trim() != "" ) && (bot[5].getText().toString().trim() != "") && (bot[6].getText().toString().trim() != "")) {
                if ((bot[4].getText().toString().trim() == bot[5].getText().toString().trim()) && (bot[4].getText().toString().trim() == bot[6].getText().toString().trim())) {
                    qtd_jogadas=0;
                    ganhou();
                }
            }
            if ((bot[7].getText().toString().trim() != "" ) && (bot[8].getText().toString().trim() != "") && (bot[9].getText().toString().trim() != "")) {
                if ((bot[7].getText().toString().trim() == bot[8].getText().toString().trim()) && (bot[7].getText().toString().trim() == bot[9].getText().toString().trim())) {
                    qtd_jogadas=0;
                    ganhou();
                }
            }

            if ((bot[1].getText().toString().trim() != "" ) && (bot[4].getText().toString().trim() != "") && (bot[7].getText().toString().trim() != "")) {
                if ((bot[1].getText().toString().trim() == bot[4].getText().toString().trim()) && (bot[1].getText().toString().trim() == bot[7].getText().toString().trim())) {
                    qtd_jogadas=0;
                    ganhou();
                }
            }

            if ((bot[2].getText().toString().trim() != "" ) && (bot[5].getText().toString().trim() != "") && (bot[8].getText().toString().trim() != "")) {
                if ((bot[2].getText().toString().trim() == bot[5].getText().toString().trim()) && (bot[2].getText().toString().trim() == bot[8].getText().toString().trim())) {
                    qtd_jogadas=0;
                    ganhou();
                }
            }

            if ((bot[3].getText().toString().trim() != "" ) && (bot[6].getText().toString().trim() != "") && (bot[9].getText().toString().trim() != "")) {
                if ((bot[3].getText().toString().trim() == bot[6].getText().toString().trim()) && (bot[3].getText().toString().trim() == bot[9].getText().toString().trim())) {
                    qtd_jogadas=0;
                    ganhou();
                }
            }
            if ((bot[1].getText().toString().trim() != "" ) && (bot[5].getText().toString().trim() != "") && (bot[9].getText().toString().trim() != "")) {
                if ((bot[1].getText().toString().trim() == bot[5].getText().toString().trim()) && (bot[1].getText().toString().trim() == bot[9].getText().toString().trim())) {
                    qtd_jogadas=0;
                    ganhou();
                }
            }
            if ((bot[7].getText().toString().trim() != "" ) && (bot[5].getText().toString().trim() != "") && (bot[3].getText().toString().trim() != "")) {
                if ((bot[7].getText().toString().trim() == bot[5].getText().toString().trim()) && (bot[7].getText().toString().trim() == bot[3].getText().toString().trim())) {
                    qtd_jogadas=0;
                        ganhou();
                }
            }

            if(qtd_jogadas==9){
                ganhou();
            }



        }
    }

    public void ganhou(){
        String venceu = "";
        if(qtd_jogadas==9) {
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
            empate++;
            limpar();
        }else{
            if (jogador == 1) {
                venceu = "O";
                venceu_o ++;
            } else {
                venceu = "X";
                venceu_x ++;
            }
            Toast.makeText(this, "Venceu o jogador " + venceu, Toast.LENGTH_SHORT).show();
            limpar();
        }
    }


    public void onClick(View v) {
        String texto = ((Button) v).getText().toString();
        if((texto=="X") || (texto=="O")){
            Toast.makeText(this,"Campo já selecionado" ,Toast.LENGTH_SHORT).show();
        }else {
            qtd_jogadas++;
            if (jogador == 1) {
                ((Button) v).setText("X");
                jogador = 2;
                jogadores.setText("Vez do Jogador: O");
                verifica();
            } else {
                ((Button) v).setText("O");
                jogador = 1;
                jogadores.setText("Vez do Jogador: X");
                verifica();
            }
        }

    }

    public void limpar(){
        for(int i=1;i<10;i++) {
            bot[i].setText(" ");
            vitoria_x.setText("Vitórias jogador X : "+venceu_x);
            vitoria_o.setText("Vitórias jogador O : "+venceu_o);
            empates.setText("Números de Empates: "+empate);
            bot[i].setEnabled(true);
            jogador = 1;
            qtd_jogadas=0;

            jogadores.setText("Vez do Jogador: X");
        }
    }
}