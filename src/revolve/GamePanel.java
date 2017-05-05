
package revolve;

import java.awt.* ; 
import java.awt.event.* ; 
import javax.swing.* ; 
import java.util.Random ; 

/**
 * this class deals with the gaming components 
 * extends means inheritance 
 * gamePanel inherits everything JPanel contains 
 */
public class GamePanel extends JPanel
{
    private ImageIcon bg, centerB ;
    private Blocker[] block = new Blocker[4] ; 
    private Ball[] ball = new Ball[4] ; 
    private final int centerX = 410, centerY = 300 ; // center of frame approx.
    private double theta = 0, radius = 175 ; 
    Random r = new Random() ; 
    private Timer t ; 
    // you can manipulate the values if you want 
    
    public GamePanel()
    {   
        // setting up center ball and background 
        bg = new ImageIcon("bg.png") ; 
        centerB = new ImageIcon("centerBall.png") ; 
        
        // setting up the red barrier
        // should be positioned to the left of center 
        block[0] = new Blocker("redBall2.png", 
                (int)(centerX + Math.cos(theta+Math.PI)*radius), 
                (int)(centerY + Math.sin(theta+Math.PI)*radius)) ;
        
        // setting the blue barrier 
        // should be positioned to the right of center 
        block[1] = new Blocker("blueBall2.png", 
                (int)(centerX + Math.cos(theta)*radius), 
                (int)(centerY + Math.sin(theta)*radius)) ; 
        
        // setting up the green barrier
        // should be positioned above center 
        block[2] = new Blocker("greenBall2.png", 
                (int)(centerX + Math.cos(theta-Math.PI/2)*radius), 
                (int)(centerY + Math.sin(theta-Math.PI/2)*radius)) ; 
        
        // setting up the orange barrier 
        // should be positioned below center
        block[3] = new Blocker("orangeBall2.png", 
                (int)(centerX + Math.cos(theta-3*Math.PI/2)*radius), 
                (int)(centerY + Math.sin(theta-3*Math.PI/2)*radius)) ; 
        
        addKeyListener(new BlockerListener()) ; 
        t = new Timer(30, new BallListener()) ; 
        startGame() ; 
        setFocusable(true) ; // idk exactly what this does but without nothing moves 
    } // end of game panel constructor 
    
    // paintComponent places the image at desired location
    public void paintComponent(Graphics g)
    {
        bg.paintIcon(this, g, 0, 0);
        centerB.paintIcon(this, g, centerX, centerY);
        for(int i=0; i<4; i++)
        {
            block[i].paintComponent(g);
            ball[i].paintComponent(g);
        } // end of for loop 
    } // end of paint method 
    
    public void startGame()
    {
        // 0=red 1=blue 2=green 3=orange
        String[] ballName = {"redBall2.png", "blueBall2.png", "greenBall2.png", "orangeBall2.png",} ; 
        // setting up the balls outside of the screen 
        for(int i=0; i<4; i++)
        {
            ball[i] = new Ball(ballName[i]) ; 
            ball[i].setRandomCoordinates(1);
        } // end of for loop 
        
        t.start();
    } // end of startGame method 
    
    //**************************************************************************
    //----------------------- Blocker Listener ---------------------------------
    //**************************************************************************
    
    /**
     * this barrierListener is attached to the game panel constructor 
     * whenever the key
     * is pressed it sends a signal to the listener 
     * and does the appropriate code 
     * implements indicates an interface 
     */
    private class BlockerListener implements KeyListener
    {
        public void keyTyped(KeyEvent e) {}

