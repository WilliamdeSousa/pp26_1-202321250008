abstract class Publicacao {
  protected Implementador imp;

  public Publicacao(Implementador tipo) {
    this.imp = tipo;
  }

  public void obterDados() {
    imp.getDados();
  }

  abstract public void getTitulo();

  abstract public void getAutor();
}