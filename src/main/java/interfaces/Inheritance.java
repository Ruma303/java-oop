package interfaces;

public class Inheritance {

    public static void main(String[] args) {
        // Ereditarietà delle interfacce
        ImplementingClass obj = new ImplementingClass();
        obj.methodOne(); // Output: Implementazione di methodOne
        obj.methodTwo(); // Output: Implementazione di methodTwo

        obj.defaultMethod(); // Output: Implementazione del metodo di default


        MyClass myClass = new MyClass();
        myClass.defaultMethod();
    }
}

// Interfaccia base
interface BaseInterface {
    void methodOne();

    default void defaultMethod() {
        System.out.println("Metodo di default dell'interfaccia base");
    }
}

// Interfaccia derivata
interface DerivedInterface extends BaseInterface {
    void methodTwo();

    @Override
    default void defaultMethod() {
        System.out.println("Metodo di default dell'interfaccia derivata");
    }
}

// Classe che implementa l'interfaccia derivata
class ImplementingClass implements DerivedInterface {
    @Override
    public void methodOne() {
        System.out.println("Implementazione di methodOne");
    }

    @Override
    public void methodTwo() {
        System.out.println("Implementazione di methodTwo");
    }

    @Override
    public void defaultMethod() {
        DerivedInterface.super.defaultMethod(); // Chiamata al metodo di default dell'interfaccia derivata
        System.out.println("Nuova implementazione del metodo di default in ImplementingClass");
    }
}

interface InterfaceWithPrivate {
    private void helperMethod() {
        System.out.println("Metodo privato");
    }

    default void defaultMethod() {
        helperMethod();
        System.out.println("Metodo di default");
    }
}

class MyClass implements InterfaceWithPrivate {
    @Override
    public void defaultMethod() {
        InterfaceWithPrivate.super.defaultMethod(); // Chiamata al metodo di default dell'interfaccia
        System.out.println("Nuova implementazione del metodo di default in MyClass");
    }
}


