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
        
        
        getBackground().setColor(Color.BLUE); //Sets color to blue
        getBackground().fill(); // creates background using the set color
        getBackground().setColor(Color.GREEN);
        //getBackground().fillOval(260,160,80,80);
        getBackground().fillRect(0,300,600,100);
        
        /* 
        getBackground().setColor(Color.LIGHT_GRAY);
        for(int i = 0; i<3;i++)
        {
            getBackground().fillRect(360+75*i, 280, 25, 25);
        }
        */
        
        addObject(new Pig(),430,280);
        addObject(new Pig(),490,280);
        addObject(new Sling(),100,275);
        
        for(int i = 0; i<4;i++)
        {
            addObject(new Rock(20),320,290-15*i);
            if(i<3)
            {
                addObject(new Rock(20),400,290-15*i);
            }
            if(i<2)
            {
                addObject(new Rock(20),480,290-15*i);
            }
        }
        
        for(int i = 0; i<4;i++)
        {
            addObject(new Wood(20),320,120+12*i);
            
            addObject(new Wood(20),400,130+12*i);
            
            
            addObject(new Wood(20),480,140+12*i);
        }
    }
}
