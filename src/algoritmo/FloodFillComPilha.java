package algoritmo;

import estruturas.Pilha;
import estruturas.No;
import imagem.ManipuladorImagem;

import java.awt.image.BufferedImage;

public class FloodFillComPilha {

    public static void preencher(BufferedImage img, int x, int y, int novaCor) {
        int corFundo = ManipuladorImagem.obterCor(img, x, y);
        if (corFundo == novaCor) return;

        Pilha pilha = new Pilha();
        pilha.push(x, y);

        int largura = img.getWidth();
        int altura = img.getHeight();
        int contador = 0;

        while (!pilha.isEmpty()) {
            No pixel = pilha.pop();
            int px = pixel.x, py = pixel.y;

            if (px < 0 || px >= largura || py < 0 || py >= altura) continue;
            if (ManipuladorImagem.obterCor(img, px, py) != corFundo) continue;

            ManipuladorImagem.pintarPixel(img, px, py, novaCor);

            // salvar frame a cada x pixels pintados
            if (++contador % 5000 == 0) {
                ManipuladorImagem.salvarImagem(img, "saida_pilha_" + contador + ".png");
            }

            pilha.push(px + 1, py);
            pilha.push(px - 1, py);
            pilha.push(px, py + 1);
            pilha.push(px, py - 1);
        }

        ManipuladorImagem.salvarImagem(img, "saida_pilha_final.png");
    }
}
