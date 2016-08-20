package com.example.regina.medshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class TelaInicial extends AppCompatActivity {

    public static ArrayList<Cliente> users = new ArrayList<>();
    public static int op = 0;

    public Sessao sessao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void abrirCadastro(View view){
        Intent intent = new Intent(this,TelaCadastro.class);
        startActivity(intent);
    }

    public static String MD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));

        return String.format("%32x", hash);
    }

    public void fazerLogin(View view){
        Cliente cl = new Cliente();

        EditText username = (EditText) findViewById(R.id.txtUsername);
        EditText senha = (EditText) findViewById(R.id.txtSenha);
        Cliente user = new Cliente();
        user.setEmail(username.getText().toString());
        user.setPass(senha.getText().toString());

        //try {
            cl.setPass("1234");
            cl.setEmail("raul");
        users.add(cl);
            int i;
        boolean ok = false;
            for (i = 0; i < users.size(); i++) {
                if (user.equals(users.get(i))) {
                    op = i;
                    ok = true;
                    Intent intent = new Intent(this, TelaBusca.class);
                    startActivity(intent);
                }
            }
            if (!ok)
                Toast.makeText(TelaInicial.this, R.string.email_senha_invalido, Toast.LENGTH_SHORT).show();


    }
}
