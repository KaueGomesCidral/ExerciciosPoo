package dao;

import entity.Projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjetoDAO extends BaseDAO{

    public void inserir(Projeto projeto){
        String sql = """
                insert into Projeto(Nome_Projeto, Local, Data_Inicio, Data_Termino) values(?, ?, ?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,projeto.getnome());
            pre.setString(2,projeto.getlocal());
            pre.setInt(3,projeto.getdataInicio());
            pre.setInt(4,projeto.getdataTermino());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Projeto projeto){
        String sql = """
                update Projeto set Nome_Projeto = ? , Local = ? , Data_Inicio = ? ,  Data_Termino = ? where ID_Projeto = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,projeto.getnome());
            pre.setString(2,projeto.getlocal());
            pre.setInt(3,projeto.getdataInicio());
            pre.setInt(4,projeto.getdataTermino());
            pre.setInt(5,projeto.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Projeto projeto){
        String sql = """
                delete from Projeto where ID_Projeto = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,projeto.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<Projeto> obterTodos(){
        List<Projeto> lista = new ArrayList<>();
        String sql = """
                select ID_Projeto, Nome_Projeto, Local, Data_Inicio, Data_Termino from Projeto
                order by ID_Projeto asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            while(rs.next()){
                Projeto p = new Projeto();
                p.setid(rs.getInt("ID_Projeto"));
                p.setnome(rs.getString("Nome_Projeto"));
                p.setlocal(rs.getString("Local"));
                p.setdataInicio(rs.getInt("Data_Inicio"));
                p.setdataTermino(rs.getInt("Data_Termino"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Optional<Projeto> obterPeloId(int id){
        String sql = """
                select ID_Projeto, Nome_Projeto, Local, Data_Inicio, Data_Termino from Projeto
                where ID_Projeto = ?
                order by ID_Projeto asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            if(rs.next()){
                Projeto p = new Projeto();
                p.setid(rs.getInt("ID_Projeto"));
                p.setnome(rs.getString("Nome_Projeto"));
                p.setlocal(rs.getString("Local"));
                p.setdataInicio(rs.getInt("Data_Inicio"));
                p.setdataTermino(rs.getInt("Data_Termino"));
                return Optional.of(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}