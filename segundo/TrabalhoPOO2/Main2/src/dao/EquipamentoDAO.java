package dao;

import entity.Equipamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EquipamentoDAO extends BaseDAO{

    public void inserir(Equipamento equipamento){
        String sql = """
                insert into Equipamento(Nome_Equipamento, Tipo) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,equipamento.getnome());
            pre.setString(2,equipamento.gettipo());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Equipamento equipamento){
        String sql = """
                update Equipamento set Nome_Equipamento = ? , Tipo = ? where ID_Equipamento = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,equipamento.getnome());
            pre.setString(2,equipamento.gettipo());
            pre.setInt(3,equipamento.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Equipamento equipamento){
        String sql = """
                delete from Equipamento where ID_Equipamento = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,equipamento.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<Equipamento> obterTodos(){
        List<Equipamento> lista = new ArrayList<>();
        String sql = """
                select ID_Equipamento, Nome_Equipamento, Tipo from Equipamento
                order by ID_Equipamento asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            while(rs.next()){
                Equipamento p = new Equipamento();
                p.setid(rs.getInt("ID_Equipamento"));
                p.setnome(rs.getString("Nome_Equipamento"));
                p.settipo(rs.getString("Tipo"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Optional<Equipamento> obterPeloId(int id){
        String sql = """
                select ID_Equipamento, Nome_Equipamento, Tipo from Equipamento
                where ID_Equipamento = ?
                order by ID_Equipamento asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            if(rs.next()){
                Equipamento p = new Equipamento();
                p.setid(rs.getInt("ID_Equipamento"));
                p.setnome(rs.getString("Nome_Equipamento"));
                p.settipo(rs.getString("Tipo"));
                return Optional.of(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}