package entity;

public class Operario {
    private int id;
    private String nome;
    private String funcao;


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

    public String getfuncao() {
        return funcao;
    }

    public void setfuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Operario{" +
                "id = " + id +
                ", Nome = " + nome +
                ", Função = " + funcao + '\'' +
                '}';
    }
}