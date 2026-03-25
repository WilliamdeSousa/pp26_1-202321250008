class Livro extends Publicacao {
  public Livro(Implementador tipo) {
    super(tipo);
  }

  public void getISBN() {
    System.out.println("Mostrando ISBN do Livro...");
  }

  @Override
  public void getTitulo() {
    System.out.println("Mostrando título do Livro...");
  }

  @Override
  public void getAutor() {
    System.out.println("Mostrando autor do Livro...");
  }
}