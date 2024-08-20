package entity;

public class Projeto {
    private int id;
    private String nome;
    private String local;
    private int dataInicio;
    private int dataTermino;


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

    public String getlocal() {
        return local;
    }

    public void setlocal(String local) {
        this.local = local;
    }

    public int getdataInicio() {
        return dataInicio;
    }

    public void setdataInicio(int dataInicio) {this.dataInicio = dataInicio;}

    public int getdataTermino() {
        return dataTermino;
    }

    public void setdataTermino(int dataTermino) {this.dataTermino = dataTermino;}

    @Override
    public String toString() {
        return "Projeto{" +
                "id = " + id +
                ", Nome_Projeto = " + nome +
                ", Local = " + local +
                ", Data_Inicio = " + dataInicio +
                ", Data_Termino = " + dataTermino + '\'' +
                '}';
    }
}