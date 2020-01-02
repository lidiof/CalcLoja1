package com.example.hr_server.calcloja;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18;
    private Button btnSalvar,btnRestaurar,btnCancelar;
    private double[] juros;
    private double[] p;
    private int x;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "Juros";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita);

        p1= findViewById(R.id.p1);
        p2= findViewById(R.id.p2);
        p3= findViewById(R.id.p3);
        p4= findViewById(R.id.p4);
        p5= findViewById(R.id.p5);
        p6= findViewById(R.id.p6);
        p7= findViewById(R.id.p7);
        p8= findViewById(R.id.p8);
        p9= findViewById(R.id.p9);
        p10= findViewById(R.id.p10);
        p11= findViewById(R.id.p11);
        p12= findViewById(R.id.p12);
        p13= findViewById(R.id.p13);
        p14= findViewById(R.id.p14);
        p15= findViewById(R.id.p15);
        p16= findViewById(R.id.p16);
        p17= findViewById(R.id.p17);
        p18= findViewById(R.id.p18);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnRestaurar = findViewById(R.id.btnRestaurar);
        btnCancelar = findViewById(R.id.btnCancelar);
        Carregar();

        p1.setText(String.valueOf(juros[0]));
        p2.setText(String.valueOf(juros[1]));
        p3.setText(String.valueOf(juros[2]));
        p4.setText(String.valueOf(juros[3]));
        p5.setText(String.valueOf(juros[4]));
        p6.setText(String.valueOf(juros[5]));
        p7.setText(String.valueOf(juros[6]));
        p8.setText(String.valueOf(juros[7]));
        p9.setText(String.valueOf(juros[8]));
        p10.setText(String.valueOf(juros[9]));
        p11.setText(String.valueOf(juros[10]));
        p12.setText(String.valueOf(juros[11]));
        p13.setText(String.valueOf(juros[12]));
        p14.setText(String.valueOf(juros[13]));
        p15.setText(String.valueOf(juros[14]));
        p16.setText(String.valueOf(juros[15]));
        p17.setText(String.valueOf(juros[16]));
        p18.setText(String.valueOf(juros[17]));

        btnSalvar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
        btnRestaurar.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("VOLTAR");
    }
    public void Carregar(){
        try {
            sharedpreferences = getSharedPreferences(mypreference, 0);

            juros= new double[18];
            for(x=0;x<18;x++){
                juros[x] = Double.valueOf( sharedpreferences.getString(String.valueOf(x),"0"));
            }

        }catch (Exception ex){
            Toast.makeText(this,"deu erro " + ex,Toast.LENGTH_SHORT).show();
        }
    }

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

    @Override
    public void onClick(View view) {
        if(view == btnSalvar){
            int y=99;
            p = new double[18];
            try {
                p[0] = Double.parseDouble((p1.getText().toString()));
                p[1] = Double.parseDouble(p2.getText().toString());
                p[2] = Double.parseDouble(p3.getText().toString());
                p[3] = Double.parseDouble(p4.getText().toString());
                p[4] = Double.parseDouble(p5.getText().toString());
                p[5] = Double.parseDouble(p6.getText().toString());
                p[6] = Double.parseDouble(p7.getText().toString());
                p[7] = Double.parseDouble(p8.getText().toString());
                p[8] = Double.parseDouble(p9.getText().toString());
                p[9] = Double.parseDouble(p10.getText().toString());
                p[10] = Double.parseDouble(p11.getText().toString());
                p[11] = Double.parseDouble(p12.getText().toString());
                p[12] = Double.parseDouble(p13.getText().toString());
                p[13] = Double.parseDouble(p14.getText().toString());
                p[14] = Double.parseDouble(p15.getText().toString());
                p[15] = Double.parseDouble(p16.getText().toString());
                p[16] = Double.parseDouble(p17.getText().toString());
                p[17] = Double.parseDouble(p18.getText().toString());

                Salvar();
                }catch (Exception EX){
                    Toast.makeText(this,"ERRO!!!",Toast.LENGTH_SHORT).show();
                }

            }
            if(view == btnCancelar){
                finish();
            }
            if(view == btnRestaurar){
                double[] juros1 = {
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
                p1.setText(String.valueOf(juros1[0]));
                p2.setText(String.valueOf(juros1[1]));
                p3.setText(String.valueOf(juros1[2]));
                p4.setText(String.valueOf(juros1[3]));
                p5.setText(String.valueOf(juros1[4]));
                p6.setText(String.valueOf(juros1[5]));
                p7.setText(String.valueOf(juros1[6]));
                p8.setText(String.valueOf(juros1[7]));
                p9.setText(String.valueOf(juros1[8]));
                p10.setText(String.valueOf(juros1[9]));
                p11.setText(String.valueOf(juros1[10]));
                p12.setText(String.valueOf(juros1[11]));
                p13.setText(String.valueOf(juros1[12]));
                p14.setText(String.valueOf(juros1[13]));
                p15.setText(String.valueOf(juros1[14]));
                p16.setText(String.valueOf(juros1[15]));
                p17.setText(String.valueOf(juros1[16]));
                p18.setText(String.valueOf(juros1[17]));
                try {
                    sharedpreferences = getSharedPreferences(mypreference, 0);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.clear();

                    int x;

                    for(x=0;x<18;x++) {
                        editor.putString(String.valueOf(x), String.valueOf(juros1[x]));

                    }
                    editor.commit();

                }catch (Exception ex){
                    Toast.makeText(this,"deu erro",Toast.LENGTH_SHORT).show();
                }

            }

        }
    public void Salvar(){
        try {
            sharedpreferences = getSharedPreferences(mypreference, 0);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();

            int x;

            for(x=0;x<18;x++) {
                editor.putString(String.valueOf(x), String.valueOf(p[x]));
                //editor.putFloat(String.valueOf(x), (float) juros[x]);
            }

            editor.commit();

        }catch (Exception ex){
            Toast.makeText(this,"deu erro",Toast.LENGTH_SHORT).show();
        }
    }
}

