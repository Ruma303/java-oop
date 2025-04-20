package enums;

enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

public class Enums {
    public static void main(String[] args) {

        // Metodi nativi di Enum<T>
        System.out.println(Day.MONDAY.name()); // Restituisce nome letterale della costante
        System.out.println(Day.FRIDAY.ordinal()); // Restituisce la posizione (indice) della costante
        System.out.println(Day.valueOf("SUNDAY")); // converte una stringa nel valore enum corrispondente

        System.out.println("\nTutti i giorni:");
        for (Day d : Day.values()) {
            System.out.println(d.ordinal() + ". " + d.name()); // Restituisce un array con tutti i valori dichiarati nell’enumerazione,
            // identico di `toString()`.
        }
    }
}
