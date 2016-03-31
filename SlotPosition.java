import greenfoot.*;

/**
 * Write a description of class SlotPosition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlotPosition extends Actor
{
    
    public GreenfootImage[] images = new GreenfootImage[8];
    
    public int slotPosition;
    
    private int imageCounter;
    
    private boolean animationFinished;
        
    int animationIndex = 0;
    
    private int location;
    
    // Main constructor. locationArg should be only 1, 2, or 3. This relates to the
    // position on the slot machine. 1 = left, 2 = center, 3 = right. This value
    // is used to time up the animation with the sound bite by making the positions
    // stop spinning one at a time starting with the left one.
    public SlotPosition(int locationArg)
    {
        images[0] = new GreenfootImage("images/grape.png");
        images[1] = new GreenfootImage("images/lemon.png");
        images[2] = new GreenfootImage("images/apple.png");
        images[3] = new GreenfootImage("images/banana.png");
        images[4] = new GreenfootImage("images/cherry.png");
        images[5] = new GreenfootImage("images/orange.png");
        images[6] = new GreenfootImage("images/watermelon.png");
        images[7] = new GreenfootImage("images/bar.png");

        imageCounter = 0;
        
        setImage(images[0]); 
        
        slotPosition = Greenfoot.getRandomNumber(8);
        
        location = locationArg;
        
        animationFinished = false;
    }
    
    public SlotPosition()
    {
        images[0] = new GreenfootImage("images/grape.png");
                
        setImage(images[0]); 
        //slotPosition = Greenfoot.getRandomNumber(3);
   
        animationFinished = true;
    }
    
    /**
     * Act - do whatever the SlotPosition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (animationFinished == false)
        {
            animateREDO();
          
        }
        else
        {
            setImage(images[slotPosition]);
        }
    }
    
    
    public void setAnimationFlag(boolean parameter)
    {
        animationFinished = parameter;
    }
    

    public boolean animationFinished()
    {
        return animationFinished;   
    }

    
    public int getSlotPosition()
    {
        return slotPosition;
    }
    
    public void removeThis()
    {
        MyWorld world = (MyWorld)getWorld();
        world.removeObject(this);
    }
    
    public void animateREDO()
    {
        MyWorld world = (MyWorld)getWorld();
        
        if (imageCounter % 5 == 0)
        {
            setImage(images[animationIndex]);
            animationIndex++;
            
            if (animationIndex > 7)
            {
                animationIndex = 0;
            }
        }
        
        
        // This random formula is just for timing up with the slot spinning sound bite.
        if (imageCounter == 135 + (location * 21 ))
        {
            animationFinished = true;
        }
        
        imageCounter++;
        
    }
     
}
