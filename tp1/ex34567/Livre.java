package util;

public class Livre {
// Variables
private String titre, auteur;
private int nbPages; // miss ;

// ex7 initial price with value is -1
private double prix = -1;
private boolean isPrixFixe = false;

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
System.out.println(prix);
}

// overide tostring
public String toString(){
System.out.println("This is the book description using toString method");
if (prix != -1){
return "The auteur is: "+ auteur + "," + "The title is: " + titre + ","+ "The number of pages is: " + nbPages + "," + "The price is: " + prix;
}
else{
return "The auteur is: "+ auteur + "," + "The title is: " + titre + ","+ "The number of pages is: " + nbPages + "," + "The price not yet given";
}
}

// investigate
public void checkCurrentState(){
System.out.println("Calling the checkCurrentState method and show current state");
if (prix != -1){
	System.out.println("The auteur is: " + auteur);
	System.out.println("The title is: " + titre);
	System.out.format("The number of pages is: %d%n", nbPages);
	System.out.printf("The book price is: %f%n", prix);
}
else{
	System.out.println("The auteur is: " + auteur);
	System.out.println("The title is: " + titre);
	System.out.format("The number of pages is: %d%n", nbPages);
	System.out.printf("The price not yet given");
}
}

// ex7 price
public void setPrix(double pr){
if (pr < 0){
	System.out.println("The value of price is invalid");
}
else{}
if (isPrixFixe == false){
prix = pr;
System.out.println("The boolean: " + isPrixFixe + "," + pr);
isPrixFixe = true;
}
else{
System.out.println("Don't allow set the new book price");
System.out.println("The boolean: " + isPrixFixe + "," + pr);
}
}

public double getPrix(){
return prix;
}

}

