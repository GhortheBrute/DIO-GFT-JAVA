package Desafio.Dominio;

public class Curso extends Conteudo{

    private int cargaHoraria;

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + this.getTitulo() + '\'' +
                ", descricao='" + this.getDescricao() + '\'' +
                ", cargaHoraria=" + this.getCargaHoraria() +
                '}';
    }

    @Override
    public double calcularExp() {
        return XP_PADRAO * this.cargaHoraria;
    }
}
