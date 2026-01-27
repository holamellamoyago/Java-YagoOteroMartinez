import java.awt.*;
import java.awt.image.BufferedImage;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class CapturaTexto {
    public static void main(String[] args) throws AWTException{
        // 1. Definimos la región que queremos capturar (x, y, ancho, alto)
        Rectangle rectangle = new Rectangle(120, 300, 500, 150);

        Robot robot = new Robot();
        BufferedImage imagen = robot.createScreenCapture(rectangle);

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\tessdata");

        tesseract.setLanguage("spa"); // "spa" para español, "eng" inglés, "spa+eng" ambos

        // Opcional: mejorar precisión
        tesseract.setPageSegMode(7); // 7 = tratar como una sola línea de texto
        tesseract.setVariable("tessedit_char_whitelist",
                "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .,;:-_!¡¿?áéíóúÁÉÍÓÚñÑ");

        // 4. Extraemos el texto
        String texto;
        try {
            texto = tesseract.doOCR(imagen);
            System.out.println("Texto detectado:");
            System.out.println("-----------------");
            System.out.println(texto.trim());
        } catch (TesseractException e) {
            
            e.printStackTrace();
        }

    }
}
