package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DB_URL = "jdbc:sqlite:repaircontrol.db";

    public static Connection createConnection() {
        try {

            System.out.println("--- [ConnectionFactory] Tentando se conectar ao banco de dados...");

            Connection conn = DriverManager.getConnection(DB_URL);


            System.out.println("--- [ConnectionFactory] Conexão OBTIDA com sucesso!");

            return conn;

        } catch (SQLException e) {
            System.out.println("--- [ConnectionFactory] FALHA AO OBTER CONEXÃO!");
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados.", e);
        }
    }
}