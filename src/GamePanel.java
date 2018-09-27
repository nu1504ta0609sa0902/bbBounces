import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by tayyibah on 27/09/2018.
 */
public class GamePanel extends JPanel {
    private boolean running;
    private BufferedImage image;
    private Graphics2D g;

    public GamePanel() {
        init();
    }

    private void init() {
        running = true;
        image = new BufferedImage(Main.WIDTH, Main.HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    }
}
