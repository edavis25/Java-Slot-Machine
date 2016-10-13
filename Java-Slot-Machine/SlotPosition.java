import greenfoot.*;

/**
 * SlotPosition class holds info and action methods for the 3 spinning slot icons. 
 * 
 * @author Eric Davis 
 * @version 1.0
 */
public class SlotPosition extends Actor
{
    
    public GreenfootImage[] images = new GreenfootImage[8];
    
    public int slotPosition;
    
    private int imageCounter;
    
    private boolean animationFinished;
        
    int animationIndex = 0;
    
    private int location;
    
    /**
     * Main constructor- locationArg should be only 1, 2, or 3. This relates to the position on the
     *                   slot machine. 1 = left, 2 = center, 3 = right. 
     *                   This value is used to time up the animation with the sound bite by making 
     *                   the positions stop spinning one at a time starting with the left one.
     */
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
    
    /**
     * SlotPosition constructor for beginning state of the positions upon very first startup.
     */
    public SlotPosition()
    {
        images[0] = new GreenfootImage("images/grape.png");
                
        setImage(images[0]); 
   
        animationFinished = true;
    }
    
    /**
     * Act - If the animation flag is false, the slot position should be spinning. Otherwise display
     *       a static image determined by the current position.
     */
    public void act() 
    {
        if (animationFinished == false)
        {
            animate();
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
    
    /**
     * animat() - Animates the slot counter by flipping through each icon in the array. The imagecounter
     *            increments each execution and is used to determine when to switch to the next fruit
     *            image in the array (every 5 milliseconds). The animation index is used to cycle thru
     *            the different images, and once reaching last image in array, reset to 0 and start over.
     */
    public void animate()
    {
        MyWorld world = (MyWorld)getWorld();
        
        if (imageCounter % 5 == 0)
        {
            setImage(images[animationIndex]);
            animationIndex++;
            
            if (animationIndex >= images.length)
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
