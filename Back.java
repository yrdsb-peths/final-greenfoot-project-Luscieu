import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Changes world to LevelSelect when clicked on
 * 
 * @author Benny
 * @version (a version number or a date)
 */
public class Back extends Actor
{
    public Back()
    {
        GreenfootImage img = getImage();
        img.scale(50, 50);
        
        setImage(img);
    }
    /**
     * Act - do whatever the Back wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            // Code to be executed when the button is clicked
            LevelSelect selectLevel = new LevelSelect();
            Greenfoot.setWorld(selectLevel);
        }
    }
}
