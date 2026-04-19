import java.util.Scanner;

public class MenuAtendimento {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        // Trocamos para a Central que gerencia Pendentes e Histórico
        CentralAtendimento central = new CentralAtendimento(); 
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- SISTEMA DE GESTÃO DE ATENDIMENTO ---");
            System.out.println("1. Abrir Novo Processo");
            System.out.println("2. Atender Próximo");
            System.out.println("3. Desfazer Último Atendimento"); // Nova ordem
            System.out.println("4. Listar Pendentes");            // Nova ordem
            System.out.println("5. Listar Histórico");            // Nova ordem
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(leitor.nextLine());

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome do Solicitante: ");
                        String nome = leitor.nextLine();
                        System.out.print("Tipo de Serviço: ");
                        String servico = leitor.nextLine();
                        System.out.print("Prioridade (1-Baixa, 2-Normal, 3-Urgente): ");
                        int prio = Integer.parseInt(leitor.nextLine());

                        Processo novo = new Processo(nome, servico, prio);
                        central.abrirProcesso(novo); 
                    }

                    case 2 -> {
                        
                        central.atenderProximo();
                    }

                    case 3 -> {
                        // Move do histórico de volta para pendentes
                        central.desfazeUltimoAtendimento();
                    }

                    case 4 -> {
                        // Exibe o que ainda não foi atendido
                        central.listarPendentes();
                    }

                    case 5 -> {
                        // Exibe o que já foi atendido
                        central.listarHistorico();
                    }

                    case 0 -> System.out.println("Encerrando sistema...");

                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números para as opções.");
            }
        }
        leitor.close();
    }
}