package debate.facade;

import debate.mediator.MediadorDebate;
import debate.model.Configuracao;
import debate.model.GerenciadorPoliticos;
import debate.model.PoliticoColaborador;
import debate.observer.EleitorConcreto;
import debate.singleton.Logger;

import java.util.List;

public class Facade {

    private static Facade instance;
    private final MediadorDebate mediadorDebate;
    private final Configuracao config;
    private final GerenciadorPoliticos gerenciaPoliticos;
    private final Logger logger;

    private Facade() {
        mediadorDebate = new MediadorDebate();
        config = new Configuracao();
        gerenciaPoliticos = new GerenciadorPoliticos();
        logger = Logger.getInstance();
        logger.registerLog("Fachada iniciada");
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public void configuracao(int[] tempos) {
        config.setPerguntaTempo(tempos[0]);
        config.setRespostaTempo(tempos[1]);
        config.setReplicaTempo(tempos[2]);
        config.setTreplicaTempo(tempos[0]); // conforme UML: treplica reutiliza tempos[0]
        logger.registerLog("Configura tempo: pergunta=" + tempos[0] + "s, resposta=" + tempos[1] + "s, replica=" + tempos[2] + "s, treplica=" + tempos[0] + "s");
    }

    public List<String> getLogs() {
        return logger.getAllLogs();
    }

    public void sortearInquiridor() {
        PoliticoColaborador politico = gerenciaPoliticos.sortear();
        mediadorDebate.setInquiridor(politico);
        logger.registerLog("Inquiridor sorteado: " + politico.getName());
    }

    public void escolherInquirido(String nome) {
        PoliticoColaborador politico = gerenciaPoliticos.obterPolitico(nome);
        mediadorDebate.getInquiridor().escolherInquirido(politico);
        logger.registerLog("Inquirido escolhido: " + nome);
    }

    public void iniciarDebate() {
        logger.registerLog("Debate iniciado");
        mediadorDebate.debate(config);
        logger.registerLog("Debate encerrado");
    }

    public void cadastrarPolitico(String nome) {
        gerenciaPoliticos.criarPolitico(nome, mediadorDebate);
    }

    public void cadastrarEleitor(String nome, String candidato) {
        PoliticoColaborador politico = gerenciaPoliticos.obterPolitico(candidato);
        new EleitorConcreto(nome, politico);
        System.out.println("  [CADASTRO] Eleitor registrado: " + nome + " -> " + candidato);
    }

    public String getNomeInquiridor() {
        if (mediadorDebate.getInquiridor() != null) {
            return mediadorDebate.getInquiridor().getName();
        }
        return null;
    }
}
