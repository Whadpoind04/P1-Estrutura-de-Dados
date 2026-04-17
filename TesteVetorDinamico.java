public class TesteVetorDinamico {
    public static void main(String[] args) {
        VetorDinamico vetor = new VetorDinamico(4);

        
        for (int i = 1; i <= 12; i++) {
            Processo p = new Processo("Cliente 1", "Suporte", 2);

            vetor.adicionar(p);

            System.out.println( "processo " + p.getProtocolo() + " | Ocupação: " + i + " | Capacidade: " + vetor.getCapacidade());
        }

        System.out.println("\nLISTA ATUAL");
        vetor.listar();

        System.out.println("\nREMOÇÃO");

        for (int i = 1; i <= 10; i++) {
            Processo removido = vetor.removerUltimo();

            System.out.println("Removido processo " + removido.getProtocolo()+ " | Capacidade atual: " + vetor.getCapacidade());
        }

        System.out.println("\nLISTA FINAL");
        vetor.listar();
    }
}