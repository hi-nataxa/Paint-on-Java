package algoritmo;

import estruturas.Fila;
import estruturas.No;
import imagem.Animacao;
import imagem.ManipuladorImagem;

import java.awt.image.BufferedImage;

public class FloodFillComFila {

    public static void preencher(BufferedImage img, int x, int y, int novaCor, Animacao animacao) {
        int corFundo = ManipuladorImagem.obterCor(img, x, y);
        if (corFundo == novaCor) return;

        Fila fila = new Fila();
        fila.enqueue(x, y);

        int largura = img.getWidth();
        int altura = img.getHeight();
        int contador = 0;

        while (!fila.isEmpty()) {
            No pixel = fila.dequeue();
            int px = pixel.x, py = pixel.y;

            if (px < 0 || px >= largura || py < 0 || py >= altura) continue;
            if (ManipuladorImagem.obterCor(img, px, py) != corFundo) continue;

            ManipuladorImagem.pintarPixel(img, px, py, novaCor);

            // salvar frame a cada 500 pixels pintados
            if (++contador % 300 == 0) {
                ManipuladorImagem.salvarImagem(img, "saida_fila_" + contador + ".png");
                animacao.atualizar(img);
                try { Thread.sleep(5); } catch (InterruptedException e) {}

            }

            fila.enqueue(px + 1, py);
            fila.enqueue(px - 1, py);
            fila.enqueue(px, py + 1);
            fila.enqueue(px, py - 1);
        }

        ManipuladorImagem.salvarImagem(img, "saida_fila_final.png");
        animacao.atualizar(img);
    }
}
