package enums;

import java.util.Scanner;

// Uso negli switch
enum TrafficLights {
    RED, YELLOW, GREEN
}

public class Switch {
    static void getTrafficLight(TrafficLights light) {

        switch (light) {
            case RED:
                System.out.println("STOP");
                break;

            case YELLOW:
                System.out.println("READY");
                break;

            case GREEN:
                System.out.println("GO");
                break;
        }
    }

    public static void main(String[] args) {
        TrafficLights light = TrafficLights.YELLOW;
        getTrafficLight(light);
    }
}

