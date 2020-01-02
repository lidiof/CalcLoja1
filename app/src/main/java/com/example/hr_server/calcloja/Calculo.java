package com.example.hr_server.calcloja;

public class Calculo {
    private String x;
    private String i;
    private String g;

    public Calculo(String x, String i, String g){
        this.setX(x);
        this.setI(i);
        this.setG(g);
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }
}
