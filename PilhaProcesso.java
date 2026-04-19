public class PilhaProcesso {
    private VetorDinamico vetor = new VetorDinamico();

    public void push(Processo p) {
        vetor.adicionar(p);
    }

    public Processo pop() {
        if (vetor.getOcupacao()==0)
            throw new PilhaVaziaException("Pilha vazia!");
        return vetor.removerUltimo();
    }

    public Processo peek() {
        if (vetor.getOcupacao()==0)
            throw new PilhaVaziaException("Pilha vazia!");
        return vetor.obter(vetor.getOcupacao() - 1);
    }

    public boolean estaVazia() {
        return vetor.getOcupacao()==0;
    }

    public int tamanho() {
        return vetor.getOcupacao();
    }

    public void imprimir() {
        for (int i = vetor.getOcupacao() - 1; i >= 0; i--) {
            System.out.println(vetor.obter(i));
        }
    }
}