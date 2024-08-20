package entity;

public class Livro {
    private int id;
    private String titulo;
    private int anoPublicacao;
    private int idAutor;


    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String gettitulo() {
        return titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getanoPublicacao() {
        return anoPublicacao;
    }

    public void setanoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getidAutor() {
        return idAutor;
    }

    public void setidAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id = " + id +
                ", Titulo = " + titulo +
                ", Ano_Publicação = " + anoPublicacao +
                ", ID_Autor = " + idAutor + '\'' +
                '}';
    }
}