package debate.model;

public class Configuracao {

    private int pergunta;
    private int resposta;
    private int replica;
    private int treplica;

    public int getPerguntaTempo() { return pergunta; }
    public void setPerguntaTempo(int t) { this.pergunta = t; }

    public int getRespostaTempo() { return resposta; }
    public void setRespostaTempo(int t) { this.resposta = t; }

    public int getReplicaTempo() { return replica; }
    public void setReplicaTempo(int t) { this.replica = t; }

    public int getTreplicaTempo() { return treplica; }
    public void setTreplicaTempo(int t) { this.treplica = t; }
}
