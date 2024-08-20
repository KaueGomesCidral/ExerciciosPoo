package entity;

public class Autor {
    private int id;
    private String nome;
    private String nacionalidade;


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

    public String getnacionalidade() {
        return nacionalidade;
    }

    public void setnacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "hash = " +hashCode()+
                "id = " + id +
                ", Nome = " + nome +
                ", Nacionalidade = " + nacionalidade + '\'' +
                '}';
    }
}
