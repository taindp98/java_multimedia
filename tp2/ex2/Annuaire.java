import org.apache.commons.lang.*;
import util.Personne;
import java.util.Scanner;

public class Annuaire {

	private final int max = 10;
	private Personne[] annuaire = new Personne[max];
	private static int index = 1;
	private Scanner scan;
	private Scanner scan2;
	private static Scanner scan3;

	// Ajouter une nouvelle fiche
	public void AddPersonne() {
		// Adding name;
		System.out.println("Enter name: ");
		scan = new Scanner(System.in);
		String name = scan.nextLine();
		// Adding address
		System.out.println("Enter address: ");
		String addr = scan.nextLine();
		// Adding telephone number
		System.out.println("Enter tel: ");
		long tel = scan.nextLong();
		annuaire[index++] = new Personne(name, addr, tel);
	}

	// Supprimer une fiche
	public void DelPersonne(int position) {
		annuaire = (Personne[]) ArrayUtils.remove(annuaire, position);
		index--;
	}

	// Recherche d'une fiche en fonction de son nom (complet ou pas)
	public void SearchName(String name) {
		boolean findName = false;
		System.out.printf("Search by name \"%s\": \n", name);
		for (int i = 1; i < index; i++) {
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

	// Modifier une fiche
	public void Modify(int position) {
		if (position>index || position<1){
			System.err.println("This is not in the list!");
		} else {
		// Entering name
		System.out.println("Enter a novel name: ");
		scan2 = new Scanner(System.in);
		String name = scan2.nextLine();
		// Entering address
		System.out.println("Enter a novel address: ");
		String addr = scan2.nextLine();
		// Entering tel
		System.out.println("Enter a novel tel: ");
		long tel = scan2.nextLong();

		annuaire[position].setName(name);
		annuaire[position].setAddr(addr);
		annuaire[position].setTel(tel);
		}
	}

	// Affichier la fiche
	public void Display(int position) {
		String dsp = String.format("%-5d %-20s %-20s %-10d", position, annuaire[position].getName(),
										annuaire[position].getAddr(), annuaire[position].getTel());
		System.out.println(dsp);
	}

	public static void main(String[] agrs) {
		Annuaire a1 = new Annuaire();
		scan3 = new Scanner(System.in);
		int option;
		do {
			System.out.println("Directory: ");
			System.out.println("1. Add a new record");
			System.out.println("2. Delete a record");
			System.out.println("3. Search for a file according to its name (complete or not)");
			System.out.println("4. Search for a file according to its phone");
			System.out.println("5. Modify a file");
			System.out.println("6. Show result");
			System.out.println("7. Exit!");
			System.out.println("Select the option: ");
			option = scan3.nextInt();
			switch (option) {
			case 1:
				a1.AddPersonne();
				break;
			case 2:
				System.out.println("Position to delete: ");
				int position = scan3.nextInt();
				a1.DelPersonne(position);
				break;
			case 3:
				System.out.println("Enter name to search: ");
				Scanner scan2 = new Scanner(System.in);
				String name = scan2.nextLine();
				a1.SearchName(name);
				break;
			case 4:
				System.out.println("Enter tel to search: ");
				int tel = scan3.nextInt();
				a1.SearchTel(tel);
				break;
			case 5:
				System.out.println("Position to modify: ");
				int position2 = scan3.nextInt();
				a1.Modify(position2);
				break;
			case 6:
				String res = String.format("%-5s %-20s %-20s %-10s", "Order", "Name", "Address", "Tel");
				System.out.println(res);
				for (int i = 1; i < index; i++) {
					a1.Display(i);
				}
				break;
			}
			;
			System.out.print("\n");

		} while (option != 7);
		System.out.println("Quitter!");
	}

}
