import greenfoot.*;
import java.awt.Font;
import java.awt.Color;

/**
 * BetAmount() - Class holds the user's current bet amount. Max bet is 50 and all of the possible
 * bets are stored in the betArray (1,2,5,10,25,50). The betAmountIndex is the index counter that will
 * be increased or decreased when user interacts with the BetChange buttons.
 * 
 * @author Eric Davis
 * @version 1.0 - April 2016
 */
public class BetAmount extends Actor
{
    
    private int betAmountIndex;
    private int[] betArray = {1, 2, 5, 10, 25, 50};
    
    /**
     * BetAmount() - Constructor. Set the new image size and initialize the counter to 0 for the 
     * first value in the array. Call updateBet() to draw the string onto the screen.
     */
    public BetAmount()
    {
                
        setImage(new GreenfootImage(130, 80));
        
        betAmountIndex = 0;
        
        updateBet();
    }
    
    
    /**
     * Act - Check to make sure the bet cannot exceed the bankroll with checkLegalBet method. Once
     * confirmed as legal amount, update the bet image with updateBet method.
     */
    public void act() 
    {
        checkLegalBet();
        updateBet();
    }    
    
    
    /** 
     * updateBet - Creates the image displayed on the screen. Update is called each execution
     * cycle to check for changes. The old image needs cleared to prevent stacking, and a new 
     * image is then created with any increased/decreased bets.
     */
    public void updateBet()
    {
        // Get image as variable
        GreenfootImage betImage = getImage();
        // Clear the image
        betImage.clear();
        // Create variable for fontsize
        float fontSize = 30;
        // Get and create variable for font
        Font font = betImage.getFont().deriveFont(fontSize);
        // Set font and font color to the image
        betImage.setFont(font);
        betImage.setColor(Color.WHITE);
        // Draw on the image canvas with font
        betImage.drawString("Bet: " + betArray[betAmountIndex], 1, 25);
    }
    
    
    /**
     * checkLegalBet - Check to make sure the current bet is legal (ie: not greater than current bankroll
     * nor greater than the max allowed bet). While loop tests current bet against bankroll and forces 
     * decrease if bet is illegal. The if statement makes sure the array index never reaches -1.
     */
    private void checkLegalBet()
    {
        // Cast world to find the current bankroll
        MyWorld world = (MyWorld)getWorld();
        int bankroll = world.bankroll.getBankroll();
        
        // Check for legal bet.
        while (betArray[betAmountIndex] > bankroll)
        {
            
            // Check for lower bound of array.
            if(betAmountIndex > 0)
            {
                betAmountIndex--;
            }
            else
            {
                betAmountIndex = 0;
                break;
            }

        }
        
    }
    
    public int getBetAmount()
    {
        return betArray[betAmountIndex];
    }
    
    
    /**
     * increaseBet - Increases the current bet, duh. Make sure the increase in bet does not exceed
     * the upper bound of the array nor the current bankroll.
     */
    public void increaseBet()
    {
        MyWorld world = (MyWorld)getWorld();
        int bankroll = world.bankroll.getBankroll();
        
        if (betAmountIndex < (betArray.length - 1) && betArray[betAmountIndex] <= bankroll)
        {
            betAmountIndex++;
            
            checkLegalBet();
        }
    }
    
    public void decreaseBet()
    {
        if (betAmountIndex > 0)
        {
            betAmountIndex--;
        }
        
    }
}
