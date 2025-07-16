package view;

import dao.ServicoDAO;
import entities.Servico;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.time.format.DateTimeFormatter;


public class TelaVerificarRegistros extends JFrame {

    private JTable tabela;
    private DefaultTableModel tableModel;
    private JFrame telaPrincipal;

    public TelaVerificarRegistros(JFrame telaPrincipal) {
        super("Verificar Registros Existentes");
        this.telaPrincipal = telaPrincipal;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTitulo = new JLabel("Registros de Aparelhos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lblTitulo, BorderLayout.NORTH);


        String[] colunas = {"ID", "Nome", "Modelo", "Status", "Fim da Garantia", "Ação"};
        this.tableModel = new DefaultTableModel(colunas, 0);
        this.tabela = new JTable(tableModel);

        int colunaAcao = 5;
        tabela.getColumnModel().getColumn(colunaAcao).setCellEditor(new ButtonEditor(new JCheckBox(), this));

        tabela.setFont(new Font("Arial", Font.PLAIN, 14));
        tabela.setRowHeight(20);

        JScrollPane scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar ao Menu Principal");
        btnVoltar.addActionListener(e -> {
            this.telaPrincipal.setVisible(true);
            dispose();
        });
        panel.add(btnVoltar, BorderLayout.SOUTH);


        this.add(panel);

        carregarDadosNaTabela();
    }

    public void carregarDadosNaTabela() {
        this.tableModel.setRowCount(0);
        ServicoDAO servicoDAO = new ServicoDAO();
        List<Servico> servicos = servicoDAO.listarTodos();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Servico s : servicos) {
            String fimGarantia = "N/A";

            if (s.getDataFinalizacao() != null && s.getDiasGarantia() > 0) {
                fimGarantia = s.getDataFinalizacao().plusDays(s.getDiasGarantia()).format(formatter);
            }

            Object[] rowData = {
                    s.getId(),
                    s.getCliente().getNome(),
                    s.getAparelho().getModelo(),
                    s.getStatus(),
                    fimGarantia,
                    "Finalizar"
            };
            this.tableModel.addRow(rowData);
        }
    }
}