package com.example.regina.medshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import java.security.NoSuchAlgorithmException;

public class TelaCadastro extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Sessao sessao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(sessao.logged) {
            Menu menu = navigationView.getMenu();
            MenuItem entrar = menu.findItem(R.id.Login);
            entrar.setTitle("Sair");
        }else{
            Menu menu = navigationView.getMenu();
            MenuItem entrar = menu.findItem(R.id.Login);
            entrar.setTitle("Entrar");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.DadosPessoais) {
            abrirTelaMeuPerfil();
        } else if (id == R.id.MeusProdutos) {
            abrirTelaMeusProdutos();
        } else if (id == R.id.MinhasTransacoes) {
            abrirTelaMinhasTransacoes();
        }else if (id == R.id.Login) {
            if(sessao.logged){
                sessao.email = "";
                sessao.logged = false;
                abrirTelaInicial();
            }else{
                abrirTelaInicial();
            }
        }else if (id == R.id.Pesquisar) {
            abrirTelaBusca();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void cancelarClick(View view){
        finish();
    }

    private void abrirTelaInicial(){
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }

    private void abrirTelaBusca(){
        Intent intent = new Intent(this, TelaBusca.class);
        startActivity(intent);
    }

    private void abrirTelaMinhasTransacoes(){
        Intent intent = new Intent(this, TelaMinhasTransacoes.class);
        startActivity(intent);
    }

    private void abrirTelaMeusProdutos(){
        Intent intent = new Intent(this, TelaMeusProdutos.class);
        startActivity(intent);
    }

    private void abrirTelaMeuPerfil(){
        Intent intent = new Intent(this, TelaMeuPerfil.class);
        startActivity(intent);
    }

    public void SendInfo(View view) {

        Cliente cl = new Cliente();

        EditText nome = (EditText) findViewById(R.id.txtNome);
        EditText RG = (EditText) findViewById(R.id.txtRG);
        EditText CPF = (EditText) findViewById(R.id.txtCPF);
        EditText Email = (EditText) findViewById(R.id.txtEmail);
        EditText Celular = (EditText) findViewById(R.id.txtCelular);
        EditText Rua = (EditText) findViewById(R.id.txtRua);
        EditText Numero = (EditText) findViewById(R.id.txtNumero);
        EditText Bairro = (EditText) findViewById(R.id.txtBairro);
        EditText Cidade = (EditText) findViewById(R.id.txtCidade);
        EditText CEP = (EditText) findViewById(R.id.txtCEP);
        Spinner Estado = (Spinner) findViewById(R.id.cmbEstado); // pegar txt da cm selecionado
        EditText Pass = (EditText) findViewById(R.id.txtSenha);
        cl.setNome(nome.getText().toString());
        cl.setBairro(Bairro.getText().toString());
        cl.setCEP(CEP.getText().toString());
        cl.setCidade(Cidade.getText().toString());
        cl.setCPF(CPF.getText().toString());
        cl.setEmail(Email.getText().toString());
        cl.setRG(RG.getText().toString());
        cl.setEstado(Estado.getSelectedItem().toString());
        cl.setTel(Celular.getText().toString());
        cl.setRua(Rua.getText().toString());
        cl.setTel(Celular.getText().toString());
        cl.setNum(Numero.getText().toString());


        try {
            cl.setPass(TelaInicial.MD5(Pass.toString()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //sql.salva(cl);



    }

}
