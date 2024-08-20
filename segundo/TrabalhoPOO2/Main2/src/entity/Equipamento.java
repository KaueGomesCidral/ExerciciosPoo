package entity;

public class Equipamento {
    private int id;
    private String nome;
    private String tipo;


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

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "id = " + id +
                ", Nome = " + nome +
                ", Tipo = " + tipo + '\'' +
                '}';
    }
}