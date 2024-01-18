import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2Button extends Button
{
    public Level2Button()
    {
        GreenfootImage image = getImage();
        image.scale(45, 45);
        setImage(image);
    }
    /**
     * Act - do whatever the Level2Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            // Code to be executed when the button is clicked
            Level2 level2 = new Level2();
            Greenfoot.setWorld(level2);
        }
        super.act();
    }
}
