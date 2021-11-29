package util;

public class Personne {
	// Variables
		private String name;
		private String addr;
		private long tel;

		// Constructeurs
		public Personne(final String unName, final String unAddr, final long nbTel) {
			name = unName;
			addr = unAddr;
			setTel(nbTel);
		}

		// Accesseur
		public String getName() {
			return name;
		}

		public String getAddr() {
			return addr;
		}

		public long getTel() {
			return tel;
		}

		// Modificateur
		public void setName(final String unName) {
			name = unName;
		}

		public void setAddr(final String unAddr) {
			addr = unAddr;
		}

		public void setTel(final long nb) {
			if (nb > 9) {
				tel = nb;
			} else {
				System.err.println("Erreur : nombre de tel incorrect!");
			}
		}
}
