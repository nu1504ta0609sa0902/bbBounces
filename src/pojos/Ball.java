package pojos;

import components.MainFrame;

import java.awt.*;

/**
 * Created by tayyibah on 27/09/2018.
 */
public class Ball {
    public int width = 20;
    public int height= 20;
    public int xPos = 0;
    public int yPos = 0;
    public double xDir=0.75;
    public double yDir=0.65;
    public Color color = Color.BLACK;

    public Ball(boolean random) {
        if(random){

        }
    }

    public Ball(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        xDir = Math.random();
        yDir = Math.random();

        double smaller = 1 + xDir;
        if(yDir < xDir){
            smaller = 1 + yDir;
        }

        double larger = 1 + xDir;
        if(yDir > xDir){
            larger = 1 + yDir;
        }

        double use = larger;
        width = (int)(width * use);
        height = (int)(height * use);
        color = new Color(getRandomVal(), getRandomVal(), getRandomVal());

    }

    private int getRandomVal() {
        return (int)(Math.random() * 255);
    }

    public void update(){

        if(xPos > MainFrame.WIDTH - 10){
            xDir = -xDir;
        }else if(xPos + 10 < 0){
            xDir = -1 * xDir;
        }

        if(yPos > MainFrame.HEIGHT - 10){
            yDir = -yDir;
        }else if(yPos + 10 < 0){
            yDir = -1 * yDir;
        }

        xPos = (int)(xPos + 10 * xDir);
        yPos = (int)(yPos + 10 * yDir);
    }

    public void collided(){
        if(xDir > 0){
            xDir = -xDir;
        }else{
            xDir = -1 * xDir;
        }

        if(yDir > 0){
            yDir = -yDir;
        }else {
            yDir = -1 * yDir;
        }
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(xPos, yPos, width, height);
        //g.drawOval(xPos, yPos, width, height);
    }

    public Rectangle getRectangle(){
        return new Rectangle(xPos, yPos, width, height);
    }
}
