import dao.AutorDAO;
import dao.LivroDAO;
import entity.Autor;
import entity.Livro;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Connectors
        AutorDAO dao = new AutorDAO();
        LivroDAO livrodao = new LivroDAO();
        Autor autor = new Autor();
        Livro livro = new Livro();

        //Inserir Autor
        autor.setnome("Kaue");
        autor.setnacionalidade("Chines");
        dao.deletar(autor);
        for (var a : dao.obterTodos()) {
            System.out.println(a);
        }

        //Atualizar Autor
        autor.setnome("Matheus");
        autor.setnacionalidade("Inglês");
        autor.setid(1);
        dao.atualizar(autor);
        for (var a : dao.obterTodos()) {
            System.out.println(a);
        };

        //Deletar Autor
        autor.setid(4);
        dao.deletar(autor);
        for (var a : dao.obterTodos()) {
            System.out.println(a);
        };

        //Listar Autor pelo Id Dele
        for (var a : dao.obterPeloId(2)){
            System.out.println(a);
        }

        //Inserir Livro
        livro.settitulo("A Arte da Guerra Sun Tzu");
        livro.setanoPublicacao(500);
        livro.setidAutor(1);
        livrodao.inserir(livro);
        for(var l: livrodao.obterTodos()){
            System.out.println(l);
        };

        //Atualizar Livro
        livro.settitulo("Arte da Guerra Sun Tzu");
        livro.setanoPublicacao(500);
        livro.setidAutor(1);
        livro.setid(9);
        livrodao.atualizar(livro);
        for(var l: livrodao.obterTodos()) {
            System.out.println(l);
        };

        //Deletar Livro
        livro.setid(10);
        livrodao.deletar(livro);
        for (var l : livrodao.obterTodos()) {
            System.out.println(l);
        };

        //Listar livro pelo Id Dele
        for (var l : livrodao.obterPeloId(2)){
            System.out.println(l);
        }

        //Listar todos os Livros por Autor
        for (var l : livrodao.obterPeloidAutor(2)) {
            System.out.println(l);
        };

    }
}