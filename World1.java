import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends MyWorlds
{
    Wood wood;
    Ball ball;
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {
        
        getBackground().setColor(Color.BLUE);
        getBackground().fill();
        getBackground().setColor(Color.GREEN);
        //getBackground().fillOval(260,160,80,80);
        getBackground().fillRect(0,300,600,100);
        
        
        addObject(new Pig(),430,280);
        addObject(new Pig(),490,280);
        addObject(new Sling(),100,275);
        for(int i = 0; i<7;i++)
        {
            addObject(new Wood(20),400,150+12*i);
            addObject(new Wood(20),460,160+12*i);
            addObject(new Wood(20),520,170+12*i);
        }
    }
}
