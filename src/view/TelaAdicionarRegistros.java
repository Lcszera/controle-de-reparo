package view;

import dao.ServicoDAO;
import entities.Aparelho;
import entities.Cliente;
import entities.Servico;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TelaAdicionarRegistros extends JFrame {


    private JTextField txtNome;
    private JFormattedTextField txtCpf;
    private JTextField txtEndereco;
    private JFormattedTextField txtTelefone;
    private JTextField txtModeloAparelho;
    private JTextArea txtDefeito;
    private JTextField txtDataEntrada;
    private BotoesArredondados btnSalvar;
    private BotoesArredondados btnVoltar;


    private JFrame telaPrincipal;


    public TelaAdicionarRegistros(JFrame telaPrincipal) {
        super("Adicionar Novo Registro");
        this.telaPrincipal = telaPrincipal;


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 700);
        setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JLabel lblTitulo = new JLabel("Cadastro de Aparelhos Eletrônicos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(lblTitulo, BorderLayout.NORTH);


        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(230, 230, 230));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Font labelFont = new Font("Arial", Font.PLAIN, 15);
        Font fieldFont = new Font("Arial", Font.PLAIN, 15);
        int textFieldCols = 25;


        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Nome:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST; gbc.gridwidth = 3;
        txtNome = new JTextField(textFieldCols);
        txtNome.setFont(fieldFont);
        formPanel.add(txtNome, gbc);
        gbc.gridwidth = 1;


        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("CPF:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.anchor = GridBagConstraints.WEST;
        txtCpf = new JFormattedTextField(createFormatter("###.###.###-##"));
        txtCpf.setFont(fieldFont);
        formPanel.add(txtCpf, gbc);


        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Endereço:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.anchor = GridBagConstraints.WEST; gbc.gridwidth = 3;
        txtEndereco = new JTextField(textFieldCols);
        txtEndereco.setFont(fieldFont);
        formPanel.add(txtEndereco, gbc);
        gbc.gridwidth = 1;


        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Telefone:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.WEST;
        txtTelefone = new JFormattedTextField(createFormatter("(##)#####-####"));
        txtTelefone.setFont(fieldFont);
        formPanel.add(txtTelefone, gbc);


        gbc.gridx = 0; gbc.gridy = 4; gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Modelo do Aparelho:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 4; gbc.anchor = GridBagConstraints.WEST; gbc.gridwidth = 3;
        txtModeloAparelho = new JTextField(textFieldCols);
        txtModeloAparelho.setFont(fieldFont);
        formPanel.add(txtModeloAparelho, gbc);
        gbc.gridwidth = 1;


        gbc.gridx = 0; gbc.gridy = 5; gbc.anchor = GridBagConstraints.NORTHEAST;
        formPanel.add(createLabel("Defeito:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 5; gbc.anchor = GridBagConstraints.WEST; gbc.gridwidth = 3; gbc.weightx = 1.0; gbc.weighty = 0.3; gbc.fill = GridBagConstraints.BOTH;
        txtDefeito = new JTextArea(3, textFieldCols);
        txtDefeito.setFont(fieldFont);
        txtDefeito.setLineWrap(true);
        txtDefeito.setWrapStyleWord(true);
        JScrollPane scrollDefeito = new JScrollPane(txtDefeito);
        formPanel.add(scrollDefeito, gbc);
        gbc.gridwidth = 1; gbc.weightx = 0; gbc.weighty = 0; gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0; gbc.gridy = 6; gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Data de Entrada (DD/MM/AAAA):", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 6; gbc.anchor = GridBagConstraints.WEST;
        txtDataEntrada = new JTextField(10);
        txtDataEntrada.setFont(fieldFont);
        formPanel.add(txtDataEntrada, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 15));
        buttonPanel.setBackground(new Color(230, 230, 230));
        btnSalvar = createButton("Salvar Registro", new Color(34, 139, 34));
        btnVoltar = createButton("Voltar ao Menu", Color.BLACK);
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnVoltar);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> salvarRegistro());


        btnVoltar.addActionListener(e -> {


            telaPrincipal.setVisible(true);

            dispose();
        });

        add(mainPanel);
    }

    private void salvarRegistro() {
        try {

            String nomeCliente = txtNome.getText();
            String cpf = txtCpf.getText();
            String telefone = txtTelefone.getText();
            String modeloAparelho = txtModeloAparelho.getText();
            String defeito = txtDefeito.getText();
            String dataEntradaTexto = txtDataEntrada.getText();

            if (nomeCliente.trim().isEmpty() || modeloAparelho.trim().isEmpty() || dataEntradaTexto.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha Nome, Modelo e Data.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataEntrada = LocalDate.parse(dataEntradaTexto, formatter);


            Cliente cliente = new Cliente(nomeCliente, telefone, cpf);
            Aparelho aparelho = new Aparelho(modeloAparelho, defeito);
            Servico servico = new Servico();
            servico.setCliente(cliente);
            servico.setAparelho(aparelho);
            servico.setDataEntrada(dataEntrada);
            servico.setStatus("Pendente");


            ServicoDAO servicoDAO = new ServicoDAO();
            servicoDAO.salvar(servico);


            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use DD/MM/AAAA.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao salvar: " + ex.getMessage(), "Erro Inesperado", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }


    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(Color.BLACK);
        return label;
    }

    private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
            formatter.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }

    private BotoesArredondados createButton(String text, Color background) {
        BotoesArredondados button = new BotoesArredondados(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(background);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(null);
        button.setPreferredSize(new Dimension(200, 40));
        return button;
    }
}