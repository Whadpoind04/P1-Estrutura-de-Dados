public class TesteCentral {

    public static void main(String[] args) {

        System.out.println("=========== CENÁRIO 1 ===========");
        cenario1();

        System.out.println("\n=========== CENÁRIO 2 ===========");
        cenario2();

        System.out.println("\n=========== CENÁRIO 3 ===========");
        cenario3();

        System.out.println("\n=========== CENÁRIO 4 ===========");
        cenario4();

        System.out.println("\n=========== CENÁRIO 5 ===========");
        cenario5();
    }

    // 🔹 CENÁRIO 1: prioridade funcionando
    private static void cenario1() {
        CentralAtendimento central = new CentralAtendimento();
        gerarProcessos(central);

        central.listarPendentes();

        // atende só urgentes primeiro
        central.atenderProximo();
        central.atenderProximo();
        central.atenderProximo();

        System.out.println("\nDepois de atender urgentes:");
        central.listarPendentes();
    }

    // 🔹 CENÁRIO 2: desfazer funcionando
    private static void cenario2() {
        CentralAtendimento central = new CentralAtendimento();
        gerarProcessos(central);

        // atende tudo
        for(int i = 0; i < 9; i++){
            central.atenderProximo();
        }

        central.listarPendentes();

        // desfaz 3
        central.desfazeUltimoAtendimento();
        central.desfazeUltimoAtendimento();
        central.desfazeUltimoAtendimento();

        System.out.println("\nApós desfazer:");
        central.listarPendentes();
    }

    // 🔹 CENÁRIO 3: desfazer sem histórico
    private static void cenario3() {
        CentralAtendimento central = new CentralAtendimento();
        gerarProcessos(central);

        central.desfazeUltimoAtendimento();
    }

    // 🔹 CENÁRIO 4: histórico vazio
    private static void cenario4() {
        CentralAtendimento central = new CentralAtendimento();
        gerarProcessos(central);

        central.listarHistorico();
    }

    // 🔹 CENÁRIO 5: tudo atendido
    private static void cenario5() {
        CentralAtendimento central = new CentralAtendimento();
        gerarProcessos(central);

        for(int i = 0; i < 9; i++){
            central.atenderProximo();
        }

        central.listarPendentes();
    }

    private static void gerarProcessos(CentralAtendimento central) {
        central.abrirProcesso(new Processo("Usuario 1", "Financeiro", 1));
        central.abrirProcesso(new Processo("Usuario 2", "Saude", 2));
        central.abrirProcesso(new Processo("Usuario 3", "Programacao", 3));
        central.abrirProcesso(new Processo("Usuario 4", "Compras", 1));
        central.abrirProcesso(new Processo("Usuario 5", "Penal", 2));
        central.abrirProcesso(new Processo("Usuario 6", "Psicologico", 3));
        central.abrirProcesso(new Processo("Usuario 7", "Java", 1));
        central.abrirProcesso(new Processo("Usuario 8", "Limpeza", 2));
        central.abrirProcesso(new Processo("Usuario 9", "Mercado", 3));
    }
}