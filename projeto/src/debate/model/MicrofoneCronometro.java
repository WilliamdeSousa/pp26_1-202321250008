package debate.model;

public class MicrofoneCronometro {

    private boolean microfoneAtivo;

    public void ativar() {
        if (!microfoneAtivo) {
            microfoneAtivo = true;
            System.out.println("    [MICROFONE] Microfone ativado.");
        }
    }

    public void desativar() {
        microfoneAtivo = false;
        System.out.println("    [MICROFONE] Microfone desativado.");
    }

    public void esperarTempo(int tempo) {
        System.out.println("    [CRONOMETRO] Falando por " + tempo + " segundo(s)...");
        try {
            Thread.sleep(tempo * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isMicrofoneAtivo() {
        return microfoneAtivo;
    }
}
