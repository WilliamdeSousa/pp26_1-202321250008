package debate.model;

public class InquiridoColaborador extends PoliticoColaborador {

    public InquiridoColaborador(PoliticoColaborador politico) {
        super(politico.getName());
        this.mediador = politico.getMediador();
        this.sorteado = politico.getSorteado();
        this.eleitores = politico.getEleitores();
        this.microfone = politico.getMicrofone();
    }
}
