package Aulas.JavaIO;

import Aulas.JavaIO.Persistence.FilePersistence;
import Aulas.JavaIO.Persistence.IOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new IOFilePersistence("user.csv");
        System.out.println(persistence.write("Jesus;jesus@email.com;01/12/1989"));
        System.out.println(persistence.write("Maria;maria@email.com;01/08/1912"));
        System.out.println(persistence.write("Marcos;marcos@email.com;01/10/2089"));

    }
}
