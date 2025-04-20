package classes;

// Super-classe
class Animale {
    String nome;

    void dorme() {
        System.out.println(nome + " sta dormendo...");
    }
}

// Sotto-classe
class Cane extends Animale {
    void abbaia() {
        System.out.println(nome + " sta abbaiando!");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Cane mioCane = new Cane();
        mioCane.nome = "Fido";
        mioCane.dorme();  // Ereditato da Animale
        mioCane.abbaia(); // Metodo specifico di Cane
    }
}

// Access Methods
class Persona1 {
    // Campi privati: non accessibili direttamente da altre classi
    private String nome;
    private String cognome;

    // Costruttore per inizializzare i campi
    public Persona1(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    // Getter per 'nome'
    public String getNome() {
        return nome;
    }

    // Setter per 'nome'
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter per 'cognome'
    public String getCognome() {
        return cognome;
    }

    // Setter per 'cognome'
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    // Metodo che mostra gli attributi (senza permettere la loro modifica)
    public void viewAttr() {
        System.out.println("Nome: " + nome + ", Cognome: " + cognome);
    }
}

class Studente extends Persona1 {
    private String matricola;

    // Costruttore della sottoclasse che richiama il costruttore della superclasse
    public Studente(String nome, String cognome, String matricola) {
        super(nome, cognome); // Inizializza 'nome' e 'cognome' nella superclasse
        this.matricola = matricola;
    }

    // Getter per 'matricola'
    public String getMatricola() {
        return matricola;
    }

    // Setter per 'matricola'
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    // Metodo che estende la visualizzazione degli attributi
    public void viewStudentInfo() {
        // Utilizziamo i metodi della superclasse per ottenere nome e cognome
        System.out.println("Studente: " + getNome() + " " + getCognome() +
                ", Matricola: " + matricola);
    }
}

// Classi final
final class CannotBeExtended {}

// class CannotExtend extends CannotBeExtended {};

// Membri di istanza e di classe
class Auto2 {
    // Campo statico: comune a tutte le istanze
    public static String marca = "Fiat";

    // Campo di istanza: unico per ogni istanza
    private String colore;

    // Costruttore per impostare il colore dell'auto
    public Auto2(String colore) {
        this.colore = colore;
    }

    // Metodo di istanza per ottenere il colore dell'auto
    public String getColore() {
        return colore;
    }

    // Metodo statico per ottenere la marca dell'auto
    public static String getMarca() {
        return marca;
    }

    public static void main(String[] args) {
        // Accesso al membro statico senza creare un'istanza
        System.out.println("Marca dell'auto: " + Auto2.getMarca());

        // Creazione di istanze con differenti colori
        Auto2 auto1 = new Auto2("rosso");
        Auto2 auto2 = new Auto2("blu");

        // Accesso ai membri di istanza tramite oggetti
        System.out.println("Auto1 ha colore: " + auto1.getColore());
        System.out.println("Auto2 ha colore: " + auto2.getColore());
    }
}
