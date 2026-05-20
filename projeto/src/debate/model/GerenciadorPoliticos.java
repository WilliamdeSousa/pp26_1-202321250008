package debate.model;

import debate.mediator.Mediador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerenciadorPoliticos {

    private final List<PoliticoColaborador> politicos = new ArrayList<>();
    private int totalSorteados = 0;

    public PoliticoColaborador sortear() {
        if (politicos.isEmpty()) {
            throw new IllegalStateException("Nenhum politico cadastrado para sortear.");
        }
        Random random = new Random();
        PoliticoColaborador politico;
        do {
            politico = politicos.get(random.nextInt(politicos.size()));
        } while (politico.getSorteado() && totalSorteados < politicos.size());
        totalSorteados++;
        politico.setSorteado(true);
        System.out.println("  [SORTEIO] " + politico.getName() + " foi sorteado como inquiridor.");
        return politico;
    }

    public PoliticoColaborador criarPolitico(String nome, Mediador mediador) {
        PoliticoColaborador novoPolitico = new PoliticoColaborador(nome);
        novoPolitico.setMediador(mediador);
        politicos.add(novoPolitico);
        System.out.println("  [CADASTRO] Politico registrado: " + nome);
        return novoPolitico;
    }

    public PoliticoColaborador obterPolitico(String nome) {
        return politicos.stream()
                .filter(p -> p.getName().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Politico nao encontrado: " + nome));
    }
}
