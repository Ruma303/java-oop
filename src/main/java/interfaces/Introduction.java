package interfaces;

public class Introduction {
    public static void main(String[] args) {
        // Interfaccia Operazione
        Operazione somma = new Somma();
        Operazione moltiplicazione = new Moltiplicazione();

        System.out.println("Somma: " + somma.calcola(5, 3)); // Output: 8
        System.out.println("Moltiplicazione: " + moltiplicazione.calcola(5, 3)); // Output: 15

        // Esecuzione del thread
        Runnable runnable = new Somma();
        runnable.run(); // Output: Esecuzione del thread

        // Ereditarietà e polimorfismo con classe abstract
        Shape myShape = new Circle();
        myShape.draw();
        myShape.color();

        Circle circle = new Circle();
        circle.area();
        System.out.println("Circle: " + circle.area());

        // Default e static
        Veicolo v = new Auto();
        v.avvia();            // Override del metodo di default
        v.info();             // Implementazione metodo standard
        Veicolo.manutenzione(); // Metodo statico dell'interfaccia
    }
}

interface Operazione {
    int calcola(int a, int b); // metodo astratto

    // Costante
    double PI = 3.14159; // equivalente a: public static final double PI = 3.14159;
}

interface Runnable {
    void run(); // metodo astratto
}

class Somma implements Operazione, Runnable { // Lista di interfacce
    @Override
    public int calcola(int a, int b) {
        return a + b;
    }

    @Override
    public void run() {
        System.out.println("Esecuzione del thread");
    }
}

class Moltiplicazione implements Operazione {
    @Override
    public int calcola(int a, int b) {
        return a * b;
    }
}


abstract class Shape {
    abstract void draw();  // Metodo astratto

    // Metodo concreto
    public void color() {
        System.out.println("Coloring the shape");
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }

    public Double area() {
        return Operazione.PI * 2 * 2; // Area del cerchio
    }
}


interface Veicolo {
    void avvia();

    default void info() {
        System.out.println("Veicolo generico");
    }

    static void manutenzione() {
        System.out.println("Controllo generale del veicolo");
    }
}

class Auto implements Veicolo {
    @Override
    public void avvia() {
        System.out.println("Avvio motore dell’auto");
    }

    @Override
    public void info() {
        System.out.println("Auto a benzina");
    }
}