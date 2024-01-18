import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4Button extends Button
{
    public Level4Button()
    {
        GreenfootImage image = getImage();
        image.scale(45, 45);
        setImage(image);
    }
    /**
     * Act - do whatever the Level4Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)){
            // Code to be executed when the button is clicked
            Level4 level4 = new Level4();
            Greenfoot.setWorld(level4);
        }
        super.act();
    }
}
