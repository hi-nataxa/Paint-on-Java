import algoritmo.FloodFillComFila;
import algoritmo.FloodFillComPilha;
import imagem.Animacao;
import imagem.ManipuladorImagem;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        String caminhoEntrada = "entrada.png";

        Color cor = new Color(128, 0, 128);
        int novaCor = cor.getRGB();
        int startX = 150, startY = 250;

        // pilha
        BufferedImage imgPilha = ManipuladorImagem.carregarImagem(caminhoEntrada);
        if (imgPilha != null) {
            Animacao animacaoPilha = new Animacao(imgPilha.getWidth(), imgPilha.getHeight());
            FloodFillComPilha.preencher(imgPilha, startX, startY, novaCor, animacaoPilha);
            System.out.println("Flood Fill com PILHA concluído.");

            ManipuladorImagem.salvarImagem(imgPilha, "saida_pilha.png");
        }

        // fila
        BufferedImage imgFila = ManipuladorImagem.carregarImagem(caminhoEntrada);
        if (imgFila != null) {
            Animacao animacaoFila = new Animacao(imgFila.getWidth(), imgFila.getHeight());
            FloodFillComFila.preencher(imgFila, startX, startY, novaCor, animacaoFila);
            System.out.println("Flood Fill com FILA concluído.");

            ManipuladorImagem.salvarImagem(imgFila, "saida_fila.png");
        }
    }
}
