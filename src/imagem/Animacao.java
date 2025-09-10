package imagem;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Animacao{
    private JFrame frame;
    private JLabel label;

    public Animacao(int largura, int altura) {
        frame = new JFrame("Flood Fill - Animação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(largura, altura);
        frame.setLocationRelativeTo(null);
        label = new JLabel();
        frame.add(label);
        frame.setVisible(true);
    }

    public void atualizar(BufferedImage img) {
        label.setIcon(new ImageIcon(img));
        frame.repaint();
    }
}
