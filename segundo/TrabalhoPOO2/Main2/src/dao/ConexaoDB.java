package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConexaoDB {
    // Design Patterns / Padrões de Projeto
    // Factory / Fabrica
    // Singleton / Único

    private static ConexaoDB instance;

    private ConexaoDB(){}

    public synchronized static ConexaoDB getInstance(){
        if(instance == null){
            instance = new ConexaoDB();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:Exercicio2.bd";
        Connection con = DriverManager.getConnection(url);
        System.out.println("Conectou!");
        return con;
    }

}