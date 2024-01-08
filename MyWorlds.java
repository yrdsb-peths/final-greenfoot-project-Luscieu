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
    
        
    public static void scoreIncrease()
    {
        score+=100;
        scoreLabel.setValue(score);
    }
    public static int getScore()
    {
        return score;
    }
}
