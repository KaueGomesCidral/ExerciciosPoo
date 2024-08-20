package entity;

public class Engenheiro {
    private int id;
    private String nome;
    private String especialidade;


    public int getid() {
        return id;
    }

    public void setid(int id) {this.id = id;}

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getespecialidade() {
        return especialidade;
    }

    public void setespecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Engenheiro{" +
                "id = " + id +
                ", Nome = " + nome +
                ", Especialidade = " + especialidade + '\'' +
                '}';
    }
}