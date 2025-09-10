package imagem;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ManipuladorImagem {

    public static BufferedImage carregarImagem(String caminho) {
        try {
            BufferedImage img = ImageIO.read(new File(caminho));
            if (img == null) return null;
            if (img.getType() != BufferedImage.TYPE_INT_ARGB) {
                BufferedImage copy = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = copy.createGraphics();
                g.drawImage(img, 0, 0, null);
                g.dispose();
                return copy;
            }
            return img;
        } catch (Exception e) {
            System.out.println("Erro ao carregar imagem: " + e.getMessage());
            return null;
        }
    }

    public static void salvarImagem(BufferedImage imagem, String caminho) {
        try {
            ImageIO.write(imagem, "png", new File(caminho));
        } catch (Exception e) {
            System.out.println("Erro ao salvar imagem: " + e.getMessage());
        }
    }

    public static void pintarPixel(BufferedImage img, int x, int y, int cor) {
        img.setRGB(x, y, cor);
    }

    public static int obterCor(BufferedImage img, int x, int y) {
        return img.getRGB(x, y);
    }
}
