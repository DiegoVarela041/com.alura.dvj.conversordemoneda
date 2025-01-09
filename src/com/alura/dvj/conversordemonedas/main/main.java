package com.alura.dvj.conversordemonedas.main;

import java.util.Scanner;
import com.alura.dvj.conversordemonedas.calculos.CalculadoraDeConversiones;
import com.alura.dvj.conversordemonedas.modelos.Moneda;
import com.alura.dvj.conversordemonedas.modelos.Opcion;

public class main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Opcion opcionObj = new Opcion();
        CalculadoraDeConversiones calculadora = new CalculadoraDeConversiones();

        int condicion = 1;
        while (condicion == 1) {
            System.out.println("****************************************************************");
            System.out.println("Sea bienvenido al conversor de monedas");
            System.out.println("Digite una de las siguientes opciones a convertir");
            System.out.println("1) Dolar a Peso argentino\n" +
                    "2) Peso argentino a Dolar\n" +
                    "3) Dolar a Real brasileño\n" +
                    "4) Real brasileño a Dolar\n" +
                    "5) Dolar a Peso colombiano\n" +
                    "6) Peso colombiano a Dolar\n" +
                    "7) Dolar a Peso mexicano\n" +
                    "8) Peso mexicano a Dolar\n" +
                    "9) Salir");

            opcionObj.setOpcion(lectura.nextInt());
            calculadora.setOpcionSeleccionada(opcionObj.getOpcion());

            if (opcionObj.getOpcion() == 9) {
                System.out.println("Hasta luego!");
                break;
            }

            Moneda moneda = new Moneda("", "", 0, 0);
            switch (opcionObj.getOpcion()) {
                case 1:
                    moneda.setNombre("USD");
                    moneda.setConvertirAPais("ARS");
                    System.out.println("Digite la cantidad a convertir de Dolar a Peso argentino:");
                    break;
                case 2:
                    moneda.setNombre("ARS");
                    moneda.setConvertirAPais("USD");
                    System.out.println("Digite la cantidad a convertir de Peso argentino a Dolar:");
                    break;
                case 3:
                    moneda.setNombre("USD");
                    moneda.setConvertirAPais("BRL");
                    System.out.println("Digite la cantidad a convertir de Dolar a Real brasileño:");
                    break;
                case 4:
                    moneda.setNombre("BRL");
                    moneda.setConvertirAPais("USD");
                    System.out.println("Digite la cantidad a convertir de Real brasileño a Dolar:");
                    break;
                case 5:
                    moneda.setNombre("USD");
                    moneda.setConvertirAPais("COP");
                    System.out.println("Digite la cantidad a convertir de Dolar a Peso colombiano:");
                    break;
                case 6:
                    moneda.setNombre("COP");
                    moneda.setConvertirAPais("USD");
                    System.out.println("Digite la cantidad a convertir de Peso colombiano a Dolar:");
                    break;
                case 7:
                    moneda.setNombre("USD");
                    moneda.setConvertirAPais("MXN");
                    System.out.println("Digite la cantidad a convertir de Dolar a Peso mexicano:");
                    break;
                case 8:
                    moneda.setNombre("MXN");
                    moneda.setConvertirAPais("USD");
                    System.out.println("Digite la cantidad a convertir de Peso mexicano a Dolar:");
                    break;
                default:
                    System.out.println("Elige una opción válida");
                    continue;
            }

            moneda.setCantidadAConvertir(lectura.nextDouble());
            mainHttpRequest mainHttpRequest = new mainHttpRequest();
            mainHttpRequest.realizarSolicitud(moneda);

            System.out.println(moneda);
            System.out.println("FINNNNNNNNNNNNNNNNNNNNNNNNN");
            System.out.println("****************************************************************");
        }
    }
}
