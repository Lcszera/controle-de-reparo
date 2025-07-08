package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

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

    public TelaAdicionarRegistros() {
        super("Adicionar Novo Registro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 700);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setLayout(new BorderLayout(10, 10));

        JLabel lblTitulo = new JLabel("Cadastro de Aparelhos Eletrônicos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
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

        // Linha 1: Nome
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Nome:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 3;
        txtNome = new JTextField(textFieldCols);
        txtNome.setFont(fieldFont);
        formPanel.add(txtNome, gbc);
        gbc.gridwidth = 1;

        // Linha 2: CPF
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("CPF:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        MaskFormatter cpfMask = null;
        try {
            cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtCpf = new JFormattedTextField(cpfMask);
        txtCpf.setFont(fieldFont);
        formPanel.add(txtCpf, gbc);

        // Linha 3: Endereço
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Endereço:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 3;
        txtEndereco = new JTextField(textFieldCols);
        txtEndereco.setFont(fieldFont);
        formPanel.add(txtEndereco, gbc);
        gbc.gridwidth = 1;

        // Linha 4: Telefone
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Telefone:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        MaskFormatter telefoneMask = null;
        try {
            telefoneMask = new MaskFormatter("(##)#####-####");
            telefoneMask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtTelefone = new JFormattedTextField(telefoneMask);
        txtTelefone.setFont(fieldFont);
        formPanel.add(txtTelefone, gbc);

        // Linha 5: Modelo do Aparelho
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Modelo do Aparelho:", labelFont), gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 3;
        txtModeloAparelho = new JTextField(textFieldCols);
        txtModeloAparelho.setFont(fieldFont);
        formPanel.add(txtModeloAparelho, gbc);
        gbc.gridwidth = 1;

       
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST; 
        gbc.insets = new Insets(8, 5, 8, 5); 
        formPanel.add(createLabel("Defeito:", labelFont), gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST; 
        gbc.gridwidth = 3; 
        gbc.weightx = 1.0;
        gbc.weighty = 0.3; 
        txtDefeito = new JTextArea(3, textFieldCols); 
        txtDefeito.setFont(fieldFont);
        txtDefeito.setLineWrap(true);
        txtDefeito.setWrapStyleWord(true);
        JScrollPane scrollDefeito = new JScrollPane(txtDefeito);
        formPanel.add(scrollDefeito, gbc);
        
        
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(8, 5, 8, 5);

        gbc.gridx = 0; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Data de Entrada (DD/MM/AAAA):", labelFont), gbc);
        
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        txtDataEntrada = new JTextField(10);
        txtDataEntrada.setFont(fieldFont);
        formPanel.add(txtDataEntrada, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 230, 230));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));

        int buttonWidth = 200;
        int buttonHeight = 40;

        btnSalvar = new BotoesArredondados("Salvar Registro");
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 16));
        btnSalvar.setBackground(new Color(34, 139, 34));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFocusPainted(false);
        btnSalvar.setBorder(null);
        btnSalvar.setArcWidth(20);
        btnSalvar.setArcHeight(20);
        btnSalvar.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        buttonPanel.add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String cpf = txtCpf.getText();
                String endereco = txtEndereco.getText();
                String telefone = txtTelefone.getText();
                String modeloAparelho = txtModeloAparelho.getText();
                String defeito = txtDefeito.getText();
                String dataEntrada = txtDataEntrada.getText();

                JOptionPane.showMessageDialog(TelaAdicionarRegistros.this,
                    "Dados Coletados:\n" +
                    "Nome: " + nome + "\n" +
                    "CPF: " + cpf + "\n" +
                    "Endereço: " + endereco + "\n" +
                    "Telefone: " + telefone + "\n" +
                    "Modelo: " + modeloAparelho + "\n" +
                    "Defeito: " + defeito + "\n" +
                    "Data Entrada: " + dataEntrada,
                    "Registro Salvo (Simulado)", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnVoltar = new BotoesArredondados("Voltar ao Menu Principal");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
        btnVoltar.setBackground(Color.BLACK);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBorder(null);
        btnVoltar.setArcWidth(20);
        btnVoltar.setArcHeight(20);
        btnVoltar.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        buttonPanel.add(btnVoltar);

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
                dispose();
            }
        });

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(Color.BLACK);
        return label;
    }
}