package dao;

import entity.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialDAO extends BaseDAO{

    public void inserir(Material material){
        String sql = """
                insert into Material(Nome_Material, Quantidade) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,material.getnome());
            pre.setInt(2,material.getquantidade());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Material material){
        String sql = """
                update Material set Nome_Material = ? , Quantidade = ? where ID_Material = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,material.getnome());
            pre.setInt(2,material.getquantidade());
            pre.setInt(3,material.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Material material){
        String sql = """
                delete from Material where ID_Material = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,material.getid());
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<Material> obterTodos(){
        List<Material> lista = new ArrayList<>();
        String sql = """
                select ID_Material, Nome_Material, Quantidade from Material
                order by ID_Material asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            while(rs.next()){
                Material p = new Material();
                p.setid(rs.getInt("ID_Material"));
                p.setnome(rs.getString("Nome_Material"));
                p.setquantidade(rs.getInt("Quantidade"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Optional<Material> obterPeloId(int id){
        String sql = """
                select ID_Material, Nome_Material, Quantidade from Material
                where ID_Material = ?
                order by ID_Material asc
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            // Existe o proximo?
            if(rs.next()){
                Material p = new Material();
                p.setid(rs.getInt("ID_Material"));
                p.setnome(rs.getString("Nome_Material"));
                p.setquantidade(rs.getInt("Quantidade"));
                return Optional.of(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}