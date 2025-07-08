package view;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class BotoesArredondados extends JButton {

    private int arcWidth = 30; 
    private int arcHeight = 30; 

    public BotoesArredondados(String text) {
        super(text);
        setOpaque(false); 
        setContentAreaFilled(false); 
        setBorderPainted(false); 
    }

    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight));

        
        if (getBorder() != null) {
            g2.setColor(getForeground()); 
            g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight));
        }

        g2.dispose();
        super.paintComponent(g); 
    }

    
    @Override
    protected void paintBorder(Graphics g) {
       
    }
}