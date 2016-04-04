import greenfoot.*;
import java.awt.Font;
import java.awt.Color;
/**
 * Write a description of class Bankroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bankroll extends Actor
{
    
    private int bankroll;
    
    
    public Bankroll()
    {
        setImage(new GreenfootImage(250, 80));
        
        bankroll = 100;
        
        updateBankroll();
    }
    
    /**
     * Act - do whatever the Bankroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateBankroll();
    }
    
    
    private void updateBankroll()
    {
        // Get reference to current image
        GreenfootImage bankrollImage = getImage();
        
        // Clear the old image. Prevents stacking.
        bankrollImage.clear();
        
        // Create font size variable
        float fontSize = 30;
        
        // Create Font for Draw String
        Font font = bankrollImage.getFont().deriveFont(fontSize);
        
        // Set font to the image
        bankrollImage.setFont(font);
        bankrollImage.setColor(Color.WHITE);
        
        // Draw the string with the created font
        bankrollImage.drawString("Bankroll: " + bankroll, 1, 25);
        
    }
    
    public void adjustBankroll(int x)
    {
        bankroll = bankroll + x;
    }
    
    public int getBankroll()
    {
        return bankroll;
    }
}
