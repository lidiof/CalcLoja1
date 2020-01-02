package com.example.hr_server.calcloja;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AvistaActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "Juros";
    private EditText edtvalor;
    private TextView idcalc;
    private Button butadd;
    double vista = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avista);

        butadd = (Button)findViewById(R.id.butadd);
        idcalc = (TextView)findViewById(R.id.idcalc);
        edtvalor = (EditText)findViewById(R.id.edtvalor);

        try {
            Carregar();
        }catch (Exception X){
            Salvar();
        }

        butadd.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("VOLTAR");
    }

    @Override
    public void onClick(View v) {
        if(v == butadd){
            try {
                double item = Double.parseDouble(edtvalor.getText().toString());
                double c, i = item;
                //resultado = (valor*porcentagem)/100;
                c = i - ( (vista * i)/100);
                String str = Double.toString(c);
                idcalc.setText("Valor a vista: " + c );
            }catch (Exception X){
                AlertDialog.Builder dig = new AlertDialog.Builder(this);
                dig.setMessage("Valor vazio!!");
                dig.setNeutralButton("OK", null);
                dig.show();
            }
        }
    }
    public void Carregar(){

        sharedpreferences = getSharedPreferences(mypreference, 0);

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
