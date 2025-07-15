package view; 

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL; 

public class BackgroundPanel extends JPanel {

    private Image backgroundImage;


    public BackgroundPanel(String imagePath) {

        try {
            URL imageUrl = getClass().getResource(imagePath);
            if (imageUrl == null) {

                throw new IllegalArgumentException("Imagem de fundo não encontrada: " + imagePath);
            }
            ImageIcon icon = new ImageIcon(imageUrl);
            backgroundImage = icon.getImage();
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem de fundo: " + e.getMessage()); // só pra testar

            setBackground(new Color(65, 105, 225));
        }
        setLayout(null); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 


        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}