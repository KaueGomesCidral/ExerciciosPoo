package dao;

import entity.Autor;
import entity.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LivroDAO extends BaseDAO{

    public void inserir(Livro livro){
        String sql = """
                insert into Livro(Titulo, Ano_Publicacao, ID_Autor) values(?, ?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,livro.gettitulo());
            pre.setInt(2,livro.getanoPublicacao());
            pre.setInt(3,livro.getidAutor());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Livro livro){
        String sql = """
                update Livro set Titulo = ? , Ano_Publicacao = ? , ID_Autor = ? where ID_Livro = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1, livro.gettitulo());
            pre.setInt(2, livro.getanoPublicacao());
            pre.setInt(3,livro.getidAutor());
            pre.setInt(4, livro.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Livro livro){
        String sql = """
                delete from Livro where ID_Livro = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1, livro.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<Livro> obterTodos(){
        List<Livro> lista = new LinkedList<>();
        String sql = """
                select ID_Livro, Titulo, Ano_Publicacao, ID_Autor from Livro
                order by ID_Livro asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            while(rs.next()){
                Livro p = new Livro();
                p.setid(rs.getInt("ID_Livro"));
                p.settitulo(rs.getString("Titulo"));
                p.setanoPublicacao(rs.getInt("Ano_Publicacao"));
                p.setidAutor(rs.getInt("ID_Autor"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    public List<Livro> obterPeloId(int id){
        List<Livro> lista3 = new ArrayList<>();
        String sql = """
                select ID_Livro, Titulo, Ano_Publicacao, ID_Autor from Livro
                where ID_Autor = ?
                order by ID_Livro asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            if(rs.next()){
                Livro p = new Livro();
                p.setid(rs.getInt("ID_Livro"));
                p.settitulo(rs.getString("Titulo"));
                p.setanoPublicacao(rs.getInt("Ano_Publicacao"));
                p.setidAutor(rs.getInt("ID_Autor"));
                lista3.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } return lista3;
    }
    public List<Livro> obterPeloidAutor(int idAutor) {
        List<Livro> lista2 = new ArrayList<>();
        String sql = """
                select ID_Livro, Titulo, Ano_Publicacao, ID_Autor from Livro
                where ID_Autor = ?
                order by ID_Livro asc
                """;
        // try - with - resources
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, idAutor);
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            while (rs.next()) {
                Livro p = new Livro();
                p.setid(rs.getInt("ID_Livro"));
                p.settitulo(rs.getString("Titulo"));
                p.setanoPublicacao(rs.getInt("Ano_Publicacao"));
                p.setidAutor(rs.getInt("ID_Autor"));
                lista2.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return lista2;
    }
}