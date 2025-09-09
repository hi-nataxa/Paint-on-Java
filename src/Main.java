import algoritmo.FloodFillComFila;
import algoritmo.FloodFillComPilha;
import imagem.ManipuladorImagem;

import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        // caminho da imagem de entrada
        String caminhoEntrada = "entrada.png";

        // cor escolhida para preencher (vermelho)
        int novaCor = 0xFFFF0000; // ARGB

        // coordenada inicial (ponto de clique)
        int startX = 1;
        int startY = 15;

        // ---------- Usando Pilha ----------
        BufferedImage imgPilha = ManipuladorImagem.carregarImagem(caminhoEntrada);
        if (imgPilha != null) {
            FloodFillComPilha.preencher(imgPilha, startX, startY, novaCor);
            System.out.println("Flood Fill com PILHA concluído.");
        }

        // ---------- Usando Fila ----------
        BufferedImage imgFila = ManipuladorImagem.carregarImagem(caminhoEntrada);
        if (imgFila != null) {
            FloodFillComFila.preencher(imgFila, startX, startY, novaCor);
            System.out.println("Flood Fill com FILA concluído.");
        }
    }
}
