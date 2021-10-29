package com.example.barapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CheckBox cb_cerveja, cb_agua, cb_cigarro, cb_vodka, cb_cachaca, cb_whisky;
    Button bt_efetuarPagamento;
    EditText et_cerveja, et_agua, et_cigarro, et_cachaca, et_vodka, et_whisky;
    Double cerveja = 5.00, agua = 3.00, cigarro =10.00, cachaca = 10.00, vodka = 12.00, whisky = 15.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb_agua = findViewById(R.id.cb_agua);
        cb_cachaca = findViewById(R.id.cb_cachaca);
        cb_cerveja = findViewById(R.id.cb_cerveja);
        cb_cigarro = findViewById(R.id.cb_cigarro);
        cb_vodka = findViewById(R.id.cb_vodka);
        cb_whisky = findViewById(R.id.cb_whisky);

        et_agua = findViewById(R.id.et_qtdAgua);
        et_cachaca = findViewById(R.id.et_qtdCachaca);
        et_cerveja = findViewById(R.id.et_qtdCerveja);
        et_cigarro = findViewById(R.id.et_qtdCigarro);
        et_vodka = findViewById(R.id.et_qtdVodka);
        et_whisky = findViewById(R.id.et_qtdWhisky);
        bt_efetuarPagamento = findViewById(R.id.bt_efetuarPedido);

        bt_efetuarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pedido = "";
                //parte 2
                double valorTotal = 0;
                //
                if (cb_agua.isChecked()) {

                    int quantidade = Integer.parseInt(et_agua.getText().toString());
                    pedido += quantidade+" Água\n";
                    valorTotal += quantidade * agua;
                }
                if (cb_cachaca.isChecked()) {

                    int quantidade = Integer.parseInt(et_cachaca.getText().toString());
                    pedido += quantidade+" Cachaça\n";
                    valorTotal += quantidade * cachaca;
                }
                if (cb_cerveja.isChecked()) {

                    int quantidade = Integer.parseInt(et_cerveja.getText().toString());
                    pedido += quantidade+" Cerveja\n";
                    valorTotal += quantidade * cerveja;
                }
                if (cb_cigarro.isChecked()) {

                    int quantidade = Integer.parseInt(et_cigarro.getText().toString());
                    pedido += quantidade+" Cigarro\n";
                    valorTotal += quantidade * cigarro;
                }
                if (cb_vodka.isChecked()) {

                    int quantidade = Integer.parseInt(et_vodka.getText().toString());
                    pedido += quantidade+" Vodka\n";
                    valorTotal += quantidade * vodka;
                }
                if (cb_whisky.isChecked()) {
                    pedido += "1 Whisky\n";
                    int quantidade = Integer.parseInt(et_whisky.getText().toString());
                    pedido += quantidade+" Whisky\n";
                    valorTotal += quantidade * whisky;
                }

                if (pedido.equals("")) {
                    Toast.makeText(MainActivity.this, "Pedido inválido", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, SplashScreen.class);
                    intent.putExtra("pedido", pedido + "Valor Total: R$"+ String.valueOf(valorTotal));
                    intent.putExtra("valorTotal",valorTotal);
                    startActivity(intent);
                }
            }
        });

    }



}