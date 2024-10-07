import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMoeda {
    public Moedas principalMoedas() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/9a5496f402ef272b7a8ecbff/latest/USD"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        JsonElement root = JsonParser.parseString(response.body());
        JsonObject jsonobj = root.getAsJsonObject();

        JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");

        Moedas moedas = new Moedas(
                conversionRates.get("USD").getAsDouble(),
                conversionRates.get("BRL").getAsDouble(),
                conversionRates.get("ARS").getAsDouble(),
                conversionRates.get("EUR").getAsDouble()
        );
        return moedas;
    }

    private double getRate(String currency, Moedas moedas) {
        return switch (currency) {
            case "USD" -> moedas.USD();
            case "BRL" -> moedas.BRL();
            case "ARS" -> moedas.ARS();
            case "EUR" -> moedas.EUR();
            default -> throw new IllegalArgumentException("Moeda não suportada: " + currency);
        };
    }

    public double converter(double valor, String moedaOrigem, String moedaDestino, Moedas moedas) {
        double taxaBase = getRate(moedaOrigem, moedas);
        double taxaDestino = getRate(moedaDestino, moedas);

        return (valor / taxaBase) * taxaDestino;
    }

    public double lerValorParaConverter(Moedas moedas) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o valor que deseja converter: ");
        double busca = leitura.nextDouble();
        return busca;
    }
}