package interfaces;

public class Nested {
    public static void main(String[] args) {
        // Interfacce nelle classi
        Gestore gest = new Gestore();
        gest.onEvento();

        // Nested Interfaces
        Smartphone smartphone = new Smartphone();
        smartphone.accendi();

        Configuratore configuratore = new Configuratore();
        configuratore.applica();
    }
}

class Contenitore {
    interface Listener {
        void onEvento();
    }
}

class Gestore implements Contenitore.Listener {
    @Override
    public void onEvento() {
        System.out.println("Evento gestito");
    }
}

interface Dispositivo {
    void accendi();

    // Interfaccia annidata - Automaticamente public static
    interface Configurazione {
        void applica();
    }
}

class Smartphone implements Dispositivo {
    @Override
    public void accendi() {
        System.out.println("Smartphone acceso");
    }
}

class Configuratore implements Dispositivo.Configurazione {
    @Override
    public void applica() {
        System.out.println("Configurazione applicata");
    }
}

