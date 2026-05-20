package debate.model;

import debate.mediator.Mediador;
import debate.observer.Eleitor;

import java.util.ArrayList;
import java.util.List;

public class PoliticoColaborador {

    protected String name;
    protected Mediador mediador;
    protected boolean sorteado;
    protected MicrofoneCronometro microfone;
    protected List<Eleitor> eleitores;

    public PoliticoColaborador(String nome) {
        this.name = nome;
        this.microfone = new MicrofoneCronometro();
        this.eleitores = new ArrayList<>();
        this.sorteado = false;
    }

    public void chamarOperacao() {}

    public void falar(int tempo) {
        System.out.println("\n  >> " + name + " vai falar por " + tempo + "s");
        microfone.ativar();
        notificar();
        microfone.esperarTempo(tempo);
        microfone.desativar();
    }

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }

    public void setSorteado(boolean op) {
        this.sorteado = op;
    }

    public boolean getSorteado() {
        return sorteado;
    }

    public String getName() {
        return name;
    }

    public Mediador getMediador() {
        return mediador;
    }

    public MicrofoneCronometro getMicrofone() {
        return microfone;
    }

    public List<Eleitor> getEleitores() {
        return eleitores;
    }

    public void adicionarEleitor(Eleitor eleitor) {
        eleitores.add(eleitor);
    }

    public void removerEleitor(Eleitor eleitor) {
        eleitores.remove(eleitor);
    }

    public void notificar() {
        microfone.ativar();
        for (Eleitor eleitor : eleitores) {
            eleitor.notificar();
        }
    }
}
