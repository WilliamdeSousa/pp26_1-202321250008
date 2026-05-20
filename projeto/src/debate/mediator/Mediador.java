package debate.mediator;

import debate.model.Configuracao;
import debate.model.PoliticoColaborador;

public interface Mediador {
    void debate(Configuracao config);
    void setInquiridor(PoliticoColaborador politico);
    void setInquirido(PoliticoColaborador politico);
}
