import greenfoot.*;

/**
 * SpinButton is boring, has 2 states: green = ready and red = occupied. 
 * 
 * @author Eric Davis
 * @version 1.0
 */
public class SpinButton extends Actor
{
    public GreenfootImage buttonEnabled;
    public GreenfootImage buttonDisabled;
    
    public SpinButton()
    {
        buttonEnabled = new GreenfootImage("images/button-green.png");
        buttonDisabled = new GreenfootImage("images/button-red.png");
        
        setImage(buttonEnabled);
    }
    
    
    /**
     * Act - do whatever the SpinButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
