import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animate extends Actor
{
    float velocityX;
        float velocityY;
    /**
     * Act - do whatever the Animate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    public void transferVelocity(float x, float y)
    {
        velocityX += x;
        velocityY += y;
    }
}
