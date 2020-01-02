package com.example.hr_server.calcloja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class adapterCalc extends ArrayAdapter<Calculo> {
    private final Context context;
    private ArrayList<Calculo>  calc;

    public adapterCalc(Context context, ArrayList<Calculo> calc){
        super(context,R.layout.listacom, calc);
        this.context= context;
        this.calc = calc;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listacom,parent, false);

        TextView parcela = (TextView)rowView.findViewById(R.id.parcela);
        TextView valorp =rowView.findViewById(R.id.valorp);
        TextView total = rowView.findViewById(R.id.total);

        parcela.setText(calc.get(position).getX());
        //parcela.setText(Calculo.getItem(position).getX());
        valorp.setText(calc.get(position).getI());
        total.setText(calc.get(position).getG());

        return rowView;
    }
}
