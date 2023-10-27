package q3_LucasComaru;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BrightnessAdjustment {
    public static void main(String[] args) {
        try {
            BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\lucas\\eclipse-workspace\\AV2_LucasComaru\\src\\q3_LucasComaru\\bobesponja.jpg"));

            double brightnessFactor = 1.5;

            BufferedImage brightenedImage = adjustBrightness(originalImage, brightnessFactor);

            File outputImageFile = new File("C:\\Users\\lucas\\eclipse-workspace\\AV2_LucasComaru\\src\\q3_LucasComaru\\bobesponja_brightened.jpg");
            ImageIO.write(brightenedImage, "jpg", outputImageFile);

            System.out.println("Imagem ajustada com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao processar a imagem: " + e.getMessage());
        }
    }

    public static BufferedImage adjustBrightness(BufferedImage image, double factor) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage adjustedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);

                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                red = (int) (red * factor);
                green = (int) (green * factor);
                blue = (int) (blue * factor);

                red = Math.min(255, Math.max(0, red));
                green = Math.min(255, Math.max(0, green));
                blue = Math.min(255, Math.max(0, blue));

                int adjustedRGB = (red << 16) | (green << 8) | blue;

                adjustedImage.setRGB(x, y, adjustedRGB);
            }
        }

        return adjustedImage;
    }
}
