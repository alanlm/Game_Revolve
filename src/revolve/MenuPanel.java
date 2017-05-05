
package revolve;

import javax.swing.* ; 
import java.awt.* ; 
import java.awt.event.* ; 

/**
 * this class deals with the start menu of game 
 * extends is a reserve word that indicates the use of inheritance 
 * therefore MenuPanel is a subclass of the JPanel class
*/
public class MenuPanel extends JPanel
{
    private JButton start, help ; 
    private ImageIcon background ; 
    private ButtonListener buttonL = new ButtonListener() ; 
    
    public MenuPanel()
    {
        // creating buttons 
        start = new JButton("Start Game") ; 
        help = new JButton("Help") ; 
        // attaching a listener to buttons
        start.addActionListener(buttonL);
        help.addActionListener(buttonL);
        
        // adding buttons to panel 
        add(start) ; 
        add(help) ;
    } // end of menu panel constructor 
    
    // this method paints images 
    public void paintComponent(Graphics page)
    {
        background = new ImageIcon("background.png") ; 
        background.paintIcon(this, page, 0, 0);
    } // end of paint component method 
    
    /**
     * the following code is a listener class 
     * (and also an inner class because its a class within a class) 
     * implements is a reserve word that indicates an interface
     * When an event occurs such as mouse clicked or key is pressed 
     * it must be attached to a listener or nothing will happen 
     * once the event occurs then it will go to the appropriate listener 
     * and execute the following code 
     */
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String source = event.getActionCommand() ; 
            
            /**
             * when you click the buttons 
             * it will execute the appropriate if statement 
             * there are probably other ways to do this 
             * but this is the only way i know 
             */
            if(source.equals("Start Game"))
                ; 
            if(source.equals("Help"))
                ; 
        } // end of action performed method 
    } // end of listener class 
    
} // end of menu panel class 
