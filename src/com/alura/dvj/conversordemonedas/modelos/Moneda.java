package com.alura.dvj.conversordemonedas.modelos;

public class Moneda {
    String nombre;
    String convertirAPais;
    double cantidadAConvertir;
    double conversion;


    public Moneda(String nombre, String convertirAPais, double cantidadAConvertir,double conversion){
        this.nombre=nombre;
        this.convertirAPais=convertirAPais;
        this.cantidadAConvertir=cantidadAConvertir;
        this.conversion=conversion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConvertirAPais() {
        return convertirAPais;
    }

    public void setConvertirAPais(String convertirAPais) {
        this.convertirAPais = convertirAPais;
    }

    public double getCantidadAConvertir() {
        return cantidadAConvertir;
    }

    public void setCantidadAConvertir(double cantidadAConvertir) {
        this.cantidadAConvertir = cantidadAConvertir;
    }

    public double getConversion() {
        return conversion;
    }

    public void setConversion(double conversion) {
        this.conversion = conversion;
    }

    @Override
    public String toString(){
        return "nombre de moneda: "+nombre+"\nPais a convertir: "+convertirAPais+"\nCantidad a convertir: "+cantidadAConvertir+"\nconversion: "+ conversion;
    }
}
