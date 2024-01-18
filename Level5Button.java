import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level5Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5Button extends Button
{
    public Level5Button()
    {
        GreenfootImage image = getImage();
        image.scale(45, 45);
        setImage(image);
    }
    /**
     * Act - do whatever the Level5Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)){
            // Code to be executed when the button is clicked
            Level5 level5 = new Level5();
            Greenfoot.setWorld(level5);
        }
        super.act();
    }
}
