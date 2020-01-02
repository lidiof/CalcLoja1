package com.example.hr_server.calcloja;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class CartaoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtvalor, edtvalord;
    private Button butadd;
    private RadioGroup rg;
    int c=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao);
        edtvalor = (EditText)findViewById(R.id.edtvalor);
        edtvalord = (EditText)findViewById(R.id.edtvalord);
        butadd = (Button)findViewById(R.id.butadd);


        butadd.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("VOLTAR");

    }

    @Override
    public void onClick(View v) {
        if (v == butadd ) {
            String item = edtvalor.getText().toString();
            String dec = edtvalord.getText().toString();

            //2º tela
            if(item.trim().isEmpty()){
                AlertDialog.Builder dig = new AlertDialog.Builder(this);
                dig.setMessage("Valor vazio1!!");
                dig.setNeutralButton("OK", null);
                dig.show();
            }else {
                if(dec.trim().isEmpty()){
                    dec = "0";
                }
                Intent segtela = new Intent(this, ListActivity.class);
                String u="0";
                segtela.putExtra("item", item);
                segtela.putExtra("dec", dec);
                segtela.putExtra("c", c);
                segtela.putExtra("u",u);
                startActivity(segtela);
                //2º tela
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
