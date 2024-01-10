import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.List;
/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Animate
{
    float velocityY = 0;
    float velocityX = 0;
    float speed = 0;
    boolean roll = true;
    public Ball() {
        // Initialize the ball image or other properties
        GreenfootImage ballImage = new GreenfootImage("beeper.png"); // You can replace "ball.png" with the actual image file
        setImage(ballImage);
    }
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
        velocityY += .1;
        speed += .1;
        if(getY() >= 287)
            velocityX = velocityX*.9f;
        if(getY() <= 285&&roll == false){
            
            setLocation(getX()+(int)Math.round(velocityX),getY()+(int)Math.round(velocityY));
            impartForce();
        }
        if(roll = true){
            setLocation(getX() + (int)Math.round(velocityX),getY());
            impartForce();
            //velocityX = velocityX*.7f;
        }
        checkBottom();
        //if(velocityY < .3&&velocityX < .3)
            //getWorld().removeObject(this);
    }    
    public void checkBottom()
    {
        List<Wood> targets = getIntersectingObjects(Wood.class);
        boolean verdict = false;
        for(int i = 0;i<targets.size();i++){
            if(getY() < targets.get(i).getY()-9&&getX() > targets.get(i).getX()+9)
            {
                verdict = true;
            }
        }
        if(verdict == true)
        {
            roll = true;
        }
        else roll = false;
    }
    public void impartForce()
    {
        List<Animate> targets = getIntersectingObjects(Animate.class);
        for(int i = 0;i<targets.size();i++){
            //if(Math.pow(Math.pow(targets.get(0).getY(),2)+Math.pow(targets.get(0).getX(),2),.5) <20)
            {
                float whatever =  (targets.get(i)).getX()/(targets.get(i)).getY();
                float newX = velocityX*Math.abs(1-whatever/(velocityX/velocityY));
                float newY = velocityY*Math.abs(1-whatever/(velocityX/velocityY));
                (targets.get(i)).transferVelocity(velocityX/2, 0);
                velocityY = velocityY;//-newY;
                velocityX = velocityX/2;//2-newX;
            }
        }
    }
}
