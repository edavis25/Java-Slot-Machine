import greenfoot.*;

/**
 * Most of the execution happens here. Create the background and all the objects to be used. Handles
 * 
 *
 * 
 * @author Eric Davis
 * @version 1.0
 */
public class MyWorld extends World
{
    
    SlotPosition referencePosition = new SlotPosition();
        
    SlotPosition slotPosition1;
    SlotPosition slotPosition2;
    SlotPosition slotPosition3;
    
    BetAmount betAmount;
    
    BetChange increaseArrow;
    BetChange decreaseArrow;
    
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
        
        // Bet Amount Label
        betAmount = new BetAmount();
        addObject(betAmount, 210, 583);
        
       
        // Create and add bet change arrows
        increaseArrow = new BetChange("increase");
        addObject(increaseArrow, 70, 560);
        decreaseArrow = new BetChange("decrease");
        addObject(decreaseArrow, 110, 560);
        
        
        running = false;
        
    }
    
    /**
     * act() - Main execution. Begin by looking for any changes in bet. If the user presses the green start button,
     *         the slot will start running with current bet. Adjust the bankroll appropriately and set "running" flag
     *         to true to block the user from clicking other buttons while slot is running. Wait for the last slot to
     *         finish animating before checking for wins and busts.
     */
    public void act()
    {
        checkBetChange();
        
        if (Greenfoot.mousePressed(spinButton) && running == false)
        {
            spinButton.setImage("images/button-red.png");
            
            addItems();
            
            bankroll.adjustBankroll(-betAmount.getBetAmount());
            
            GreenfootSound slotSpinning = new GreenfootSound("sounds/slotSpinning.wav");
            slotSpinning.setVolume(100);
           
            slotSpinning.play();
            
            running = true;
        }
        
        // Once the last slot icon is finished animating, check win and set button active for next pull.
        if (slotPosition3.animationFinished() && running == true)
        {
                        
            checkWin();
            spinButton.setImage("images/button-green.png");
            running = false;
            
            checkBust();
        }
        
        
    }
    
    /**
     * checkWin() - Check the different slot positions looking for a win after animations are finished.
     *              -> 2 of any kind wins money back. 
     *              -> 3 of any kind wins 3 times bet amount.
     */
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
               // Win bet amount * 3
               bankroll.adjustBankroll(betAmount.getBetAmount() * 3);
               chaChing.play();
           }
           else
           {
               // Win money back
               bankroll.adjustBankroll(betAmount.getBetAmount());
               chaChing.play();
           }
       }
    }
    
    /**
     * addItems() -  Add different slot machine fruit icons. Remove old ones before adding 
     *               the new ones to prevent items from stacking stacking.
     */
    private void addItems()
    {
        removeObject(slotPosition1);
        removeObject(slotPosition2);
        removeObject(slotPosition3);
        
        slotPosition1 = new SlotPosition(1);
        slotPosition2 = new SlotPosition(2);
        slotPosition3 = new SlotPosition(3);
        
        // Number arguments = X,Y coordinates
        addObject(slotPosition1, 155, 385);
        addObject(slotPosition2, 300, 385);
        addObject(slotPosition3, 445, 385);
        
        
    }
    
    /**
     * checkBetChange() - Check for increase or decrease in bet from mouse click on arrows. Make sure
     *                    the animation is not currently running when allowing bet changing.
     */
    private void checkBetChange()
    {
        if (Greenfoot.mouseClicked(increaseArrow) && running == false)
        {
            betAmount.increaseBet();
        }
        else if (Greenfoot.mouseClicked(decreaseArrow) && running == false)
        {
            betAmount.decreaseBet();
        }
    }
    
    /**
     * checkBust() - Check for bankroll bust and if found, stop program execution.
     */
    private void checkBust()
    {
        if (bankroll.getBankroll() <= 0)
        {
            Greenfoot.stop();
        }
    }

}
