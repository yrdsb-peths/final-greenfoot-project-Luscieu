import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends MyWorlds
{
    Wood wood;
    Ball ball;
    int once = 0;
    int oneStar = 300;
    int twoStar = 600;
    int threeStar = 1000;
    GreenfootSound bowShoot = new GreenfootSound("shoot1.mp3");
    SimpleTimer gameOverTimer = new SimpleTimer();
    /**
     * Constructor for objects of class World1.
     * 
     */
    public Level1()
    {
        
        //sets background
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
        
        //necessary objects
        addObject(new Sling(),100,275);
        addObject(new Sun(), 100,100);
        addObject(new Back(), 30, 30);
        
        //map specific objects
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
        addObject(new Pig(20),320,180);
        addObject(new Pig(20),400,180);
        addObject(new Pig(20),480,180);
        for(int i = 0; i<4;i++)
        {
            addObject(new Wood(20),320,200-15*i);
            addObject(new Wood(20),400,200-15*i);
            addObject(new Wood(20),480,200-15*i);
        }
    }
    public void act()
    {
        //Allows ball to be shot
        if(Greenfoot.mouseClicked(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse.getButton() <2 && MyWorlds.getBall()>=1)
            {
                bowShoot.play();
                removeObject(ball);
                ball = new Ball();
                addObject(ball,100,275);
                MyWorlds.countBall(-1);
                if(getBall()==0)
                {
                    gameOverTimer.mark(); //starts gameover timer
                }
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
        
        if(MyWorlds.getBall()==0 && gameOverTimer.millisElapsed()>3000)
        {
            gameOver();
        }
        
        //creates stars
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
        
        //adjusts stars based on score
        if(MyWorlds.getScore()>threeStar)
        {
            if(six!=null)
            {
                removeObject(six);
            }
            addObject(three,560,40);
        }
        if(MyWorlds.getScore()>twoStar)
        {
            if(five!=null)
            {
                removeObject(five);
            }
            addObject(two,505,40);
        }
        if(MyWorlds.getScore()>oneStar)
        {
            if(four!=null)
            {
                removeObject(four);
            }
            addObject(one,450,40); 
        }
    }
    
    /*
     * This method comments on the player? performance based on score, and triggers two buttons to appear, allowing the 
     * player to restart, or go back to the level select screen.
     */
    public void gameOver()
    {
        if(MyWorlds.getScore()>threeStar)
        {
            Label results = new Label("Three stars huh? Nice.", 30);
            addObject(results, 300, 200);
        }
        else if(MyWorlds.getScore()>twoStar)
        {
            Label results = new Label("Two Stars? Decent, but you can do better.", 30);
            addObject(results, 300, 200);
        }
        else if(MyWorlds.getScore()>oneStar)
        {
            Label results = new Label("One Star? Really? Get better.", 30);
            addObject(results, 300, 200);
        }
        else
        {
            Label results = new Label("Zero Stars? Pathetic.", 40);
            addObject(results, 300, 200);
        }
        addObject(new Back(),270, 270);
        addObject(new Level1Button(), 330,270);
    }
}
