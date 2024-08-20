package dao;

import entity.Engenheiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EngenheiroDAO extends BaseDAO{

    public void inserir(Engenheiro engenheiro){
        String sql = """
                insert into Engenheiro(Nome_Engenheiro, Especialidade) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,engenheiro.getnome());
            pre.setString(2,engenheiro.getespecialidade());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Engenheiro engenheiro){
        String sql = """
                update Engenheiro set Nome_Engenheiro = ? , Especialidade = ? where ID_Engenheiro = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,engenheiro.getnome());
            pre.setString(2,engenheiro.getespecialidade());
            pre.setInt(3,engenheiro.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Engenheiro engenheiro){
        String sql = """
                delete from Engenheiro where ID_Engenheiro = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,engenheiro.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<Engenheiro> obterTodos(){
        List<Engenheiro> lista = new ArrayList<>();
        String sql = """
                select ID_Engenheiro, Nome_Engenheiro, Especialidade from Engenheiro
                order by ID_Engenheiro asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            while(rs.next()){
                Engenheiro p = new Engenheiro();
                p.setid(rs.getInt("ID_Engenheiro"));
                p.setnome(rs.getString("Nome_Engenheiro"));
                p.setespecialidade(rs.getString("Especialidade"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Optional<Engenheiro> obterPeloId(int id){
        String sql = """
                select ID_Engenheiro, Nome_Engenheiro, Especialidade from Engenheiro
                where ID_Engenheiro = ?
                order by ID_Engenheiro asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            if(rs.next()){
                Engenheiro p = new Engenheiro();
                p.setid(rs.getInt("ID_Engenheiro"));
                p.setnome(rs.getString("Nome_Engenheiro"));
                p.setespecialidade(rs.getString("Especialidade"));
                return Optional.of(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}