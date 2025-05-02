package records;

public class MyRecord {
    public static void main(String[] args) {

        // Creazione di un'istanza del record
        Person person = new Person("Alice", 30);

        // Accesso ai campi con metodi getter
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());

        // Uso del metodo toString
        System.out.println(person);

        // Confronto tra record
        Person anotherPerson = new Person("Alice", 30);
        System.out.println("Equal: " + person.equals(anotherPerson));

        // Logica interna del record
        Person child = new Person("Bob");  // Costruttore alternativo, lancerà un'eccezione
        System.out.println("Child: " + child.greet());


    }
}

// record Person(String name, int age) {}

record Person(String name, int age) implements Comparable<Person> {

    public static final String DEFAULT_NAME = "Unknown";

    // Costruttore canonico
    public Person {
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    // Costruttore secondario
    public Person(String name) {
        this(name, 0); // Assegna 0 come valore predefinito per l'età
    }

    // Metodo interno
    public String greet() {
        return "Hello, my name is " + name + " and I am " + age + " years old.";
    }

    // Implementazione del metodo compareTo
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}