package view;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    private BotoesArredondados btnAdicionar;
    private BotoesArredondados btnVerificar;
    private BotoesArredondados btnSair;

    public TelaPrincipal() {
        super("Sistema de Gerenciamento de Eletrônica - Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        BackgroundPanel panel = new BackgroundPanel("/circuito.png");
        panel.setLayout(null);

        Font buttonFont = new Font("Arial", Font.BOLD, 22);
        Color commonBgColor = Color.BLACK;
        Color commonFgColor = Color.WHITE;
        Color borderColor = Color.LIGHT_GRAY;
        int borderWidth = 2;

        btnAdicionar = new BotoesArredondados("Adicionar Registros");
        btnAdicionar.setFont(buttonFont);
        btnAdicionar.setForeground(commonFgColor);
        btnAdicionar.setBackground(commonBgColor);
        btnAdicionar.setBounds(350, 150, 300, 60);
        btnAdicionar.setFocusPainted(false);
        btnAdicionar.setBorder(null);
        panel.add(btnAdicionar);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                TelaAdicionarRegistros telaAdicionar = new TelaAdicionarRegistros(TelaPrincipal.this);
                telaAdicionar.setVisible(true);
                TelaPrincipal.this.setVisible(false);

            }
        });

        btnVerificar = new BotoesArredondados("Verificar Registros");
        btnVerificar.setFont(buttonFont);
        btnVerificar.setForeground(commonFgColor);
        btnVerificar.setBackground(commonBgColor);
        btnVerificar.setBounds(350, 240, 300, 60);
        btnVerificar.setFocusPainted(false);
        btnVerificar.setBorder(null);
        panel.add(btnVerificar);

        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaVerificarRegistros telaVerificar = new TelaVerificarRegistros();
                telaVerificar.setVisible(true);
                dispose();
            }
        });

        btnSair = new BotoesArredondados("Sair");
        btnSair.setFont(buttonFont);
        btnSair.setForeground(commonFgColor);
        btnSair.setBackground(new Color(220, 20, 60));
        btnSair.setBounds(350, 330, 300, 60);
        btnSair.setFocusPainted(false);
        btnSair.setBorder(null);
        panel.add(btnSair);

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel);
    }
}