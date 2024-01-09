import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
/**
 * Write a description of class Pig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pig extends Animate
{
    float velocityY = 0;
    float velocityX = 0;
    int rSpeed = 0;
    int size = 20;
    GreenfootImage pig = new GreenfootImage("pig.png");
    /**
     * Act - do whatever the Wood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pig(int scalor) 
    {
        pig.scale(scalor,scalor);
        setImage(pig);
        size = scalor;
    }    
    public void act()
    {
        setRotation(getRotation()+rSpeed);
        setLocation(getX()+(int)Math.round(velocityX),getY());
        if(getY() >= 287)
            velocityX = velocityX*.7f;
        if(velocityY == 0 && getRotation() > 0)
        {
            rSpeed = 0;
            setRotation(0);
        }
        if(velocityY == 0)
        {
            setRotation(Math.abs(getRotation())-1);
        }
        impartForce();
        {
            velocityY += .1;
            //speed += .1;
        }
        if(getY() <= 288-(10*Math.sin(Math.abs(Math.toRadians(getRotation()))))&&!getBelow())
            setLocation(getX(),getY()+(int)Math.round(velocityY));
        else{
            if(velocityY>1.5){
                return;
            }
            velocityY = 0;
            //velocityX = velocityX*.7f;
            //velocityX = 0;
        }
        if(getY()>285)
        {
            getWorld().removeObject(this);
            MyWorlds world = (MyWorlds) getWorld();
            world.scoreIncrease();
            world.scoreIncrease();
        }
    }
    public void impartForce()
    {
        List<Animate> targets = getIntersectingObjects(Animate.class);
        for(int i = 0;i<targets.size();i++){
            if(targets.get(i).getX()>getX()){
                float whatever =  (targets.get(i)).getX()/(targets.get(i)).getY();
                float newX = velocityX*Math.abs(1-whatever/(velocityX/velocityY));
                float newY = velocityY*Math.abs(1-whatever/(velocityX/velocityY));
                (targets.get(i)).transferVelocity(velocityX/2, velocityY/2);
                velocityY = velocityY/2;//-newY;
                velocityX = velocityX/2;//2-newX;
            }
            //else if(targets.get(0).getY()>getY()&&velocityY >.5)
            {}
        }
    }
    public boolean getBelow()
    {
        List<Animate> bottom= getWorld().getObjects(Animate.class);
        boolean verdict = false;
        boolean flip = false;
        Actor flipper = bottom.get(0);
        for(int i = 0;i<bottom.size();i++)
        {
            if((bottom.get(i)).getY() > getY()&&(bottom.get(i)).getY() < getY()+16&&(bottom.get(i)).getX() > getX()-5&&(bottom.get(i)).getX() < getX()+5)
            {
                verdict = true;
                setLocation(getX(),(bottom.get(i)).getY()-15);
            }
            else if((bottom.get(i)).getY() > getY()&&(bottom.get(i)).getY() < getY()+16&&(bottom.get(i)).getX() > getX()-10&&(bottom.get(i)).getX() < getX()+10)
            {
                flip = true;
                flipper = bottom.get(i);
            }
        }
        /*if(verdict == false && flip == true)
        {
            int dif = flipper.getX()-getX();
            rSpeed = dif/2;
            velocityX +=dif/10;
        }*/
        return verdict;
    }
    public void transferVelocity(float x, float y)
    {
        velocityX += x;
        velocityY += y;
    }
}
