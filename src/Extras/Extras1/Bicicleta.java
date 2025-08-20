package Extras.Extras1;

import java.util.Scanner;

// Classe principal
public class Bicicleta {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String modelo = scanner.nextLine();

        String nivelStr = scanner.nextLine();

        // Converte a string para inteiro
        int nivelBateria = Integer.parseInt(nivelStr);

        // TODO: Crie um objeto da classe BicicletaInterna com os valores lidos:
        BicicletaInterna bicicleta = new BicicletaInterna(modelo, nivelBateria);

        // Chama o método que retorna a mensagem formatada e exibe no console
        System.out.println(bicicleta.obterMensagem());

        // Fecha o scanner (boa prática para liberar o recurso)
        scanner.close();
    }
}
class BicicletaInterna {
// TODO: Crie a classe interna que representa a bicicleta:


    // TODO: Adicione seus atributos privados: modelo e nível de bateria:
    private String modelo;
    private int nivelBateria;

    // TODO: Crie o construtor para inicializar os atributos:

    public BicicletaInterna(String modelo, int nivelBateria) {
        this.modelo = modelo;
        this.nivelBateria = nivelBateria;
    }


    // TODO: Implemente o método para calcular a distância máxima estimada
    private double calcularDistancia() {
        return this.nivelBateria * 0.5;
    }

    // Método para gerar a mensagem de saída formatada
    public String obterMensagem() {
        // Retorna a mensagem no formato solicitado, com uma casa decimal
        return String.format("%s: Distancia estimada = %.1f km", modelo, calcularDistancia());
    }
}
