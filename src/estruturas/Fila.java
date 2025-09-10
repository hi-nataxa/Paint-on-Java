package estruturas;

public class Fila {
    private No inicio, fim;

    public Fila() {
        this.inicio = this.fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(int x, int y) {
        No novo = new No(x, y);
        if (isEmpty()) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    public No dequeue() {
        if (isEmpty()) return null;
        No temp = inicio;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return temp;
    }
}
