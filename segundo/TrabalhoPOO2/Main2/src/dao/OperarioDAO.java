package dao;

import entity.Operario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OperarioDAO extends BaseDAO{

    public void inserir(Operario operario){
        String sql = """
                insert into Operario(Nome_Operario, Funcao) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,operario.getnome());
            pre.setString(2,operario.getfuncao());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Operario operario){
        String sql = """
                update Operario set Nome_Operario = ? , Funcao = ? where ID_Operario = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,operario.getnome());
            pre.setString(2,operario.getfuncao());
            pre.setInt(3,operario.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Operario operario){
        String sql = """
                delete from Operario where ID_Operario = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,operario.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<Operario> obterTodos(){
        List<Operario> lista = new ArrayList<>();
        String sql = """
                select ID_Operario, Nome_Operario, Funcao from Operario
                order by ID_Operario asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            while(rs.next()){
                Operario p = new Operario();
                p.setid(rs.getInt("ID_Operario"));
                p.setnome(rs.getString("Nome_Operario"));
                p.setfuncao(rs.getString("Funcao"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Optional<Operario> obterPeloId(int id){
        String sql = """
                select ID_Operario, Nome_Operario, Funcao from Operario
                where ID_Operario = ?
                order by ID_Operario asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            if(rs.next()){
                Operario p = new Operario();
                p.setid(rs.getInt("ID_Operario"));
                p.setnome(rs.getString("Nome_Operario"));
                p.setfuncao(rs.getString("Funcao"));
                return Optional.of(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}