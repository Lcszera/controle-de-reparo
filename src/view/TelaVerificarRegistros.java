package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;    
import javax.swing.JScrollPane;  
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVerificarRegistros extends JFrame {


    private static final long serialVersionUID = 1L;

    public TelaVerificarRegistros() {
        super("Verificar Registros Existentes");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setSize(900, 600); 
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 255, 240)); 
        panel.setLayout(new BorderLayout()); 

        JLabel lblTitulo = new JLabel("Registros de Aparelhos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lblTitulo, BorderLayout.NORTH); 


        String[] columnNames = {"Nome Cliente", "CPF", "Telefone", "Modelo Aparelho", "Defeito", "Data Entrada"};

        Object[][] data = {
            {"João Silva", "123.456.789-00", "(11)98765-4321", "Samsung TV", "Não liga", "2024-06-01"},
            {"Maria Souza", "098.765.432-10", "(21)91234-5678", "iPhone X", "Tela quebrada", "2024-06-10"},
            {"Pedro Alves", "111.222.333-44", "(31)99876-1234", "Notebook Dell", "Superaquecendo", "2024-06-15"},
            {"Ana Lima", "555.666.777-88", "(41)98765-1234", "Console PS5", "Erro de leitura", "2024-06-20"}
        };
        
        JTable table = new JTable(data, columnNames); 
        table.setFont(new Font("Arial", Font.PLAIN, 14)); 
        table.setRowHeight(25); 

        JScrollPane scrollPane = new JScrollPane(table); 
        panel.add(scrollPane, BorderLayout.CENTER);


        JButton btnVoltar = new JButton("Voltar ao Menu Principal");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TelaPrincipal telaPrincipal = new TelaPrincipal(); 
                telaPrincipal.setVisible(true);
                dispose(); 
            }
        });
        panel.add(btnVoltar, BorderLayout.SOUTH);

        add(panel); 
    }
}