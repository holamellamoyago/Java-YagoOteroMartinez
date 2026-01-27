import java.awt.*;

public class CorrdenadasRaton {
    public static void main(String[] args) throws Exception {
        System.out.println("Mueve el ratón a las esquinas de la zona que quieres capturar...");
        System.out.println("Pulsa Ctrl+C cuando termines");
        while (true) {
            PointerInfo info = MouseInfo.getPointerInfo();
            Point p = info.getLocation();
            System.out.printf("X: %d  Y: %d%n", p.x, p.y);
            Thread.sleep(100);
        }
    }
}
