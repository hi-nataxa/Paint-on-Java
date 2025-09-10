package imagem;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ManipuladorImagem {

    public static BufferedImage carregarImagem(String caminho) {
        try {
            return ImageIO.read(new File(caminho));
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
