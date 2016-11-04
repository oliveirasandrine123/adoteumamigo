package com.sandrinejesus.adoteumamigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText user;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);

        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.cadastrar).setOnClickListener(this);

    }

    private void cadastrarUsuario(){
        Intent i = new Intent(MainActivity.this, Cadastro.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.cadastrar){
            cadastrarUsuario();
        }
    }
}
