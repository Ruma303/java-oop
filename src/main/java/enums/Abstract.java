package enums;

public enum Abstract {

    SOMMA {
        public double esegui(double x, double y) {
            return x + y;
        }
    },
    SOTTRAZIONE {
        public double esegui(double x, double y) {
            return x - y;
        }
    },
    MOLTIPLICAZIONE {
        public double esegui(double x, double y) {
            return x * y;
        }
    },
    DIVISIONE {
        public double esegui(double x, double y) {
            if (y == 0) throw new ArithmeticException("Divisione per zero");
            return x / y;
        }
    };

    public abstract double esegui(double x, double y);

    public static void main(String[] args) {
        double a = 10;
        double b = 5;

        System.out.println("Somma: " + Abstract.valueOf("SOMMA").esegui(a, b));
        System.out.println("Sottrazione: " + Abstract.SOTTRAZIONE.esegui(a, b));
        System.out.println("Moltiplicazione: " + Abstract.MOLTIPLICAZIONE.esegui(a, b));
        System.out.println("Divisione: " + Abstract.DIVISIONE.esegui(a, b));
    }
}
