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
    int once = 0;
    GreenfootSound bowShoot = new GreenfootSound("shoot1.mp3");
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
        
        addObject(new Pig(20),320,180);
        addObject(new Pig(20),400,180);
        addObject(new Pig(20),480,180);
        addObject(new Sling(),100,275);
        addObject(new Sun(), 100,100);
        
        
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
            addObject(new Wood(20),320,200-15*i);
            addObject(new Wood(20),400,200-15*i);
            addObject(new Wood(20),480,200-15*i);
        }
    }
    public void act()
    {
        
        if(Greenfoot.mouseClicked(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse.getButton() <2 && MyWorlds.getBall()>=1)
            {
                bowShoot.play();
                removeObject(ball);
                ball = new Ball();
                addObject(ball,100,275);
                MyWorlds.countBall(-1);
                
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
        }
        
        
    
        Star one = new Star();
        Star two = new Star();
        Star three = new Star();
        
        Blackstar four = new Blackstar();
        Blackstar five = new Blackstar();
        Blackstar six = new Blackstar();
        
        if(once == 0)
        {
            addObject(four,450,40);
            addObject(five,505,40);
            addObject(six,560,40);
            once++;
        }
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
