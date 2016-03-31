import greenfoot.*;

/**
 * Write a description of class SpinButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
