package com.example.felipe.jogo_da_velha2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonGet;
    private Button incluir;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGet = (Button) findViewById(R.id.buttonGet);
        incluir = (Button)findViewById(R.id.incluir);
        buttonGet.setOnClickListener(this);
        incluir.setOnClickListener(this);
    }






    private Toast toast;
    private long lastBackPressTime = 0;


    public void onBackPressed() {
        if (this.lastBackPressTime < System.currentTimeMillis() - 4000) {
            toast = Toast.makeText(this, "Pressione o Botão Voltar novamente para fechar o Aplicativo.", Toast.LENGTH_LONG);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
            }
            super.onBackPressed();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonGet:
               Intent intent1 = new Intent(this, umjogador.class);
                startActivity(intent1);
                break;
            case R.id.incluir:
                Intent intent = new Intent(this, dois_jogadores.class);
                startActivity(intent);
                break;
        }
    }


}
