package com.alura.dvj.conversordemonedas.main;

import com.alura.dvj.conversordemonedas.calculos.CalculadoraDeConversiones;
import com.alura.dvj.conversordemonedas.modelos.Moneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class mainHttpRequest {
    public static String usarMoneda(Moneda moneda) {
        return moneda.getNombre();
    }

    public static void realizarSolicitud(Moneda moneda) {
        String monedaBase = usarMoneda(moneda);
        String direccion = "https://v6.exchangerate-api.com/v6/6ec2f875c544779dc9c9025b/latest/" + monedaBase;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ExchangeRateData exchangeRateData = gson.fromJson(json, ExchangeRateData.class);

            if (exchangeRateData != null && exchangeRateData.conversion_rates != null) {
                ConversionRates conversionRates = exchangeRateData.conversion_rates;
                double tasaConversion = obtenerTasaConversion(moneda.getConvertirAPais(), conversionRates);
                double conversionFinal = moneda.getCantidadAConvertir() * tasaConversion;
                moneda.setConversion(conversionFinal);
            } else {
                System.out.println("No se pudieron obtener las tasas de cambio.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static double obtenerTasaConversion(String convertirAPais, ConversionRates conversionRates) {
        switch (convertirAPais) {
            case "ARS":
                return conversionRates.getARS();
            case "BRL":
                return conversionRates.getBRL();
            case "COP":
                return conversionRates.getCOP();
            case "MXN":
                return conversionRates.getMXN();
            case "USD":
                return conversionRates.getUSD();
            default:
                return 1.0;
        }
    }
}

class ExchangeRateData {
    String base_code;
    ConversionRates conversion_rates;
}
