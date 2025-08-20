package Domain;

public class Calculadora {

    public static void soma(double valor1, double valor2) {
        System.out.printf("\n %.2f + %.2f = %.2f", valor1, valor2, valor1 + valor2);
    }

    public static void subtracao(double valor1, double valor2) {
        System.out.printf("\n %.2f - %.2f = %.2f", valor1, valor2, valor1 - valor2);
    }

    public static void multiplicacao(double valor1, double valor2) {
        System.out.printf("\n %.2f * %.2f = %.2f", valor1, valor2, valor1 * valor2);
    }

    public static void divisao(double valor1, double valor2) {
        System.out.printf("\n %.2f / %.2f = %.2f", valor1, valor2, valor1 / valor2);
    }
}
