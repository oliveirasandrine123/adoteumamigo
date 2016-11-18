package com.sandrinejesus.adoteumamigo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText password;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInWithEmailAndPassword(user.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    if (user != null ){
                                        Intent it = new Intent(MainActivity.this, CadastroAnimal.class);
                                        startActivity(it);
                                        finish();
                                    }
                                } else {
                                    Toast.makeText(MainActivity.this, "Usuario ou senha invalida", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                }
            });

        findViewById(R.id.cadastrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarUsuario();
            }
        });

    }

    private void cadastrarUsuario(){
        Intent i = new Intent(MainActivity.this, Cadastro.class);
        startActivity(i);
    }

}




