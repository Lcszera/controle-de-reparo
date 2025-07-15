package dao;

import entities.Servico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicoDAO {

    public void criarTabela() {

        String sql = "CREATE TABLE IF NOT EXISTS servicos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "cliente_nome TEXT NOT NULL,"
                + "aparelho_modelo TEXT NOT NULL,"
                + "defeito TEXT,"
                + "peca_usada TEXT,"
                + "valor_peca REAL,"
                + "valor_obra REAL,"
                + "valor_total_cobrado REAL,"
                + "dias_garantia INTEGER,"
                + "data_entrada DATE,"
                + "data_finalizacao DATE,"
                + "status TEXT"
                + ");";

        try (Connection conn = ConnectionFactory.createConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela de serviços: " + e.getMessage());
        }
    }


    public void salvar(Servico servico) {

        String sql = "INSERT INTO servicos(cliente_nome, aparelho_modelo, defeito, data_entrada, status) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setString(1, servico.getCliente().getNome());
            pstmt.setString(2, servico.getAparelho().getModelo());
            pstmt.setString(3, servico.getAparelho().getDefeitoDeclarado());
            pstmt.setDate(4, Date.valueOf(servico.getDataEntrada()));
            pstmt.setString(5, "Pendente");

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar serviço: " + e.getMessage());
        }
    }
}