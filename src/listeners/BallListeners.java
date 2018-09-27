package listeners;

import components.MainFrame;
import pojos.Ball;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tayyibah on 27/09/2018.
 */
public class BallListeners implements ActionListener, MouseListener{

    List<Ball> lob = new ArrayList<Ball>();

    public BallListeners(List<Ball> lob) {
        this.lob = lob;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(lob.size() < MainFrame.TOTAL_NUMBER_OF_BALLS) {
            Ball ball = new Ball(e.getX(), e.getY());
            lob.add(ball);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
