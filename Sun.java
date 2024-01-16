import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sun extends Actor
{
    GreenfootImage[] idleSun = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer();
    int imageIndex = 0;
    /**
     * Act - do whatever the Sun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Sun()
    {
        for(int i = 0; i < idleSun.length; i++)
        {
            idleSun[i] = new GreenfootImage("images/sun_spin/sun_spin" + i + ".png");
            idleSun[i].scale(100, 100);
        }
        setImage(idleSun[0]);// Add your action code here.
        animationTimer.mark();
    }
    public void act()
    {
        animateSun();
    }
    public void animateSun()
    {
        if(animationTimer.millisElapsed() < 80)
        {
            return;
        }
        imageIndex = (imageIndex + 1) % idleSun.length;
        setImage(idleSun[imageIndex]);
    }
}
