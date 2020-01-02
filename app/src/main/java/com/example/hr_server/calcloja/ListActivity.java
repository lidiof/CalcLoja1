package com.example.hr_server.calcloja;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.hr_server.calcloja.R.layout.listacom;

public class ListActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String mypreference = "Juros";

    private ListView lista;
    private double[] juros;

    private int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lista = findViewById(R.id.lista);

        ArrayList<Calculo> calculo = addcalc();
        ArrayAdapter adapter = new adapterCalc(this,calculo);
        lista.setAdapter(adapter);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("VOLTAR");
    }
    private  ArrayList<Calculo> addcalc() {
        ArrayList<Calculo> calculo = new ArrayList<Calculo>();
        String item = getIntent().getExtras().getString("item");// valor do produto
        String dec = getIntent().getExtras().getString("dec");// valor do desconto

        int c = getIntent().getExtras().getInt("c");
        String u = getIntent().getExtras().getString("u");
        double x, g = 0,
                va = Float.parseFloat(item), // valor do produto
                vd = Float.parseFloat(dec), // valor do desconto
                i=0, vc, vpl= Float.parseFloat(u);
        DecimalFormat df = new DecimalFormat("R$ 0.00");
        DecimalFormat d = new DecimalFormat("0");

        Carregar();

        if (c == 2) {// crediario
            String p = null;
            double parcela;
            parcela = 18;
            if(vd>0){
                parcela = 17;
            }
            for (x = 0; x < parcela; x++) {
                    g = va+(va*((x+1)*(juros[(int) x ]/100)));
                        i = (g / (x+1));
                        if(vd>0){
                            i=(g-vd)/(x+1);

                    }
                    p = d.format(x+1) + " X";
                    if (vd > 0) {
                        p = d.format(x+2) +"X = 1 + "+ d.format(x+1) + "";
                    }
                    String vp = df.format(i);
                    String t = df.format(g);
                    Calculo e = new Calculo(p, vp, t);
                    calculo.add(e);
            }
        }

            if (c == 1) {// cartao
                for (x = 1; x <= 12; x++) {
                    g = va;
                    i = (g - vd) / x;
                    String p = d.format(x) + " X";
                    String vp = df.format(i);
                    String t = df.format(g);
                    Calculo e = new Calculo(p, vp, t);
                    calculo.add(e);
                }
            }
            if (c == 3) {
                String p = null;
                double y;
                if(vpl==0){
                    vpl=18;
                }
                if(vpl==1){
                    g=va;
                    i=g;
                    p = d.format(1) + " X";
                    String vp = df.format(i);
                    String t = df.format(g);
                    Calculo e = new Calculo(p, vp, t);
                    calculo.add(e);
                }
                    if (vpl>1 && vpl <= 7) {
                        g = va;
                        i = (g) / vpl;
                        y=1;
                        if(vd>0){
                            i=(g-vd)/(vpl-1);
                            vpl= vpl-1;
                            Calculo e = new Calculo("ENTRADA", String.valueOf(df.format(vd)), String.valueOf(df.format(g)));
                            calculo.add(e);
                            y=2;
                        }
                        for (x = 1; x <= vpl; x++, y++) {
                            p = d.format(y) + " X";
                            String vp = df.format(i);
                            String t = df.format(g);
                            Calculo e = new Calculo(p, vp, t);
                            calculo.add(e);
                        }
                    }
                    if (vpl == 8) {
                        g = va + (va * (vpl * (2.00 / 100)));
                        i = (g) / vpl;
                        y=1;
                        if(vd>0){
                            i=(g-vd)/(vpl-1);
                            vpl= vpl-1;
                            Calculo e = new Calculo("ENTRADA", String.valueOf(df.format(vd)), String.valueOf(df.format(g)));
                            calculo.add(e);
                            y=2;
                        }
                        for (x = 1; x <= vpl; x++, y++) {
                            p = d.format(y) + " X";
                            String vp = df.format(i);
                            String t = df.format(g);
                            Calculo e = new Calculo(p, vp, t);
                            calculo.add(e);
                        }
                    }
                    if (vpl >= 9 && vpl <= 10) {
                        g = va + (va * (vpl * (2.50 / 100)));
                        i = (g) / vpl;
                        y=1;
                        if(vd>0){
                            i=(g-vd)/(vpl-1);
                            vpl= vpl-1;
                            Calculo e = new Calculo("ENTRADA", String.valueOf(df.format(vd)), String.valueOf(df.format(g)));
                            calculo.add(e);
                            y=2;
                        }
                        for (x = 1; x <= vpl; x++, y++) {
                            p = d.format(y) + " X";
                            String vp = df.format(i);
                            String t = df.format(g);
                            Calculo e = new Calculo(p, vp, t);
                            calculo.add(e);
                        }
                    }
                    if (vpl >= 11 && vpl <= 12) {
                        g = va + (va * (vpl * (3.00 / 100)));
                        i = (g) / vpl;
                        y=1;
                        if(vd>0){
                            i=(g-vd)/(vpl-1);
                            vpl= vpl-1;
                            Calculo e = new Calculo("ENTRADA", String.valueOf(df.format(vd)), String.valueOf(df.format(g)));
                            calculo.add(e);
                            y=2;
                        }

                        for (x = 1; x <= vpl; x++, y++) {
                            p = d.format(y) + " X";
                            String vp = df.format(i);
                            String t = df.format(g);
                            Calculo e = new Calculo(p, vp, t);
                            calculo.add(e);
                        }
                    }
                    if (vpl >= 13) {
                        g = va + (va * (vpl * (3.50 / 100)));
                        i = (g) / vpl;
                        y=1;
                        if(vd>0){
                            i=(g-vd)/(vpl-1);
                            vpl= vpl-1;
                            Calculo e = new Calculo("ENTRADA", String.valueOf(df.format(vd)), String.valueOf(df.format(g)));
                            calculo.add(e);
                            y=2;
                        }
                        for (x = 1; x <= vpl; x++, y++) {
                            p = d.format(y) + " X";
                            String vp = df.format(i);
                            String t = df.format(g);
                            Calculo e = new Calculo(p, vp, t);
                            calculo.add(e);
                        }
                    }
        }
        return calculo;
    }
    public void Carregar(){
        try {
            sharedpreferences = getSharedPreferences(mypreference, 0);

            juros= new double[18];
            for(x=0;x<18;x++){
                juros[x] = Double.valueOf( sharedpreferences.getString(String.valueOf(x),"0"));
            }

        }catch (Exception ex){
            Toast.makeText(this,"deu erro carregar " + ex,Toast.LENGTH_SHORT).show();
        }
    }
    public void Salvar(){
        try {
            sharedpreferences = getSharedPreferences(mypreference, 0);


            double n = (double) sharedpreferences.getFloat(String.valueOf(0),0); // getting String
            Toast.makeText(this,"deu certo: "+ n,Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Toast.makeText(this,"deu erro " + ex,Toast.LENGTH_SHORT).show();
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


