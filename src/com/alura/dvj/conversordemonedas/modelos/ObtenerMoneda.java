package com.alura.dvj.conversordemonedas.modelos;
import com.alura.dvj.conversordemonedas.main.mainHttpRequest;
import com.alura.dvj.conversordemonedas.main.main;
import com.alura.dvj.conversordemonedas.modelos.Moneda;
import com.alura.dvj.conversordemonedas.modelos.MonedaFactory;

public class ObtenerMoneda {
    public String usarMoneda(Moneda moneda) {
        String monedaBase = moneda.getNombre();
        return monedaBase;
    }
}
