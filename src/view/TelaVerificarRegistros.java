package view;

import dao.ServicoDAO;
import entities.Servico;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaVerificarRegistros extends JFrame {

    private JTable tabela;
    private DefaultTableModel tableModel;

    public TelaVerificarRegistros() {
        super("Verificar Registros Existentes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTitulo = new JLabel("Registros de Aparelhos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lblTitulo, BorderLayout.NORTH);


        String[] colunas = {"ID", "Nome Cliente", "Modelo Aparelho", "Defeito", "Data Entrada", "Status"};
        this.tableModel = new DefaultTableModel(colunas, 0);
        this.tabela = new JTable(tableModel);

        tabela.setFont(new Font("Arial", Font.PLAIN, 14));
        tabela.setRowHeight(20);

        JScrollPane scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar ao Menu Principal");
        btnVoltar.addActionListener(e -> {

            dispose();
        });
        panel.add(btnVoltar, BorderLayout.SOUTH);


        this.add(panel);

        carregarDadosNaTabela();
    }

    private void carregarDadosNaTabela() {
        this.tableModel.setRowCount(0);

        ServicoDAO servicoDAO = new ServicoDAO();
        List<Servico> servicos = servicoDAO.listarTodos();

        for (Servico s : servicos) {
            Object[] rowData = {
                    s.getId(),
                    s.getCliente().getNome(),
                    s.getAparelho().getModelo(),
                    s.getAparelho().getDefeitoDeclarado(),
                    s.getDataEntrada().toString(),
                    s.getStatus()
            };
            this.tableModel.addRow(rowData);
        }
    }
}