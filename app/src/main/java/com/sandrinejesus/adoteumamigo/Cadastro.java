package com.sandrinejesus.adoteumamigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity implements View.OnClickListener{

    EditText usuario;
    EditText nascimento;
    EditText email;
    EditText senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        usuario = (EditText) findViewById(R.id.usuario);
        nascimento = (EditText) findViewById(R.id.dtnascimento);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);

        findViewById(R.id.voltar).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.voltar){
            finish();
        }

    }
}
