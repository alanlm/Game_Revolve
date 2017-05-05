
package revolve;

import java.awt.Color;
import javax.swing.* ; 

public class Revolve 
{
    public static JFrame f ; // global variable that can be accessed from other classes

    public static void main(String[] args) 
    {        
        f = new JFrame("Revolve") ; 
        f.setSize(900, 700);
        f.setBackground(Color.WHITE);
        /**
         * adding panel to frame
         * you can switch this between menu panel and game panel 
         */
        f.add(new GamePanel()) ; 
        /**
         * when you close the frame it will stop the runtime 
         * you can change this to something different if you like 
         */
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setVisible(true); // needed so the frame can appear 
    } // end of main 
    
} // end of Revolve project 
