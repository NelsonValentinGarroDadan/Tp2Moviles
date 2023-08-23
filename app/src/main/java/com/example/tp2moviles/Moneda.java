package com.example.tp2moviles;

import java.io.Serializable;

public class Moneda implements Serializable {
    private String Nombre;
    private double Valor;

    private double Importer;

    public Moneda(String nombre, double valor,double importer) {
        Nombre = nombre;
        Valor = valor;
        Importer = importer;
    }

    public Moneda(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }

    public double getImporter() {
        return Importer;
    }

    public void setImporter(double importer) {
        this.Importer = importer;
    }
}
