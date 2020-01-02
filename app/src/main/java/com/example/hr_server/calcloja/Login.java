package com.example.hr_server.calcloja;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedpreferences;
    public static final String mypreference = "USER";
    private String senha,usuario;
    private Button btnOK;
    private EditText edtSenha, edtUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnOK = findViewById(R.id.btnOK);
        edtUsuario = findViewById(R.id.EdtUsuario);
        edtSenha = findViewById(R.id.EdtSenha);
        //Salvar();
        try {
            Carregar();
        }catch (Exception ex){
            Salvar();
            Toast.makeText(this,"Carregando...",Toast.LENGTH_SHORT).show();
        }

        btnOK.setOnClickListener(this);

    }
    public void Carregar(){

        sharedpreferences = getSharedPreferences(mypreference, 0);
        String USER = edtUsuario.getText().toString();
        String SENHA = edtSenha.getText().toString();

        usuario = sharedpreferences.getString("USUARIO",null);
        senha = sharedpreferences.getString("SENHA", null);

        if(usuario == null && senha == null){

            Salvar();
            Toast.makeText(this,"Salvar",Toast.LENGTH_SHORT).show();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("VOLTAR");

    }
    public void Salvar(){
        try {
            sharedpreferences = getSharedPreferences(mypreference, 0);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            String USER = edtUsuario.getText().toString();
            String SENHA = edtSenha.getText().toString();

            editor.putString("USUARIO", "admin");
            editor.putString("SENHA", "admin");




            editor.commit();

        }catch (Exception ex){
            Toast.makeText(this,"deu erro",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        if(view == btnOK){
            sharedpreferences = getSharedPreferences(mypreference, 0);
            String USER = edtUsuario.getText().toString();
            String SENHA = edtSenha.getText().toString();
            //Toast.makeText(this,"OK",Toast.LENGTH_SHORT).show();
            usuario = sharedpreferences.getString("USUARIO",null);
            senha = sharedpreferences.getString("SENHA",null);

            if(USER.equals(usuario) && SENHA.equals(senha)){
                Intent segtela1 = new Intent(this, Configuracao.class);
                startActivity(segtela1);
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                //startActivity(new Intent(this, ParcelavistaActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                //finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                finish();
                break;
            default:break;
        }
        return true;
    }
}
