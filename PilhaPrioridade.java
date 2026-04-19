public class PilhaPrioridade {
    private PilhaProcesso baixa = new PilhaProcesso();
    private PilhaProcesso normal = new PilhaProcesso();
    private PilhaProcesso urgente = new PilhaProcesso();

    public void push(Processo p) {
        switch (p.getPrioridade()) {
            case 3 -> urgente.push(p);
            case 2 -> normal.push(p);
            default -> baixa.push(p);
        }
    }

    public Processo pop() {
        if (!urgente.estaVazia()) return urgente.pop();
        if (!normal.estaVazia()) return normal.pop();
        return baixa.pop();
    }

    public Processo peek() {
        if (!urgente.estaVazia()) return urgente.peek();
        if (!normal.estaVazia()) return normal.peek();
        return baixa.peek();
    }

    public int tamanho() {
        return urgente.tamanho() + normal.tamanho() + baixa.tamanho();
    }
    

    public void listar() {
        System.out.println("URGENTES:");
        urgente.imprimir();
        System.out.println("NORMAIS:");
        normal.imprimir();
        System.out.println("BAIXA:");
        baixa.imprimir();
    }
    
    public boolean estaVazia() {
        return urgente.estaVazia() && normal.estaVazia() && baixa.estaVazia();
    }
    public void limpar() {
        while (tamanho() > 0)
            pop();
    }
}
