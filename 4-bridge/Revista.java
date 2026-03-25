class Revista extends Publicacao {
  public Revista(Implementador tipo) {
    super(tipo);
  }

  public void getArtigo() {
    System.out.println("Mostrando artigo da Revista...");
  }

  @Override
  public void getTitulo() {
    System.out.println("Mostrando título da Revista...");
  }

  @Override
  public void getAutor() {
    System.out.println("Mostrando autor da Revista...");
  }
}