package debate.observer;

import debate.model.PoliticoColaborador;

public class EleitorConcreto implements Eleitor {

    private final String name;
    private final PoliticoColaborador candidato;

    public EleitorConcreto(String nome, PoliticoColaborador politicoColaborador) {
        this.name = nome;
        this.candidato = politicoColaborador;
        candidato.adicionarEleitor(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void notificar() {
        System.out.println("    [ELEITOR] " + name + ": \"Candidato " + candidato.getName() + " esta falando!\"");
    }
}
