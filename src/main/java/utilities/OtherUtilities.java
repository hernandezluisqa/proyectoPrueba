package utilities;

public class OtherUtilities {
    public static void sleep(int time_ms){
        try {
            Thread.sleep(time_ms); // pausa 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace(); // o manejo personalizado
        }
    }
}