        public void keyPressed(KeyEvent e) 
        {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_RIGHT:
                    // when the RIGHT ARROW key is pressed 
                    // the barrier should move clockwise 
                    theta += .1 ; 
                    // LEFT of center - RED
                    block[0].setX((int)(centerX + Math.cos(theta+Math.PI)*radius)) ; 
                    block[0].setY((int)(centerY + Math.sin(theta+Math.PI)*radius)) ; 
                    
                    // RIGHT of center - BLUE
                    block[1].setX((int)(centerX + Math.cos(theta)*radius)) ; 
                    block[1].setY((int)(centerY + Math.sin(theta)*radius)) ; 
                    
                    // ABOVE center - GREEN 
                    block[2].setX((int)(centerX + Math.cos(theta-Math.PI/2)*radius)) ; 
                    block[2].setY((int)(centerY + Math.sin(theta-Math.PI/2)*radius)) ; 
                    
                    // BELOW center - ORANGE
                    block[3].setX((int)(centerX + Math.cos(theta-3*Math.PI/2)*radius)) ; 
                    block[3].setY((int)(centerY + Math.sin(theta-3*Math.PI/2)*radius)) ; 
                    break ; 
                case KeyEvent.VK_LEFT: 
                    // this should make the barrier move counter-clockwise
                    // when the LEFT ARROW key is pressed 
                    theta -= .1 ; 
                    // LEFT of center - RED
                    block[0].setX((int)(centerX + Math.cos(theta+Math.PI)*radius)) ; 
                    block[0].setY((int)(centerY + Math.sin(theta+Math.PI)*radius)) ; 
                    
                    // RIGHT of center - BLUE
                    block[1].setX((int)(centerX + Math.cos(theta)*radius)) ; 
                    block[1].setY((int)(centerY + Math.sin(theta)*radius)) ; 
                    
                    // ABOVE center - GREEN 
                    block[2].setX((int)(centerX + Math.cos(theta-Math.PI/2)*radius)) ; 
                    block[2].setY((int)(centerY + Math.sin(theta-Math.PI/2)*radius)) ; 
                    
                    // BELOW center - ORANGE
                    block[3].setX((int)(centerX + Math.cos(theta-3*Math.PI/2)*radius)) ; 
                    block[3].setY((int)(centerY + Math.sin(theta-3*Math.PI/2)*radius)) ; 
                    break ; 
            } // end of switch 
            /**
             * repaint() will update the coordinates of image 
             * when calling repaint it will call paintComponent method 
             * with the new updated location
             * without this then the image will stay fixed 
             */
            repaint() ; 
        } // end of key pressed method 

        public void keyReleased(KeyEvent e) {}
        
    } // end of BlockerListener class
    
    //**************************************************************************
    //-------------------------- Ball Listener ---------------------------------
    //**************************************************************************
    
    /**
     * This BallListener class will be attached to the balls 
     * Once the ball reaches the center 
     * it will then reset its coordinates outside of screen 
     */
    private class BallListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            int offset = 3 ; 
            
            for(int i=0; i<4; i++)
            {
                ball[i].Move(r.nextInt(4)+2) ; 
                // if ball reaches the center black hole (-1 life) 
                if(ball[i].getRadius()<60)
                    ball[i].setRandomCoordinates(r.nextInt(4)+2);
                // if ball touches the same color blocker (+1 point)
                if( ball[i].getRadius()<249 // radius of blockers from center
                        // detects TOP LEFT corner of ball image
                        && ( block[i].getX()+offset < ball[i].getX()+offset && ball[i].getX()+offset < block[i].getX()+75-offset
                        && block[i].getY()+offset < ball[i].getY()+offset && ball[i].getY()+offset < block[i].getY()+72-offset ) 
                        // detects TOP RIGHT corner of ball image 
                        || ( block[i].getX()+offset < ball[i].getX()+75-offset && ball[i].getX()+75-offset < block[i].getX()+75-offset
                        && block[i].getY()+offset < ball[i].getY()+offset && ball[i].getY()+offset < block[i].getY()+72-offset ) 
                        // detects BOTTOM LEFT corner of ball image 
                        || ( block[i].getX()+offset < ball[i].getX()+offset && ball[i].getX()+offset < block[i].getX()+75-offset
                        && block[i].getY()+offset < ball[i].getY()+72-offset && ball[i].getY()+72-offset < block[i].getY()+72-offset ) 
                        // detects BOTTOM RIGHT corner of ball image 
                        || ( block[i].getX()+offset < ball[i].getX()+75-offset && ball[i].getX()+75-offset < block[i].getX()+75-offset
                        && block[i].getY()+offset < ball[i].getY()+72-offset && ball[i].getY()+72-offset < block[i].getY()+72-offset ) ) 
                    ball[i].setRandomCoordinates(r.nextInt(4)+2);
            } // end of for loop 
            // this for loop is when blockers touch the wrong color ball (-1 point) 
            /*for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                {
                    if( i==j )
                        j++ ; 
                } // end of inner for loop */
            repaint() ; 
        } // end of actionPerformed method 
    } // end of BallListener class 
    
} // end of game panel class 
