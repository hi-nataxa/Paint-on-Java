package estruturas;

public class Pilha {
    private No topo;

    public Pilha() {
        this.topo = null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(int x, int y) {
        No novo = new No(x, y);
        novo.proximo = topo;
        topo = novo;
    }

    public No pop() {
        if (isEmpty()) return null;
        No temp = topo;
        topo = topo.proximo;
        return temp;
    }
}
