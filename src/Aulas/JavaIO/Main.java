package Aulas.JavaIO;

import Aulas.JavaIO.Persistence.FilePersistence;
import Aulas.JavaIO.Persistence.IOFilePersistence;
import Aulas.JavaIO.Persistence.NIOFilePersistance;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new NIOFilePersistance("user.csv");


    }
}
