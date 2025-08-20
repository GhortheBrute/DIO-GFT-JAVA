package Desafio;

import Desafio.Dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso("Curso Java", "Descrição Curso Java", 8);

        Curso curso2 = new Curso("Curso JS", "Descrição Curso JS", 4);

        Mentoria mentoria = new Mentoria("Mentoria de Java", "Descrição mentoria de java", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devJesus = new Dev();
        devJesus.setNome("Jesus");
        devJesus.inscreverBootcamp(bootcamp);
        devJesus.progredir();
        devJesus.progredir();
        System.out.println("Conteúdos inscritos: " + devJesus.getNome() + ": " + devJesus.getConteudosInscritos());
        System.out.println();
        System.out.println("Conteúdos Concluídos: " + devJesus.getNome() + ": " + devJesus.getConteudosConcluidos());
        System.out.println("EXP:" + devJesus.calcularTotalExp());

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("Conteúdos inscritos: " + devJoao.getNome() + ":" + devJoao.getConteudosInscritos());
        System.out.println();
        System.out.println("Conteúdos Concluídos: " + devJoao.getNome() + ":" + devJoao.getConteudosConcluidos());
        System.out.println("EXP:" + devJoao.calcularTotalExp());
    }
}
