import debate.facade.Facade;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        line('=', 55);
        System.out.println("        SISTEMA DE DEBATE POLITICO");
        System.out.println("   Padroes: Facade | Mediator | Observer | Singleton");
        line('=', 55);
        System.out.println();

        Facade facade = Facade.getInstance();

        // ----------------------------------------------------------------
        // FASE 1 - Cadastro de Candidatos
        // ----------------------------------------------------------------
        header("FASE 1: Cadastro de Candidatos");
        facade.cadastrarPolitico("Alice Silva");
        facade.cadastrarPolitico("Bruno Costa");
        facade.cadastrarPolitico("Carlos Mendes");
        System.out.println();

        // ----------------------------------------------------------------
        // FASE 2 - Cadastro de Eleitores  (Observer pattern)
        // Cada eleitor e notificado quando seu candidato usa o microfone
        // ----------------------------------------------------------------
        header("FASE 2: Cadastro de Eleitores");
        facade.cadastrarEleitor("Joao",       "Alice Silva");
        facade.cadastrarEleitor("Maria",      "Alice Silva");
        facade.cadastrarEleitor("Pedro",      "Bruno Costa");
        facade.cadastrarEleitor("Ana",        "Bruno Costa");
        facade.cadastrarEleitor("Carlos Jr.", "Carlos Mendes");
        System.out.println();

        // ----------------------------------------------------------------
        // FASE 3 - Configuracao dos Tempos
        // Formato: [pergunta, resposta, replica]
        // treplica reutiliza tempos[0] conforme a UML
        // ----------------------------------------------------------------
        header("FASE 3: Configuracao dos Tempos (segundos)");
        facade.configuracao(new int[]{1, 2, 1});
        System.out.println("  Pergunta: 1s | Resposta: 2s | Replica: 1s | Treplica: 1s");
        System.out.println();

        // ----------------------------------------------------------------
        // FASE 4 - Sorteio do Inquiridor  (GerenciadorPoliticos)
        // ----------------------------------------------------------------
        header("FASE 4: Sorteio do Inquiridor");
        facade.sortearInquiridor();
        String inquiridorNome = facade.getNomeInquiridor();
        System.out.println();

        // ----------------------------------------------------------------
        // FASE 5 - Escolha do Inquirido
        // Garantimos que o inquirido e diferente do inquiridor
        // ----------------------------------------------------------------
        header("FASE 5: Escolha do Inquirido");
        String[] candidatos = {"Alice Silva", "Bruno Costa", "Carlos Mendes"};
        String inquiridoNome = Arrays.stream(candidatos)
                .filter(c -> !c.equalsIgnoreCase(inquiridorNome))
                .findFirst()
                .orElse(candidatos[0]);
        System.out.println("  Inquirido escolhido: " + inquiridoNome);
        facade.escolherInquirido(inquiridoNome);
        System.out.println();

        // ----------------------------------------------------------------
        // FASE 6 - Debate  (Mediator pattern coordena as falas)
        // Fluxo: Pergunta -> Resposta -> Replica -> Treplica
        // ----------------------------------------------------------------
        header("FASE 6: DEBATE AO VIVO");
        line('-', 55);
        facade.iniciarDebate();
        line('-', 55);
        System.out.println();

        // ----------------------------------------------------------------
        // FASE 7 - Historico de Logs  (Singleton Logger)
        // ----------------------------------------------------------------
        header("FASE 7: Historico Completo de Logs");
        facade.getLogs().forEach(log -> System.out.println("  " + log));
        System.out.println();
        line('=', 55);
        System.out.println("   FIM DO DEBATE");
        line('=', 55);
    }

    private static void header(String title) {
        System.out.println(">> " + title);
        line('-', 55);
    }

    private static void line(char c, int len) {
        System.out.println(String.valueOf(c).repeat(len));
    }
}
