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

public class Configuracao extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedpreferences;
    public static final String mypreference = "Juros", SENHA = "USER";
    private Button btnValoravista,btnJuros,btnSenha;
    private EditText edtAvista,edtSenha;
    private double vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        btnValoravista = findViewById(R.id.btnValoravista);// edit valor a vista
        edtAvista = findViewById(R.id.EdtAvista);// edit valor a vista

        btnJuros = findViewById(R.id.btnJuros);

        btnSenha = findViewById(R.id.btnSenha);
        edtSenha = findViewById(R.id.EdtSenha);
        try {
            Carregar();
        }catch (Exception X){
            Salvar();
        }


        btnValoravista.setOnClickListener(this);
        btnJuros.setOnClickListener(this);
        btnSenha.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("VOLTAR");
    }


    public void Carregar(){

        sharedpreferences = getSharedPreferences(mypreference, 0);

        //juros= new double[18];

        vista = Double.valueOf( sharedpreferences.getString("ValorAvista",null));

    }
    public void Salvar(){
        try {
            sharedpreferences = getSharedPreferences(mypreference, 0);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();


            editor.putString("ValorAvista", "10");
            editor.commit();

        }catch (Exception ex){
            Toast.makeText(this,"deu erro",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        if(view == btnValoravista){

            try {
                sharedpreferences = getSharedPreferences(mypreference, 0);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                //editor.clear();
                vista = Double.parseDouble(edtAvista.getText().toString());

                editor.putString("ValorAvista", String.valueOf(vista));
                Toast.makeText(this,"O valor de desconto e: "+ vista+ "%",Toast.LENGTH_SHORT).show();
                editor.commit();
            }catch (Exception X){
                Toast.makeText(this,"ERRO!!",Toast.LENGTH_SHORT).show();
            }
        }
        if(view == btnJuros){
            Intent segtela1 = new Intent(this, EditaActivity.class);
            startActivity(segtela1);

        }
        if(view == btnSenha){
            try {
                sharedpreferences = getSharedPreferences(SENHA, 0);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                //editor.clear();
                String text;
                text = edtSenha.getText().toString();

                editor.putString("SENHA", text);
                Toast.makeText(this,"A senha foi alterada",Toast.LENGTH_SHORT).show();
                editor.commit();
            }catch (Exception X){
                Toast.makeText(this,"ERRO!!",Toast.LENGTH_SHORT).show();
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
