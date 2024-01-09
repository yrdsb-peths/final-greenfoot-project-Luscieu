import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends MyWorlds
{
    Wood wood;
    Ball ball;
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World2()
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
        
        addObject(new Pig(10),320,100);
        addObject(new Pig(10),440,50);
        addObject(new Sling(),100,275);
        
        
        
        
        addObject(new Rock(20),320,220);
        addObject(new Rock(20),360,280);
        addObject(new Rock(20),440,150);
        addObject(new Rock(20),480,210);
           
        
        for(int i = 0; i<2;i++)
        {
            addObject(new Wood(20),320,180-30*i);
            addObject(new Wood(20),360,240-30*i);
            addObject(new Wood(20),440,110-30*i);
            addObject(new Wood(20),480,170-30*i);
        }
    }
    public void act()
    {
        
        if(Greenfoot.mouseClicked(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse.getButton() <2)
            {
                removeObject(ball);
                ball = new Ball();
                addObject(ball,100,275);
                System.out.println("ball");
                if(275-mouse.getY() > -50)
                {
                    ball.velocityY = (275-mouse.getY())/10;
                }
                else
                {
                    ball.velocityY =-5;
                }
                if(100-mouse.getX() < 50)
                {
                    ball.velocityX = (100-mouse.getX())/10;
                }
                else
                {
                    ball.velocityX = 5;
                }
            }
            else
            {
                wood = new Wood(20);
                addObject(wood, mouse.getX(),mouse.getY());
            }
        }
        
        
    
        Star one = new Star();
        Star two = new Star();
        Star three = new Star();
        
        Blackstar four = new Blackstar();
        addObject(four,450,40);
        Blackstar five = new Blackstar();
        addObject(five,505,40);
        Blackstar six = new Blackstar();
        addObject(six,560,40);
        if(MyWorlds.getScore()>1000)
        {
            if(six!=null)
            {
                removeObject(six);
            }
            addObject(three,560,40);
        }
        if(MyWorlds.getScore()>600)
        {
            if(five!=null)
            {
                removeObject(five);
            }
            addObject(two,505,40);
        }
        if(MyWorlds.getScore()>300)
        {
            if(four!=null)
            {
                removeObject(four);
            }
            addObject(one,450,40); 
        }
    }
}
