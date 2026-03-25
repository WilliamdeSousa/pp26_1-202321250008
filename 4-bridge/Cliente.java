public class Cliente {
  public static void main() {
    Livro divinaComedia = new Livro(new PublicacaoImplBD());

    divinaComedia.obterDados();
    divinaComedia.getISBN();
    divinaComedia.getTitulo();
    divinaComedia.getAutor();

    Revista gMagazine = new Revista(new PublicacaoImplXML());

    gMagazine.obterDados();
    gMagazine.getArtigo();
    gMagazine.getTitulo();
    gMagazine.getAutor();
  }
}
