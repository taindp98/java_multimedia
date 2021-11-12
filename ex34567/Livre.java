package util;

public class Livre {
// Variables
private String titre, auteur;
private int nbPages; // miss ;

// Constructeur
public Livre(String unAuteur, String unTitre) {
auteur = unAuteur;
titre = unTitre;
}
// Accesseur
public String getAuteur(){ // space
return auteur;
}

// titre and nbpages
public String getTitre(){
return titre;
}
public int getNbPages(){
return nbPages;
}

// Modificateur
public void setNbPages(int nb){
// condition
if (nb <= 0){
System.out.println("The number of page of book is invalid");
}
else{
nbPages = nb; // wrong argument
}
}
// auteur and titre
public void setTitre(String tit){
titre = tit;
}
public void setAuteur(String aut){
auteur = aut;
}
// ex6
public void afficheToi(){
System.out.println("This is the book description using afficheToi method:");
System.out.println("The auteur is: " + auteur);
System.out.println("The title is: " + titre);
System.out.format("The number of pages is: %d%n", nbPages);
}
// overide tostring
public String toString(){
System.out.println("This is the book description using toString method");
return "The auteur is: "+ auteur + " " + "The title is: " + titre + " "+ "The number of pages is: " + nbPages;
}

//main
// public static void main(String args[]){
// 	// ex3
// 	Livre book1 = new Livre("auteur A","title A");
// 	System.out.println("The Auteur of book 1 is" + book1.getAuteur());
// 	Livre book2 = new Livre("auteur B", "title B");
// 	System.out.println("The Auteur of book 2 is" + book2.getAuteur());
// 	// ex4
// 	book1.setNbPages(10);
// 	book2.setNbPages(-1);
// 	int nbPageOfBook1, nbPageOfBook2;
// 	nbPageOfBook1 = book1.getNbPages();
//         nbPageOfBook2 = book2.getNbPages();
// 	System.out.format("The number of pages of book 1 is: %d%n", nbPageOfBook1);
// 	System.out.format("The number of pages of book 2 is: %d%n", nbPageOfBook2);
// 	System.out.format("The total of pages of two books is: %d%n",nbPageOfBook1 + nbPageOfBook2);	
// }

}

