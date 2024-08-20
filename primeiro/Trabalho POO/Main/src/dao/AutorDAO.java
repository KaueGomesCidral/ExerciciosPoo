package dao;

import entity.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutorDAO extends BaseDAO{

    public AutorDAO() {
        super();
    }

    public void inserir(Autor autor){
        String sql = """
                insert into Autor(Nome, Nacionalidade) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,autor.getnome());
            pre.setString(2,autor.getnacionalidade());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Autor autor){
        String sql = """
                update Autor set Nome = ? , Nacionalidade = ? where ID_Autor = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,autor.getnome());
            pre.setString(2,autor.getnacionalidade());
            pre.setInt(3,autor.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Autor autor){
        String sql = """
                delete from Autor where ID_Autor = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,autor.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<Autor> obterTodos(){
        List<Autor> lista = new ArrayList<>();
        String sql = """
                select ID_Autor, Nome, Nacionalidade from Autor
                order by ID_Autor asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            while(rs.next()){
                Autor p = new Autor();
                p.setid(rs.getInt("ID_Autor"));
                p.setnome(rs.getString("Nome"));
                p.setnacionalidade(rs.getString("Nacionalidade"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<Autor> obterPeloId(int id){
        List<Autor> lista2 = new ArrayList<>();
        String sql = """
                select ID_Autor, Nome, Nacionalidade from Autor
                where ID_Autor = ?
                order by ID_Autor asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            if(rs.next()){
                Autor p = new Autor();
                p.setid(rs.getInt("ID_Autor"));
                p.setnome(rs.getString("Nome"));
                p.setnacionalidade(rs.getString("Nacionalidade"));
                lista2.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista2;
    }
}