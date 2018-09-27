package components;

import listeners.BallListeners;
import pojos.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tayyibah on 27/09/2018.
 */
public class GamePanel extends JPanel implements Runnable{

    //Graphics
    private boolean running;
    private BufferedImage image;
    private Graphics2D g;

    //Listeners
    BallListeners listeners;

    //List of balls
    List<Ball> lob;

    public GamePanel() {
        init();
    }

    private void init() {
        running = true;

        //BufferedImage and Graphics2D
        image = new BufferedImage(MainFrame.WIDTH, MainFrame.HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Initialise list of balls
        Ball ball = new Ball(false);
        lob = new ArrayList<Ball>();
        lob.add(ball);

        //Add listener
        listeners = new BallListeners(lob);
        addMouseListener(listeners);

    }

    @Override
    public void run() {

        while (running){

            //update
            update();

            //draw
            draw();

            //Display - repaint
            repaint();

            //Add a delay
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void draw() {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
        try {
            for (Ball ball : lob) {
                ball.draw(g);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void update() {
        for(Ball ball: lob){
            ball.update();
        }

        checkForCollisions();


    }

    private void checkForCollisions() {
        Object[] objects = lob.toArray();

        for(int i = 0; i < objects.length; i++){
            Ball ballToCompare = (Ball) objects[i];
            for(int j = 0; j < objects.length; j++){
                Ball compareAgainst = (Ball) objects[j];

                if(ballToCompare != compareAgainst){
                    //Add collision stuff
                    if(ballToCompare.getRectangle().intersects(compareAgainst.getRectangle())){
                        ballToCompare.collided();
                        compareAgainst.collided();
                        ballToCompare.update();
                        compareAgainst.update();
                    }
                }
            }
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Repaint whats in buffered image
        g2.drawImage(image, 0, 0, MainFrame.WIDTH, MainFrame.HEIGHT, null);

        g2.dispose();
    }
}
