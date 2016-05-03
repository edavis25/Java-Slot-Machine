import greenfoot.*;

/**
 * Does nothing other than add the 2 arrow buttons for increasing/decreasing bet amount. 
 * 
 * @author Eric Davis
 * @version 1.0
 */
public class BetChange extends Actor
{
    GreenfootImage increaseArrow;
    GreenfootImage decreaseArrow;
    public BetChange(String type)
    {
        if (type.equals("increase"))
        {
            increaseArrow = new GreenfootImage("images/arrow-increase.png");
            setImage(increaseArrow);
        }
        else
        {
            decreaseArrow = new GreenfootImage("images/arrow-decrease.png");
            setImage(decreaseArrow);
        }
    }
    
    
    /**
     * Act - do whatever the BetChange wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
    }    
}
