
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class BouncingBall extends JPanel implements MouseListener {

    private static final int BALL_DIAMETER = 40;
    private static final int BALL_SPEED = 2;
    private static final Color[] COLORS = new Color[]{Color.green, Color.black, Color.yellow, Color.white, Color.magenta, Color.red};

    private int ballX, ballY;
    private int ballXSpeed, ballYSpeed;

    public BouncingBall() {
        this(100, 100);
    }

    public BouncingBall(int ballX, int ballY) 
    {
        this.ballX = ballX;
        this.ballY = ballY;
        this.ballXSpeed = BALL_SPEED;
        this.ballYSpeed = -BALL_SPEED;

        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.blue);
        setForeground(Color.yellow);

        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.fillOval(ballX, ballY, BALL_DIAMETER, BALL_DIAMETER);
        g.drawString("ballX = " + ballX + " ballY = " + ballY, 10, 30);
    }

    public void mouseClicked(MouseEvent e) 
    {
        int width = getWidth();
        int height = getHeight();
        Random rand = new Random();

        Thread thread = new Thread(new Runnable() 
        {
            public void run() 
            {
                while (true) 
                {
                    SwingUtilities.invokeLater(new Runnable() 
                    {
                        
                        public void run() 
                        {
                            ballX += ballXSpeed;
                            ballY += ballYSpeed;

                            if (ballX < 0) 
                            {
                                ballX = 0;
                                ballXSpeed = BALL_SPEED;
                                setForeground(COLORS[rand.nextInt(6)]);
                            } 
                            else if (ballX > width - BALL_DIAMETER) 
                            {
                                ballX = width - BALL_DIAMETER;
                                ballXSpeed = -BALL_SPEED;
                                setForeground(COLORS[rand.nextInt(6)]);
                            }

                            if (ballY < 0) 
                            {
                                ballY = 0;
                                ballYSpeed = BALL_SPEED;
                                setForeground(COLORS[rand.nextInt(6)]);
                            } 
                            else if (ballY > height - BALL_DIAMETER) 
                            {
                                ballY = height - BALL_DIAMETER;
                                ballYSpeed = -BALL_SPEED;
                                setForeground(COLORS[rand.nextInt(6)]);
                            }

                            repaint();
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) { }
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

}
