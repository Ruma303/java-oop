package classes;

public class Introduction {

	public static void main(String[] args) {
		
		Persona p1 = new Persona("Mario", "Rossi", "AABBCC");
		System.out.println(p1); // Richiama automaticamente toString()

		Persona p2 = new Persona("Luca", "Bianchi", "AABBCC");
		System.out.println(p2.toString()); // Possiamo usare toString() ma è superfluo

		System.out.println("\n");

		// Confronto oggetti
		if (p1 == p2) {
			System.out.println("Persona 1 e 2 sono uguali, confrontati con ==");
			// FALSE in quanto non sono lo stesso oggetto
		} else if (p1.equals(p2)) {
			System.out.println("Persona 1 e 2 sono uguali, confrontati con equals()");
			// TRUE in quanto il confronto è su un campo dei due oggetti
		} else {
			System.out.println("Persona 1 e 2 NON sono uguali");
		} 
	}
}

// Metodi classe Object

class Persona {
	private String nome;
	private String cognome;
	private String codiceFiscale;

	public Persona(String nome, String cognome, String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", codice fiscale=" + codiceFiscale + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true; // verifica se i riferimenti coincidono
		if (!(obj instanceof Persona)) return false; // verifica se gli oggetti sono della stessa classe locale
		Persona other = (Persona) obj; // cast sicuro dopo il controllo
		return this.codiceFiscale.equals(other.codiceFiscale);
	}

	@Override
	public int hashCode() {
		return codiceFiscale.hashCode();
	}
}