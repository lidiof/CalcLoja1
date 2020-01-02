package com.example.hr_server.calcloja;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.content.SharedPreferences;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    SharedPreferences sharedpreferences;
    public static final String mypreference = "Juros";

    private Button butadd,btnConfigurar;
    private RadioGroup rg;
    int c=1;
    int x;
    private double[] juros = {
            0.00,
            0.00,
            0.00,
            0.00,
            0.00,
            0.00,
            1.00,
            1.50,
            1.60,
            1.80,
            2.00,
            2.30,
            2.50,
            3.00,
            3.00,
            3.50,
            3.50,
            3.50};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butadd = (Button)findViewById(R.id.butadd);
        btnConfigurar = (Button)findViewById(R.id.btnConfig);
        rg = (RadioGroup)findViewById(R.id.rg);
        //Salvar();
        try {
            Carregar();
        }catch (Exception ex){
            Salvar();
        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.vista:
                     c=1;
                     break;
                    case R.id.pv:
                        c=2;
                        break;
                    case R.id.cc:
                        c=3;
                        break;
                }
            }
        });
        butadd.setOnClickListener(this);
       btnConfigurar.setOnClickListener(this);
    }
    public void Carregar(){

            sharedpreferences = getSharedPreferences(mypreference, 0);

            //juros= new double[18];
            for(x=0;x<18;x++){
                juros[x] = Double.valueOf( sharedpreferences.getString(String.valueOf(x),"NULL"));
            }


    }
    public void Salvar(){
        try {
            sharedpreferences = getSharedPreferences(mypreference, 0);
            SharedPreferences.Editor editor = sharedpreferences.edit();
           editor.clear();


            for(x=0;x<18;x++) {
                editor.putString(String.valueOf(x), String.valueOf(juros[x]));
                //editor.putFloat(String.valueOf(x), (float) juros[x]);
            }
            editor.putString("ValorAvista", "10");

            editor.commit();

        }catch (Exception ex){
            Toast.makeText(this,"deu erro",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
        public void onClick(View v) {
        if (v == butadd) {
            if( c ==1){
                Intent segtela = new Intent(this, AvistaActivity.class);
                startActivity(segtela);
            }
            if(c==2){
                Intent segtela = new Intent(this, ParcelavistaActivity.class);
                startActivity(segtela);
            }
            if(c==3){
                Intent segtela = new Intent(this, CartaoActivity.class);
                startActivity(segtela);
            }
        }
        if(v == btnConfigurar){
            Intent segtela1 = new Intent(this, Login.class);
            startActivity(segtela1);
        }
    }
}
