package Domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

public class FormatadorTelefone {
    private static final Map<Pattern, Function<String, String>> FORMATADORES = new LinkedHashMap<>();

    static{
        // (##) ####-####
        FORMATADORES.put(Pattern.compile("\\(\\d{2}\\) \\d{4}-\\d{4}"), s -> "Telefone Fixo: " + s);

        // ####-####
        FORMATADORES.put(Pattern.compile("\\d{4}-\\d{4}"), s -> "Telefone Fixo: " + s);

        // (##) #####-####
        FORMATADORES.put(Pattern.compile("\\(\\d{2}\\) \\d{5}-\\d{4}"), s -> "Celular: " + s);

        // #####-####
        FORMATADORES.put(Pattern.compile("\\d{5}-\\d{4}"), s -> "Celular: " + s);
    }

    public static String formatar(String entrada){
        for (Map.Entry<Pattern, Function<String, String>> entry : FORMATADORES.entrySet()) {
            if (entry.getKey().matcher(entrada).matches()) {
                return entry.getValue().apply(entrada);
            }
        }

        String numeros = entrada.replaceAll("\\D", "");

        return switch (numeros.length()){
            case 8 -> "Telefone Fixo: " + numeros.substring(0,4) + "-" + numeros.substring(4,8);
            case 10 -> "Telefone Fixo: (" + numeros.substring(0,2) + ") " + numeros.substring(2,6) + "-" + numeros.substring(6,10);
            case 9 -> "Celular: " + numeros.substring(0,5) + "-" + numeros.substring(5,9);
            case 11 -> "Celular: (" + numeros.substring(0,2) + ") " + numeros.substring(2,7) + "-" + numeros.substring(7,11);
            default -> "Valor inválido.";
        };
    }
}
