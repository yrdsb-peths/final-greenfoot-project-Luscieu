import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
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
            MyWorlds world = new MyWorlds();
            Greenfoot.setWorld(world);
        }
    }
}
