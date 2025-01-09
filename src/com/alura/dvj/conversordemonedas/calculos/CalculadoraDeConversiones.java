package com.alura.dvj.conversordemonedas.calculos;

import com.alura.dvj.conversordemonedas.main.ConversionRates;
import com.alura.dvj.conversordemonedas.modelos.Moneda;


public class CalculadoraDeConversiones {

    private int opcionSeleccionada;

    // Setter
    public void setOpcionSeleccionada(int opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }

    // Getter
    public int getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    /*
    public double resuldatoDeConversion(doble a,double b){
        double resuldatoDeConversion;
        resuldatoDeConversion= b * a;
        return resuldatoDeConversion;
    }*/
    public double obtenerMonedaOriginal(Moneda moneda){
        double monedaOriginal = moneda.getCantidadAConvertir();
        return monedaOriginal;

    }
    public double obtenerMonedaAConvertir(ConversionRates conversionRates){
        double USD =conversionRates.getUSD();
        double ARS =conversionRates.getARS();
        double BRL =conversionRates.getBRL();
        double COP = conversionRates.getCOP();
        double MXN =conversionRates.getMXN();
        if (opcionSeleccionada==1){
            return ARS;
        } else if (opcionSeleccionada==2) {
            return USD;
        } else if (opcionSeleccionada==3) {
            return BRL;
        } else if (opcionSeleccionada==4) {
            return USD;
        } else if (opcionSeleccionada==5) {
            return COP;
        } else if (opcionSeleccionada==6) {
            return USD;
        } else if (opcionSeleccionada==7) {
            return MXN;
        } else if (opcionSeleccionada==8) {
            return USD;
        }
        return 0;
    }
    public double realizarConversion(Moneda moneda, ConversionRates conversionRates ){
        double monedaOriginal=obtenerMonedaOriginal(moneda);
        double monedaAConvertir= obtenerMonedaAConvertir(conversionRates);
        double conversionFinal = monedaAConvertir*monedaOriginal;
        moneda.setConversion(conversionFinal);
        return conversionFinal;
    }
}

