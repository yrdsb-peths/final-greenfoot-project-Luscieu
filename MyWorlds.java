import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorlds extends World
{
    Wood wood;
    Ball ball;
    static int score = 0;
    static Label scoreLabel;
    /**
     * Constructor for objects of class MyWorlds.
     * 
     */
    public MyWorlds()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        score = 0;
        scoreLabel = new Label(score, 30);
        addObject(scoreLabel, 30, 30);
    }
    public void act()
    {
        
        if(Greenfoot.mouseClicked(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse.getButton() <2)
            {
                //removeObject(ball);
                ball = new Ball();
                addObject(ball,100,275);
                if(275-mouse.getY() > -50)
                    ball.velocityY = (275-mouse.getY())/10;
                else
                    ball.velocityY =-5;
                if(100-mouse.getX() < 50)
                    ball.velocityX = (100-mouse.getX())/10;
                else
                    ball.velocityX = 5;
            }
            else
            {
                wood = new Wood(20);
                addObject(wood, mouse.getX(),mouse.getY());
            }
        }
        if(Greenfoot.isKeyDown("right")){
            wood.setRotation(wood.getRotation()+1);
        }
        
    }
    public static void scoreIncrease()
    {
        score+=100;
        scoreLabel.setValue(score);
    }
}
