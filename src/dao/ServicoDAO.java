package dao;

import entities.Servico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import entities.Aparelho;
import entities.Cliente;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        public List<Servico> listarTodos() {
            String sql = "SELECT * FROM servicos";
            List<Servico> servicos = new ArrayList<>();

            try (Connection conn = ConnectionFactory.createConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Cliente cliente = new Cliente();
                    cliente.setNome(rs.getString("cliente_nome"));

                    Aparelho aparelho = new Aparelho();
                    aparelho.setModelo(rs.getString("aparelho_modelo"));
                    aparelho.setDefeitoDeclarado(rs.getString("defeito"));

                    Servico servico = new Servico();
                    servico.setId(rs.getInt("id"));
                    servico.setCliente(cliente);
                    servico.setAparelho(aparelho);

                    Date dataDoBanco = rs.getDate("data_entrada");
                    if (dataDoBanco != null) {
                        servico.setDataEntrada(dataDoBanco.toLocalDate());
                    }

                    servico.setStatus(rs.getString("status"));

                    servicos.add(servico);
                }
            } catch (SQLException e) {
                System.err.println("Erro ao listar os serviços: " + e.getMessage());
                e.printStackTrace();
            }

            return servicos;
        }

}