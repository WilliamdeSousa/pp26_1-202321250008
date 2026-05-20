package debate.model;

public class InquiridorColaborador extends PoliticoColaborador {

    public InquiridorColaborador(PoliticoColaborador politico) {
        super(politico.getName());
        this.mediador = politico.getMediador();
        this.sorteado = politico.getSorteado();
        this.eleitores = politico.getEleitores();
        this.microfone = politico.getMicrofone();
    }

    public void escolherInquirido(PoliticoColaborador politico) {
        mediador.setInquirido(politico);
    }
}
