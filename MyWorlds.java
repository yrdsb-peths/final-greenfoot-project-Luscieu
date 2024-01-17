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
    Ball counter;
    static int score = 0;
    static Label scoreLabel;
    static int ballCount = 5;
    static Label ballLabel;
    /**
     * Constructor for objects of class MyWorlds.
     * 
     */
    public MyWorlds()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        score = 0;
        ballCount = 5;
        scoreLabel = new Label(0, 30);
        addObject(scoreLabel, 550, 80);
        scoreLabel.setValue("0000");
        ballLabel = new Label(ballCount + "x", 30);
        addObject(ballLabel, 30, 380);
        counter = new Ball();
        addObject(counter, 55, 380);
    }
    
        
    public static void scoreIncrease()
    {
        score+=100;
        if(getScore()>=1000)
        {
            scoreLabel.setValue(score);
            return;
        }
        if(getScore()>=100)
        {
            scoreLabel.setValue("0" + score);
            return;
        }
        
    }
    public static int getScore()
    {
        return score;
    }
    public static void countBall(int increment)
    {
        ballCount+=increment;
        ballLabel.setValue(ballCount+"x");
    }
    public static int getBall()
    {
        return ballCount;
    }
    public static void setBall(int balls)
    {
        ballCount = balls;
    }
}
