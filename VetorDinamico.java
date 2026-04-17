public class VetorDinamico {
    private Processo[] dados;
    private int capacidade;
    private int ocupacao;
    private int capacidadeInicial;


    public VetorDinamico (int capacidadeInicial){
        this.capacidadeInicial = capacidadeInicial;
        dados = new Processo[capacidadeInicial];
        capacidade = capacidadeInicial;
        ocupacao = 0;
    }
    public int getCapacidade(){
        return capacidade;
    }
    public VetorDinamico(){
        this(10);
    }
    public boolean estaCheio(){
        return (capacidade==ocupacao);
    }
    public void adicionar(Processo p){
        if(estaCheio()){
            dobraVetor();
        }
        dados[ocupacao++] = p;
    }
    public Processo removerUltimo(){
        if(ocupacao == 0){
         return null;
        }

        Processo removido = dados[--ocupacao];
        dados[ocupacao] = null;

        ReduzVetor();

        return removido;
    }

    public void dobraVetor(){
        Processo[] temp = new Processo [capacidade * 2];
        for (int i = 0; i< ocupacao; i++){
            temp[i] = dados[i];
        }
        dados = temp;
        capacidade = capacidade*2;
    }
    public void ReduzVetor(){
        if (ocupacao < capacidade * 0.25 && (capacidade / 2) >= capacidadeInicial) {
            Processo[] temp = new Processo[capacidade / 2];
            for (int i = 0; i < ocupacao; i++) {
                temp[i] = dados[i];
            }
            dados = temp;
            capacidade = capacidade / 2;
        }
    }
    public int buscarPorProtocolo(int protocolo) {
        for (int i = 0; i < ocupacao; i++) {
            if (dados[i].getProtocolo() == protocolo) return i;
        }
        return -1;
    }

    public void listar() {
        for (int i = 0; i < ocupacao; i++) {
            System.out.println((i + 1) + " - " + dados[i]);
        }
    }
    
    
}
