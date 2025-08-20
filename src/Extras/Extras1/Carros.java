package Extras.Extras1;

import java.util.Scanner;

public class Carros {
// TODO: Crie o método estático que verifica se o carro está apto:
    public static String verificarApto(String modelo, int anoFabricacao, int anoAtual) {
        // TODO: Calcule a idade do carro:
        int idade = anoAtual - anoFabricacao;

        // TODO: Verifique se o carro tem até 10 anos:
        if (idade <= 10) {
            return modelo +": Apto";
        } else {
            return modelo +": Nao apto";
        }
    }




    public static void main(String[] args) {
        // Criando o scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Lendo os dados de entrada
        String modelo = scanner.nextLine();
        int anoFabricacao = scanner.nextInt();
        int anoAtual = scanner.nextInt();

        // TODO Implemente a chamada do método para verificar se o carro está apto:
        String resultado = verificarApto(modelo, anoFabricacao, anoAtual);

        // Exibindo o resultado
        System.out.println(resultado);

        scanner.close();
    }
}
