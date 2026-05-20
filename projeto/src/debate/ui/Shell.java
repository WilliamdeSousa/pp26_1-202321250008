package debate.ui;

import debate.facade.Facade;

public class Shell implements UserInterface {

    private final Facade facade = Facade.getInstance();

    @Override
    public void operacao() {
        facade.sortearInquiridor();
        facade.iniciarDebate();
    }
}
