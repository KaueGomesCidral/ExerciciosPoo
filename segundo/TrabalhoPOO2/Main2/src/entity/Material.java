package entity;

public class Material {
    private int id;
    private String nome;
    private int quantidade;


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

    public int getquantidade() {
        return quantidade;
    }

    public void setquantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id = " + id +
                ", Nome = " + nome +
                ", Quantidade = " + quantidade + '\'' +
                '}';
    }
}