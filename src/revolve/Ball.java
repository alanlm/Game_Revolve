
package revolve;

import javax.swing.* ; 
import java.awt.* ; 
import java.util.Random ; 

public class Ball 
{
    private ImageIcon ball ; 
    private int xCoord, yCoord ; 
    private final int centerX=415, centerY=300 ; 
    private int radius ; 
    private double theta ; 
    private Random r = new Random() ; 
    
    
    public Ball(String s)
    {
        ball = new ImageIcon(s) ; 
    } // end of Ball constructor 
    
    public void setRandomCoordinates(int speed)
    {
        theta = r.nextDouble()*r.nextInt((int)(2*Math.PI)) ; 
        radius = r.nextInt(600*speed)+601 ; 
        xCoord = (int)(centerX + Math.cos(theta)*radius); 
        yCoord = (int)(centerY + Math.sin(theta)*radius) ; 
    } // end of newCoordinates method 
    
    public void Move(int rad)
    {
        radius -= rad ; 
        xCoord = (int)(centerX + Math.cos(theta)*radius); 
        yCoord = (int)(centerY + Math.sin(theta)*radius) ; 
    } // end of Move method 
    
    public int getRadius()
    {
        return radius ; 
    } // end of getRadius method 
    
    public int getX()
    {
        return xCoord ; 
    } // end of getX method 
    
    public int getY()
    {
        return yCoord ; 
    } // end of setY method 
    
    public int getWidth()
    {
        return ball.getIconWidth() ; 
    } // end of getWidth method 
    
    public int getHeight()
    {
        return ball.getIconHeight() ;
    } // end of getHeight method 
    
    public void paintComponent(Graphics g)
    {
        ball.paintIcon(null, g, xCoord, yCoord);
    } // end of paintComponent method 
} // end of Ball class 
