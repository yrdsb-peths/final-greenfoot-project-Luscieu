import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Animate
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        // Add your action code here.

    int size = 20;
    //Wood flipper;
    boolean second = false;
    GreenfootImage b = new GreenfootImage("unnamed.png");
    /**
     * Act - do whatever the Wood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rock(int scalor) 
    {
        b.scale(scalor,scalor);
        setImage(b);
        size = scalor;
        
    }    
    /**
     * Act - do whatever the Wood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        ;
    }
    
}

