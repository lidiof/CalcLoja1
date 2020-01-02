package com.example.hr_server.calcloja;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class ParcelavistaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtvalor, edtvalord;
    private Button butadd,btnCofiguracao;
    //private Spinner spn;
    private String item;
    private String dec;
    private int c=2;
    private String m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crediario);

        edtvalor = (EditText)findViewById(R.id.edtvalor); // valor do produto
        edtvalord = (EditText)findViewById(R.id.edtvalord); // valor do desconto
        butadd = (Button)findViewById(R.id.butadd);
        //btnCofiguracao = (Button)findViewById(R.id.btnConfiguracao);

        butadd.setOnClickListener(this);
        //btnCofiguracao.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("VOLTAR");

    }

    @Override
    public void onClick(View v) {
        if (v == butadd ) {
            String item = edtvalor.getText().toString();// valor do produto
            String dec = edtvalord.getText().toString();// valor do desconto

            //2º tela
            if(item.trim().isEmpty()){
                AlertDialog.Builder dig = new AlertDialog.Builder(this);
                dig.setMessage("Valor vazio!!");
                dig.setNeutralButton("OK", null);
                dig.show();
            }else {
                if(dec.trim().isEmpty()){
                    dec = "0";
                }
                Intent segtela = new Intent(this, ListActivity.class);
                String u="0";
                segtela.putExtra("item", item); // valor do produto
                segtela.putExtra("dec", dec);// valor do desconto
                segtela.putExtra("c", c);
                segtela.putExtra("u",u);
                startActivity(segtela);
                //2º tela
            }
        }
        /*if (v == btnCofiguracao){
            Intent segtela = new Intent(this, EditaActivity.class);
            startActivity(segtela);
        }*/

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
