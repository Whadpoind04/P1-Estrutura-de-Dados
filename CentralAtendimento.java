public class CentralAtendimento {
    private PilhaPrioridade pendentes;
    private PilhaPrioridade historico;
    
    public CentralAtendimento(){
        pendentes = new PilhaPrioridade();
        historico = new PilhaPrioridade();
    }

    public void abrirProcesso(Processo processo){
        pendentes.push(processo);
        historico.limpar();
        //Limpar
    }

    public void atenderProximo(){
        if(pendentes.estaVazia()){
            System.out.println("Pilha vazia\n");
        }
        Processo processo = pendentes.peek();
        pendentes.pop();
        historico.push(processo);
    }

    public void desfazeUltimoAtendimento(){
        if (historico.estaVazia()) {
            System.out.println("Pilha vazia\n");
            return;
        }
        Processo processo = historico.peek();
        historico.pop();
        pendentes.push(processo);
    }
    public void listarPendentes(){
        pendentes.listar();

    }
    public void listarHistorico(){
        historico.listar();
    }
}
