import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        ConversorMoeda conversor = new ConversorMoeda();
        Moedas moedas = conversor.principalMoedas();

        double busca = 0;

        while (busca != 7) {
            System.out.println("*****************************************************");
            System.out.println("Seja bem-vindo(a) ao Conversor de Moeda =]");
            System.out.println(" ");
            System.out.println("1) Dólar =>> Real Brasileiro");
            System.out.println("2) Real Brasileiro =>> Dólar");
            System.out.println("3) Dólar =>> Peso Argentino");
            System.out.println("4) Peso Argentino =>> Dólar");
            System.out.println("5) Dólar =>> Euro");
            System.out.println("6) Euro =>> Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida: ");
            System.out.println("*****************************************************");
            busca = leitura.nextDouble();

            if (busca == 7) {
                System.out.println("Volte sempre que precisar! ");
                break;
            } else if (busca == 1) {
                double valorParaConverter = conversor.lerValorParaConverter(moedas);
                String moedaOrigem = "USD";
                String moedaDestino = "BRL";
                double resultado = conversor.converter(valorParaConverter, moedaOrigem, moedaDestino, moedas);
                System.out.printf("O valor convertido de %s para %s é: R$ %.2f%n", moedaOrigem, moedaDestino, resultado);
            } else if (busca == 2) {
                double valorParaConverter = conversor.lerValorParaConverter(moedas);
                String moedaOrigem = "BRL";
                String moedaDestino = "USD";
                double resultado = conversor.converter(valorParaConverter, moedaOrigem, moedaDestino, moedas);
                System.out.printf("O valor convertido de %s para %s é: $ %.2f%n", moedaOrigem, moedaDestino, resultado);
            } else if (busca == 3) {
                double valorParaConverter = conversor.lerValorParaConverter(moedas);
                String moedaOrigem = "USD";
                String moedaDestino = "ARS";
                double resultado = conversor.converter(valorParaConverter, moedaOrigem, moedaDestino, moedas);
                System.out.printf("O valor convertido de %s para %s é: ARS %.2f%n", moedaOrigem, moedaDestino, resultado);
            } else if (busca == 4) {
                double valorParaConverter = conversor.lerValorParaConverter(moedas);
                String moedaOrigem = "ARS";
                String moedaDestino = "USD";
                double resultado = conversor.converter(valorParaConverter, moedaOrigem, moedaDestino, moedas);
                System.out.printf("O valor convertido de %s para %s é: $ %.2f%n", moedaOrigem, moedaDestino, resultado);
            } else if (busca == 5) {
                double valorParaConverter = conversor.lerValorParaConverter(moedas);
                String moedaOrigem = "USD";
                String moedaDestino = "EUR";
                double resultado = conversor.converter(valorParaConverter, moedaOrigem, moedaDestino, moedas);
                System.out.printf("O valor convertido de %s para %s é: € %.2f%n", moedaOrigem, moedaDestino, resultado);
            } else if (busca == 6) {
                double valorParaConverter = conversor.lerValorParaConverter(moedas);
                String moedaOrigem = "EUR";
                String moedaDestino = "USD";
                double resultado = conversor.converter(valorParaConverter, moedaOrigem, moedaDestino, moedas);
                System.out.printf("O valor convertido de %s para %s é: $ %.2f%n", moedaOrigem, moedaDestino, resultado);
            } else {
                System.out.println("Opção inválida! Tente novamente. ");
            }
        }
    }
}