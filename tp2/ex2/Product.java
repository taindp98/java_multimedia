// import java.util.*;
import org.apache.commons.lang.*;
import util.Personne;
import java.util.Scanner;

public class Product {

	private final int max = 10;
	private Client[] annuaire = new Client[max];
	private static int index = 0;
	private Scanner scan;
	private Scanner scan2;
	private static Scanner scan3;

	// Ajouter une nouvelle fiche
	public void AddInfo() {
		// Adding name;
		System.out.println("Enter name: ");
		scan = new Scanner(System.in);
		String name = scan.nextLine();
		// Adding address
		System.out.println("Enter address: ");
		String addr = scan.nextLine();
		// Adding product name;
		System.out.println("Enter product name: ");
		String pname = scan.nextLine();
		// Adding product code
		System.out.println("Enter product code: ");
		String pcode = scan.nextLine();
		// Adding the quantity
		System.out.println("Enter quantity: ");
		int quant = scan.nextInt();
		// Adding the unit price
		System.out.println("Enter unit price: ");
		double uprice = scan.nextDouble();	
		// Adding telephone number
		System.out.println("Enter tel: ");
		long tel = scan.nextLong();
		annuaire[index++] = new Client(name, addr, tel, pname, pcode, quant, uprice);
	}

	// Supprimer une fiche
	public void DelInfo(int position) {
		annuaire = (Client[]) ArrayUtils.remove(annuaire, position);
		index--;
	}

	// Recherche d'une fiche en fonction de son nom (complet ou pas)
	public void SearchName(String name) {
		boolean findName = false;
		System.out.printf("Search by name \"%s\": \n", name);
		for (int i = 0; i < index; i++) {
			if (annuaire[i].getName().matches(".*" + name + ".*")) {
				this.Display(i);
				findName = true;
			}
		}
		if (!findName) {
			System.out.println("Cannot find the name \"" + name);
		}
	}

	// Recherche d'une fiche en fonction de son tel
	public void SearchTel(long tel) {
		boolean findTel = false;
		System.out.printf("Search by tel \"%s\": \n", tel);
		for (int i = 1; i < index; i++) {
			if (annuaire[i].getTel() == tel) {
				this.Display(i);
				findTel = true;
			}
		}
		if (!findTel) {
			System.out.println("Cannot find the tel \"" + tel);
		}
	}

	// Recherche d'une fiche en fonction de son nom produit (complet ou pas)
	public void SearchPname(String pname) {
		boolean findPname = false;
		System.out.printf("Search by name \"%s\": \n", pname);
		for (int i = 1; i < index; i++) {
			if (annuaire[i].getName().matches(".*" + pname + ".*")) {
				this.Display(i);
				findPname = true;
			}
		}
		if (!findPname) {
			System.out.println("Cannot find the name \"" + pname);
		}
	}
	
	// Recherche d'une fiche en fonction de son code produit (complet ou pas)
	public void SearchPcode(String pcode) {
		boolean findCode = false;
		System.out.printf("Search by name \"%s\": \n", pcode);
		for (int i = 1; i < index; i++) {
			if (annuaire[i].getName().matches(".*" + pcode + ".*")) {
				this.Display(i);
				findCode = true;
			}
		}
		if (!findCode) {
			System.out.println("Cannot find the name \"" + pcode);
		}
	}
	
	// Modifier une fiche
	public void Modify(int position) {
		if (position>index || position<0){
			System.err.println("This is not in the list!");
		} else {
		// Entering name
		System.out.println("Enter a novel name: ");
		scan2 = new Scanner(System.in);
		String name = scan2.nextLine();
		// Entering address
		System.out.println("Enter a novel address: ");
		String addr = scan2.nextLine();
		// Entering product name
		System.out.println("Enter a novel product name: ");
		String pname = scan2.nextLine();
		// Entering address
		System.out.println("Enter a novel product code: ");
		String pcode = scan2.nextLine();
		// Entering address
		System.out.println("Enter a novel quantity: ");
		int quant = scan2.nextInt();
		// Entering address
		System.out.println("Enter a novel unit price: ");
		int uprice = scan2.nextInt();
		// Entering tel
		System.out.println("Enter a novel tel: ");
		long tel = scan2.nextLong();
		annuaire[position].setName(name);
		annuaire[position].setAddr(addr);
		annuaire[position].setTel(tel);
		annuaire[position].setPname(pname);
		annuaire[position].setPcode(pcode);
		annuaire[position].setQuant(quant);
		annuaire[position].setPrice(uprice);
		
		}
	}

	// Affichier la fiche
	public void Display(int position) {
		String dsp = String.format("%-10s %-20s %-20s %-10s %-20s %-10s %-10s %-10s", position, 
				annuaire[position].getName(),annuaire[position].getAddr(), annuaire[position].getTel(),
				annuaire[position].getPname(),annuaire[position].getPcode(),annuaire[position].getQuant(),
				annuaire[position].getPrice());
		System.out.println(dsp);
	}

	public static void main(String[] agrs) {
		Product p1 = new Product();
		scan3 = new Scanner(System.in);
		int option;
		do {
			System.out.println("Directory: ");
			System.out.println("1. Ajouter une nouvelle fiche");
			System.out.println("2. Supprimer une fiche");
			System.out.println("3. Recherche d'une fiche en fonction de son nom (complet ou pas)");
			System.out.println("4. Recherche d'une fiche en fonction de son tel");
			System.out.println("5. Recherche d'une fiche en fonction de son produit nom (complet ou pas)");
			System.out.println("6. Recherche d'une fiche en fonction de son produit code (complet ou pas)");
			System.out.println("7. Modifier une fiche");
			System.out.println("8. Afficher le resultat");
			System.out.println("9. Quitter!");
			System.out.println("Selectionnez l'option: ");
			option = scan3.nextInt();
			switch (option) {
			case 1:
				p1.AddInfo();
				break;
			case 2:
				System.out.println("Position to delete: ");
				int position = scan3.nextInt();
				p1.DelInfo(position);
				break;
			case 3:
				System.out.println("Enter name to search: ");
				Scanner scan2 = new Scanner(System.in);
				String name = scan2.nextLine();
				p1.SearchName(name);
				break;
			case 4:
				System.out.println("Enter tel to search: ");
				long tel = scan3.nextInt();
				p1.SearchTel(tel);
				break;
			case 5:
				System.out.println("Enter product name to search: ");
				String pname = scan3.nextLine();
				p1.SearchPname(pname);
				break;
			case 6:
				System.out.println("Enter product code to search: ");
				String pcode = scan3.nextLine();
				p1.SearchPcode(pcode);
				break;
			case 7:
				System.out.println("Position to modify: ");
				int position2 = scan3.nextInt();
				p1.Modify(position2);
				break;
			case 8:
				String res = String.format("%-10s %-20s %-20s %-10s %-20s %-10s %-10s %-10s", 
						"Order", "Name", "Address", "Tel", "Product", "Code", "Quantity", "UPrice");
				System.out.println(res);
				for (int i = 0; i < index; i++) {
					p1.Display(i);
				}
				break;
			}
			;
			System.out.print("\n");

		} while (option != 9);
		System.out.println("Quitter!");
	}

}
