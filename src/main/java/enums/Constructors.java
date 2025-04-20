package enums;

enum Giorno {
    LUNEDI("Inizio della settimana"),
    MARTEDI("Secondo giorno"),
    MERCOLEDI("Meta settimana"),
    GIOVEDI("Quasi al weekend"),
    VENERDI("Ultimo giorno lavorativo"),
    SABATO("Weekend!"),
    DOMENICA("Giorno di riposo");

    private final String descrizione;

    // Costruttore privato
    Giorno(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() { return descrizione; }

    public static void main(String[] args) {
        System.out.println(Giorno.DOMENICA.getDescrizione());
    }
}

enum Priority {
    BASSA(1), MEDIA(2), ALTA(3);

    private final int level;

    Priority(int level) { this.level = level; }

    public int getLevel() { return level; }

    public static Priority fromLevel(int level) {
        for (Priority p : Priority.values()) {
            if (p.getLevel() == level) return p;
        }
        throw new IllegalArgumentException("Livello non valido: " + level);
    }

    public static void main(String[] args) {
        // Accesso ai valori dell'enum
        Priority low = Priority.BASSA;
        Priority medium = Priority.MEDIA;
        Priority high = Priority.ALTA;

        // Ottenere un livello di priorità
        int level = medium.getLevel();  // Impostiamo il valore 2
        // Verifichiamo quale costante dell'enum corrisponde
        System.out.println("Livello impostato: " + Priority.fromLevel(level));
    }
}