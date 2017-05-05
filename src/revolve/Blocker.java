
package revolve;

import java.awt.* ; 
import javax.swing.* ; 

public class Blocker 
{
    private ImageIcon block; 
    private int xCoord, yCoord ;
            
    public Blocker(String s, int x, int y)
    {
        block = new ImageIcon(s) ; 
        xCoord = x ; 
        yCoord = y ; 
    } // end of Blocker constructor 
    
    public void setX(int x)
    {
        xCoord = x ; 
    } // end of setX method 
    
    public void setY(int y)
    {
        yCoord = y ; 
    } // end of setY method 
    
    public int getX()
    {
        return xCoord ; 
    } // end of getX method 
    
    public int getY()
    {
        return yCoord ; 
    } // end of setY method 
    
    public void paintComponent(Graphics g)
    {
        block.paintIcon(null, g, xCoord, yCoord);
    } // end of paintComponent method 
} // end of Blocker class 
