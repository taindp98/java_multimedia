import util.Personne;

public class Client extends Personne {
	// Variables
	private String pname, pcode;
	private int quant;
	private double uprice;

	// Constructeurs
	public Client(final String unName, final String unAddr, final long nbTel, final String pname, 
				final String pcode, final int quant, final double uprice) {
		super(unName, unAddr, nbTel);
		this.pname = pname;
		this.pcode = pcode;
		this.quant = quant;
		this.uprice = uprice;	
		}

		// Accesseur
	public String getPname() {
		return pname;
	}

	public String getPcode() {
		return pcode;
	}

	public int getQuant() {
		return quant;
	}
		
	public double getPrice() {
		return uprice;
	}

		// Modificateur
	public void setPname(final String Pname) {
		pname = Pname;
	}

	public void setPcode(final String Pcode) {
		pcode = Pcode;
	}

	public void setQuant(final int n) {
		if (n >= 0) {
			quant = n;
		} else {
			System.err.println("Erreur : nombre de quantite incorrect!");
		}
	}
	public void setPrice(final double Price) {
		if (Price >= 0) {
			uprice = Price;
		} else {
			System.err.println("Erreur : Prix pas encore donné!");
		}
	}
}
