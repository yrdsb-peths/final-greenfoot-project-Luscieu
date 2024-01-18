import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen where you can select available levels
 * 
 * @author Luscieu
 * @version (a version number or a date)
 */
public class LevelSelect extends World
{

    /**
     * Constructor for objects of class LevelSelect.
     * 
     */
    public LevelSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("levelSelectScreen.png"); // adjust filename as needed
        bg.scale(getWidth(), getHeight());
        setBackground(bg);  
        
        Label title = new Label("Angry Birds", 80);
        addObject(title, 300, 50);
        
        
        addObject(new Level1Button(), 223, 215);
        addObject(new Level2Button(), 300, 215);
        addObject(new Level3Button(), 377, 215);
        addObject(new Level4Button(), 223, 286);
        addObject(new Level5Button(), 300, 286);
        addObject(new Level6Button(), 377, 286);
    }
}
