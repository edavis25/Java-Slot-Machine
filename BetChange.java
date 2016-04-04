import greenfoot.*;

/**
 * Write a description of class BetChange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
