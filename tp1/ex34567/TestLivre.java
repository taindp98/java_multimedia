import util.Livre;
//main
class TestLivre{
public static void main(String args[]){
	// ex3
	Livre book1 = new Livre("France","Paris");
	//System.out.println("The Auteur of book 1 is" + book1.getAuteur());
	Livre book2 = new Livre("England", "London");
	//System.out.println("The Auteur of book 2 is" + book2.getAuteur());
	// ex4
	book1.setNbPages(10);
	book2.setNbPages(8);
	// System.out.println(book1);
	// book1.afficheToi();
	// ex7
	book2.setPrix(20);
	System.out.println(book2);
	book2.checkCurrentState();
	// change price invalid
	System.out.println("Set the new price");
	book2.setPrix(30);
	System.out.println(book2);
	book2.checkCurrentState();
	
//	int nbPageOfBook1, nbPageOfBook2;
//	nbPageOfBook1 = book1.getNbPages();
//        nbPageOfBook2 = book2.getNbPages();
//	System.out.format("The number of pages of book 1 is: %d%n", nbPageOfBook1);
//	System.out.format("The number of pages of book 2 is: %d%n", nbPageOfBook2);
//	System.out.format("The total of pages of two books is: %d%n",nbPageOfBook1 + nbPageOfBook2);	
}
}
