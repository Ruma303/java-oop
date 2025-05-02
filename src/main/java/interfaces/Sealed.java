package interfaces;

public class Sealed {
    public static void main(String[] args) {
        // Esempio di utilizzo delle classi e interfacce
        Vehicle car = new Car();
        car.start();
        car.stop();

        Vehicle truck = new Truck();
        truck.start();
        truck.stop();

        Vehicle motorcycle = new Motorcycle();
        motorcycle.start();
        motorcycle.stop();

        // Esempio con Pattern Matching
        VehicleProcessor vp = new VehicleProcessor();
        Vehicle vehicle = new Car();
        vp.processVehicle(vehicle);

        // Nested Interfaces

    }
}

sealed interface InterfaceName permits Class1, Class2 {
    // Metodi dell'interfaccia
}

sealed class Class1 implements InterfaceName permits Class2 {
    // Implementazione dei metodi dell'interfaccia
}

non-sealed class Class2 extends Class1 implements InterfaceName {
    // Implementazione dei metodi dell'interfaccia
}


sealed interface Vehicle permits Car, Truck, Motorcycle {
    void start();

    void stop();
}

final class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}

final class Truck implements Vehicle {
    @Override
    public void start() {
        System.out.println("Truck started");
    }

    @Override
    public void stop() {
        System.out.println("Truck stopped");
    }
}

final class Motorcycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle started");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle stopped");
    }
}

class VehicleProcessor {
    public void processVehicle(Vehicle vehicle) {
        switch (vehicle) {
            case Car car -> System.out.println("Processing a car");
            case Truck truck -> System.out.println("Processing a truck");
            case Motorcycle motorcycle -> System.out.println("Processing a motorcycle");
            default -> throw new IllegalStateException("Unexpected value: " + vehicle);
        }
    }
}


// Interfacce innestate