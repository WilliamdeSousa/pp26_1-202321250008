package debate.mediator;

import debate.model.Configuracao;
import debate.model.InquiridorColaborador;
import debate.model.InquiridoColaborador;
import debate.model.PoliticoColaborador;
import debate.singleton.Logger;

public class MediadorDebate implements Mediador {

    private InquiridorColaborador inquiridor;
    private InquiridoColaborador inquirido;

    @Override
    public void debate(Configuracao config) {
        Logger.getInstance().registerLog("Pergunta - " + inquiridor.getName() + " questiona " + inquirido.getName());
        inquiridor.falar(config.getPerguntaTempo());

        Logger.getInstance().registerLog("Resposta - " + inquirido.getName() + " responde");
        inquirido.falar(config.getRespostaTempo());

        Logger.getInstance().registerLog("Replica - " + inquirido.getName() + " replica");
        inquirido.falar(config.getReplicaTempo());

        Logger.getInstance().registerLog("Treplica - " + inquirido.getName() + " treplica");
        inquirido.falar(config.getTreplicaTempo());
    }

    @Override
    public void setInquiridor(PoliticoColaborador politico) {
        inquiridor = new InquiridorColaborador(politico);
    }

    @Override
    public void setInquirido(PoliticoColaborador politico) {
        inquirido = new InquiridoColaborador(politico);
    }

    public InquiridorColaborador getInquiridor() {
        return inquiridor;
    }

    public InquiridoColaborador getInquirido() {
        return inquirido;
    }
}
