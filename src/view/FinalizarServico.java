package view;

import dao.ServicoDAO;
import entities.Servico;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class FinalizarServico extends JDialog {

    private JTextField txtValorPeca;
    private JTextField txtMaoDeObra;
    private JTextField txtDiasGarantia;
    private JButton btnSalvar;

    private int idServico;
    private TelaVerificarRegistros telaPai;

    public FinalizarServico(TelaVerificarRegistros telaPai, int idServico) {
        super(telaPai, "Finalizar Serviço", true);
        this.telaPai = telaPai;
        this.idServico = idServico;

        setSize(350, 250);
        setLocationRelativeTo(telaPai);
        setLayout(new GridLayout(4, 2, 10, 10));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(new JLabel("Valor da Peça (R$):"));
        txtValorPeca = new JTextField();
        add(txtValorPeca);

        add(new JLabel("Valor Mão de Obra (R$):"));
        txtMaoDeObra = new JTextField();
        add(txtMaoDeObra);

        add(new JLabel("Garantia (dias):"));
        txtDiasGarantia = new JTextField();
        add(txtDiasGarantia);

        add(new JLabel());
        btnSalvar = new JButton("Salvar");
        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvarFinalizacao());
    }

    private void salvarFinalizacao() {
        try {
            double valorPeca = Double.parseDouble(txtValorPeca.getText());
            double valorMaoDeObra = Double.parseDouble(txtMaoDeObra.getText());
            int diasGarantia = Integer.parseInt(txtDiasGarantia.getText());

            Servico servicoFinalizado = new Servico();
            servicoFinalizado.setId(this.idServico);
            servicoFinalizado.setValorPeca(valorPeca);
            servicoFinalizado.setValorObra(valorMaoDeObra);
            servicoFinalizado.setDiasGarantia(diasGarantia);
            servicoFinalizado.setDataFinalizacao(LocalDate.now());

            ServicoDAO dao = new ServicoDAO();
            dao.finalizarServico(servicoFinalizado);

            dispose();


            telaPai.carregarDadosNaTabela();
            JOptionPane.showMessageDialog(telaPai, "Serviço finalizado com sucesso!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}