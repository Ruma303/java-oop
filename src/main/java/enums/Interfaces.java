package enums;

interface Convertibile {
    double converti(double celsius);
}

enum Temperatura implements Convertibile {
    FAHRENHEIT {
        @Override
        public double converti(double celsius) {
            return celsius * 9 / 5 + 32;
        }
    },
    KELVIN {
        @Override
        public double converti(double celsius) {
            return celsius + 273.15;
        }
    };

    public abstract double converti(double celsius);
}

public class Interfaces {
    public static void main(String[] args) {
        double celsius = 25;

        for (Temperatura t : Temperatura.values()) {
            System.out.println(t + ": " + t.converti(celsius));
        }
    }
}
