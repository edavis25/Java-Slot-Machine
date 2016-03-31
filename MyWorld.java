import greenfoot.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    SlotPosition referencePosition = new SlotPosition();
        
    SlotPosition slotPosition1;
    SlotPosition slotPosition2;
    SlotPosition slotPosition3;
    
    SpinButton spinButton;
    
    Bankroll bankroll;
    
    private boolean running;
        
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        
        // Create and add spin button
        spinButton = new SpinButton();
        addObject(spinButton, 300, 560);
        
        // Add still slot position images with alternate constructor.
        slotPosition1 = new SlotPosition();
        slotPosition2 = new SlotPosition();
        slotPosition3 = new SlotPosition();
        addObject(slotPosition1, 155, 385);
        addObject(slotPosition2, 300, 385);
        addObject(slotPosition3, 445, 385);
        
        // Create and add bankroll label
        bankroll = new Bankroll();
        addObject(bankroll, 500, 580);
        
        running = false;
        
    }
    
    
    public void act()
    {
        if (Greenfoot.mousePressed(spinButton) && running == false)
        {
            spinButton.setImage("images/button-red.png");
            
            addItems();
            
            bankroll.adjustBankroll(-5);
            
            GreenfootSound slotSpinning = new GreenfootSound("sounds/slotSpinning.wav");
            slotSpinning.setVolume(100);
            
            //if (slotSpinning.isPlaying() == false)
            //{   
                slotSpinning.play();
            //}
            
            running = true;
        }
        
        if (slotPosition1.animationFinished() && running == true)
        {
                        
            checkWin();
            spinButton.setImage("images/button-green.png");
            running = false;
        }
        
    }
    
    private void checkWin()
    {
       GreenfootSound chaChing = new GreenfootSound("sounds/chaChing.wav");
        
       chaChing.setVolume(100);
       
       // Check 2 of a kind
       if ( (slotPosition1.getSlotPosition() == slotPosition2.getSlotPosition() ) || ( slotPosition1.getSlotPosition() == slotPosition3.getSlotPosition() ) || (slotPosition2.getSlotPosition() == slotPosition3.getSlotPosition() ) )
       {
           //Check for 3 of a kind
           if ( slotPosition1.getSlotPosition() == slotPosition2.getSlotPosition() && slotPosition1.getSlotPosition() == slotPosition3.getSlotPosition() )
           {
                bankroll.adjustBankroll(25);
                chaChing.play();
           }
           else
           {
                bankroll.adjustBankroll(10);
                chaChing.play();
           }
       }
    }
    
    
    private void addItems()
    {
        removeObject(slotPosition1);
        removeObject(slotPosition2);
        removeObject(slotPosition3);
        
        slotPosition1 = new SlotPosition(1);
        slotPosition2 = new SlotPosition(2);
        slotPosition3 = new SlotPosition(3);
        
        addObject(slotPosition1, 155, 385);
        addObject(slotPosition2, 300, 385);
        addObject(slotPosition3, 445, 385);
        
        
    }
    
    
}
