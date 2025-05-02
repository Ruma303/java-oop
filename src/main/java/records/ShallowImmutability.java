package records;

import java.util.Random;

public class ShallowImmutability {
    public static void main(String[] args) {
        MyRandom mr1 = new MyRandom();
        Persona p1 = new Persona("Alice", 30, mr1);
        System.out.println("Primo numero casuale:" + p1.rand().getValore());

        mr1.setValore();
        System.out.println("Aggiornamento numero casuale: " + p1.rand().getValore());

        mr1.setValore();
        System.out.println("Aggiornamento numero casuale: " + p1.rand().getValore());

    }
}

record Persona(String name, int age, MyRandom rand) {
//    void setValore(MyRandom rand) {
//        rand.setValore();
//    }
//
//    int getValore(MyRandom rand) {
//        this.rand = rand; // Errore
//    }
}

class MyRandom {
    private int valore = 0;
    private Random r = new Random();

    public void setValore() {
        valore = r.nextInt(50);
    }

    public int getValore() {
        return valore;
    }
}