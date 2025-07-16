package view;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import dao.ServicoDAO;

public class Interface {

    private JFrame frame;
    private BotoesArredondados btnLogar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    Interface window = new Interface();

                    window.frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Interface() {
        initialize();

        System.out.println("1. INICIANDO: Tentando criar DAO e chamar criarTabela()...");
        dao.ServicoDAO dao = new dao.ServicoDAO();
        System.out.println("2. Objeto ServicoDAO foi criado.");
        dao.criarTabela();
        System.out.println("3. Método criarTabela() foi chamado com sucesso.");
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        BackgroundPanel panel = new BackgroundPanel("/eletronicawtec.png");

        frame.getContentPane().add(panel, BorderLayout.CENTER);

        btnLogar = new BotoesArredondados("Logar"); 
        btnLogar.setFont(new Font("Arial", Font.BOLD, 24));
        btnLogar.setForeground(Color.WHITE);
        btnLogar.setBackground(new Color(0, 0, 0));
        btnLogar.setBounds(662, 511, 112, 39);
        btnLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);

                frame.dispose();
            }
        });

        panel.add(btnLogar);
    }
}