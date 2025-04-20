package classes;

public class Constructors {

	public static void main(String[] args) {

		class Auto {
			private String brand;
		    private String modello;
		    private int anno;
		    private String targa = "AB123CD"; // Inizializzazione di un campo con un valore predefinito
		    
			// Nessun costruttore: viene creato automaticamente un costruttore di default.
			
		    
		    // Costruttore di default
			public Auto() {}

			// Costruttore parametrizzato
			
			public Auto(String brand, String modello, int anno, String targa) {
		        this.brand = brand;       // "this.brand" si riferisce al campo della classe, mentre "brand" è il parametro.
		        this.modello = modello;
		        this.anno = anno;
		        this.targa = "XY123AB"; // Ridefiniamo il campo targa con un valore specifico";
		    }
			
			// Uso di this()
			public Auto(String brand, String modello) {
				this(brand, modello, 2018, "DU375MB"); // Invoca il costruttore di default con i parametri passati
				// Questo consente di riutilizzare il codice del costruttore parametrizzato
				// solo l'ultimo parametro è passato come valore specifico.
			}
			
			@Override
			public String toString() {
				return "[brand=" + brand + ", modello=" + modello + ", anno=" + anno + ", targa=" + targa + "]";
			}
			
		}

		Auto auto1 = new Auto(); // Invoca il costruttore senza parametri
		System.out.println(auto1);
		
		// Creazione di un'istanza della classe Auto utilizzando il costruttore parametrizzato
		Auto auto2 = new Auto("Fiat", "Panda", 2020, "HJ541DN");
		System.out.println(auto2);
		
		// Creazione di un'istanza della classe Auto utilizzando il costruttore con due parametri
		Auto auto3 = new Auto("Fiat", "Panda");
		System.out.println(auto3);

	}
}
