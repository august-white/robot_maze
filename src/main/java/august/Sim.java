package august;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Objects;

public class Sim extends JPanel implements Runnable {
    private Robot robot;
    private InputHandler input;

    public Sim (){
        robot = new Robot();
        input = new InputHandler();
        JFrame frame = new JFrame("robot maze");
        frame.setSize(800, 800);
        frame.add(this);
        frame.addKeyListener(input);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        while (true){
            updateRobot();
            repaint();

            try { Thread.sleep(10); } catch (Exception ignored) {}
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);


        // Background field
        g.setColor(new Color(30, 30, 30));
        g.fillRect(0, 0, getWidth(), getHeight());

        Graphics2D g2 = (Graphics2D) g;

        // Draw center grid lines
        g2.setColor(new Color(60, 60, 60));
        for (int i = 0; i < getWidth(); i += 40) {
            g2.drawLine(i, 0, i, getHeight());
            g2.drawLine(0, i, getWidth(), i);
        }

        // Save transform
        g2.translate(robot.getX(), robot.getY());
        g2.rotate(Math.toRadians(robot.getHeading()));


        // Draw robot body
        g2.setColor(Color.CYAN);
        g2.fillRect(
                -robot.getWidth() / 2,
                -robot.getHeight() / 2,
                robot.getWidth(),
                robot.getHeight()
        );

        // Robot front indicator
        g2.setColor(Color.BLUE);
        g2.fillRect(-5, -robot.getHeight() / 2, 10, 15);

        g2.setTransform(new AffineTransform());
    }

    private void updateRobot(){
        if (input.forward) {
            robot.moveForward();
//            robot.getDetails();
        } else if (input.left) {
            robot.turnLeft();
//            robot.getDetails();
        } else if (input.backward) {
            robot.moveBack();
//            robot.getDetails();
        } else if (input.right) {
            robot.turnRight();
//            robot.getDetails();
        }

    }
}
