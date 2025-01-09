package com.alura.dvj.conversordemonedas.modelos;
import com.alura.dvj.conversordemonedas.modelos.Moneda;

public class MonedaFactory {

    // Método para crear una instancia de Moneda
    public static Moneda crearMoneda(String xd, String convertirAPais, double cantidadAConvertir, double conversion) {
        return new Moneda(xd, convertirAPais, cantidadAConvertir, conversion);
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la función crearMoneda
        Moneda monedaUSDARS = crearMoneda("USD", "ARS", 100.0, 350.0);

        // Mostrar información de las monedas
        System.out.println(monedaUSDARS.toString());
    }
}

