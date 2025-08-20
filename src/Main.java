import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Domain.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menu();

        scanner.close();

    }

    public static void menu(){
        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1 - Calculadora");
            System.out.println("2 - Telefone");
            System.out.println("3 - Formatação");
            System.out.println("4 - Sair");
            var escolha = scanner.nextInt();
            scanner.nextLine();
            var opcao = Exercicios.values()[escolha - 1];


            switch (opcao) {
                case CALCULADORA -> calculadora();
                case TELEFONE -> telefone();
                case FORMATACAO -> formatacao();
                case SAIR -> System.exit(0);
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    public static void calculadora(){
        System.out.println("==== Programa de Calculadora ====");
        System.out.println("Informe os valores e qual operação deseja executar. (+ , - , * , /)");
        var conteudo = scanner.nextLine();

        String[] partes = conteudo.split(",");

        if (partes.length != 3){
            System.out.println("Formato inválido.");
            return;
        }

        double valor1 = Double.parseDouble(partes[0].trim());
        double valor2 = Double.parseDouble(partes[1].trim());
        String operacao = partes[2].trim();

        switch (operacao){
            case "+" -> Calculadora.soma(valor1, valor2);
            case "-" -> Calculadora.subtracao(valor1, valor2);
            case "*" -> Calculadora.multiplicacao(valor1, valor2);
            case "/" -> Calculadora.divisao(valor1, valor2);
            default -> System.out.println("Operação inválida.");
        }
    }

    public static void telefone(){
        System.out.println("==== Programa de Telefone ====");
        System.out.println("Insira o número de telefone.");
        String entrada = scanner.nextLine();

        System.out.println(FormatadorTelefone.formatar(entrada));
    }

    public static void formatacao(){
        List<Campo> campos = new ArrayList<>();

        System.out.println("Digite os campos no formato NOME_CAMPO;VALOR;TIPO;");

        while (true){
            String entrada = scanner.nextLine();
            if (entrada.isBlank()) break;

            String[] partes = entrada.split(";");
            if (partes.length != 3){
                System.out.println("Formato inválido.");
                continue;
            }

            campos.add(new Campo(partes[0].trim(), partes[1].trim(), partes[2].trim()));
        }

        System.out.println("\n--- JSON ---");
        campos.forEach(c -> System.out.println(
                "   \"" + c.nome + "\": { \"valor\": \"" + c.valor + "\", \"tipo\": \"" + c.tipo + "\" }"));

        System.out.println("\n--- XML ---");
        campos.forEach(c -> System.out.println(
                "  <" + c.nome + ">\n    <valor>" + c.valor + "</valor>\n    <tipo>" + c.tipo + "</tipo>\n  </" + c.nome + ">"));

        System.out.println("\n--- YAML ---");
        campos.forEach(c -> System.out.println(
                c.nome + ":\n  valor: " + c.valor + "\n  tipo: " + c.tipo));
    }
}
