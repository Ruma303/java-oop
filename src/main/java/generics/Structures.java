package generics;

import java.util.*;
import java.util.function.Function;

// ENUM con comportamento generico
public enum Structures {

    CLASS {
        @Override
        public void execute() {
            Integer[] ints = {1, 2, 3};
            Double[] doubles = {1.5, 2.5, 3.5};

            System.out.println("Average of ints: " + MathUtils.average(ints));
            System.out.println("Average of doubles: " + MathUtils.average(doubles));

            Number result = MathUtils.divide(10, 2.0);
            System.out.println("Division result: " + result);

            Pair<Integer, String> pair = new Pair<>(1, "one");
            System.out.println("Pair: " + pair.key() + ", " + pair.value());
        }
    },

    METHODS {
        @Override
        public void execute() {
            double d;

            d = Methods.half(10.7);
            System.out.println("double: " + d);

            d = Methods.half(10);
            System.out.println("int:    " + d);

            d = Methods.half((byte) 60);
            System.out.println("byte:   " + d);

            System.out.println("max(3, 5): " + Methods.max(3, 5));
            System.out.println("min('z', 'a'): " + Methods.min('z', 'a'));
        }
    },

    INTERFACES {
        @Override
        public void execute() {
            MyInterface<Integer> doubler = val -> val * 2.0;
            MyInterface<Float> squarer = val -> Math.pow(val, 2);

            System.out.println("Doubler: " + doubler.doubleVal(10));
            System.out.println("Squarer: " + squarer.doubleVal(3.5f));
        }
    },

    GENERIC_BOX {
        @Override
        public void execute() {
            GenericBox<String> box = new GenericBox<>();
            box.set("Hello Generics");
            System.out.println("Box content: " + box.get());

            GenericBox<Integer> intBox = new GenericBox<>(42);
            System.out.println("IntBox: " + intBox.get());
        }
    },

    RECORD {
        @Override
        public void execute() {
            GenericRecord<String, Integer> record = new GenericRecord<>("Student", 2025);
            System.out.println("GenericRecord: " + record.key() + " → " + record.value());
        }
    },

    WILDCARDS {
        @Override
        public void execute() {
            List<? extends Number> numbers = List.of(1, 2, 3.5);
            printUpperBounded(numbers);

            List<Object> objects = new ArrayList<>();
            objects.add("String");
            objects.add(42);
            printLowerBounded(objects);

            List<Integer> ints = Arrays.asList(1, 2, 3);
            List<Double> doubles = Arrays.asList(1.1, 2.2);
            System.out.println("sum ints: " + WildcardUtils.sumOfList(ints));
            System.out.println("sum doubles: " + WildcardUtils.sumOfList(doubles));
        }

        private void printUpperBounded(List<? extends Number> list) {
            System.out.println("Upper-bounded List:");
            for (Number n : list) {
                System.out.println(" - " + n);
            }
        }

        private void printLowerBounded(List<? super Integer> list) {
            System.out.println("Lower-bounded List:");
            for (Object o : list) {
                System.out.println(" - " + o);
            }
        }
    };

    public abstract void execute();

    public static void main(String[] args) {
        for (Structures s : Structures.values()) {
            System.out.println("\n>> " + s.name());
            s.execute();
        }
    }
}

class MathUtils {
    public static <T extends Number> double average(T[] numbers) {
        double sum = 0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum / numbers.length;
    }

    public static <T extends Number, U extends Number> Number divide(T var1, U var2) {
        return var1.doubleValue() / var2.doubleValue();
    }
}

class Methods {
    static <T extends Number> double half(T t) {
        return t.doubleValue() / 2.0;
    }
    static <T extends Comparable<T>> T max(T a, T b) {
        return (a.compareTo(b) > 0) ? a : b;
    }
    static <T extends Comparable<T>> T min(T a, T b) {
        return (a.compareTo(b) < 0) ? a : b;
    }
}

@FunctionalInterface
interface MyInterface<T extends Number> {
    double doubleVal(T t);
}

class GenericBox<T> {
    private T content;
    public GenericBox() {}
    public GenericBox(T content) {
        this.content = content;
    }
    public void set(T content) {
        this.content = content;
    }
    public T get() {
        return content;
    }
}

record GenericRecord<K, V>(K key, V value) {
    public GenericRecord {
        Objects.requireNonNull(key, "Key cannot be null");
        Objects.requireNonNull(value, "Value cannot be null");
    }
}

record Pair<K, V>(K key, V value) {}

class WildcardUtils {
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
