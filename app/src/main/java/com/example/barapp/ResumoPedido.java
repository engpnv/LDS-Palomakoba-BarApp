package com.example.barapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class ResumoPedido extends AppCompatActivity {

    TextView tv_resumo;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pedido);

        i = getIntent();
//colocar . no igual e debugar

        tv_resumo = findViewById(R.id.tv_resumoPedido);
        tv_resumo.setText(i.getExtras().getString("pedido"));
    }
}