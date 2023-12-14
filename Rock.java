import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Animate
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        // Add your action code here.
    float velocityY = 0;
    float velocityX = 0;
    int rSpeed = 0;
    int size = 20;
    //Wood flipper;
    boolean second = false;
    GreenfootImage b =new GreenfootImage("Broken_Block.png");
    /**
     * Act - do whatever the Wood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rock(int scalor) 
    {
        b.scale(scalor,scalor);
        setImage(b);
        size = scalor;
        getImage().setColor(new Color(50, 50, 50));
        getImage().fill();
        
    }    
    /**
     * Act - do whatever the Wood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getImage().setColor(new Color(50, 50, 50));
        getImage().fill();
        setRotation(getRotation()+rSpeed);
        setLocation(getX()+(int)Math.round(velocityX),getY());
        //slideGetAbove();
        velocityX = velocityX*getFriction();
        if(velocityY == 0 && getRotation() > 0)
        {
            rSpeed = 0;
            setRotation(0);
        }
        if(velocityY == 0)
        {
            setRotation(Math.abs(getRotation())-1);
        }
        {
            velocityY += .1;
            //speed += .1;
        }
        if(getY() <= 288-(10*Math.sin(Math.abs(Math.toRadians(getRotation()))))&&!getBelow())
            setLocation(getX(),getY()+(int)Math.round(velocityY));
        else{
            if(velocityY>5){
                getWorld().removeObject(this);
                return;
            }
            velocityY = 0;
            //velocityX = velocityX*.7f;
            //velocityX = 0;
        }
        getImage().setColor(Color.BLUE);
        
    }
    public float getFriction()
    {
        float friction = 0;
        if(getY() >= 287)
            friction += .3;
        return 1-friction;
    }
    public void impartForce()
    {
        List<Animate> targets = getIntersectingObjects(Animate.class);
        float direction = velocityX/Math.abs(velocityX);
        for(int i = 0;i<targets.size();i++){
            if(targets.get(i).getX()*direction>getX()){
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
    public float getAbove()
    {
        List<Wood> bottom= getWorld().getObjects(Wood.class);
        boolean verdict = false;
        boolean flip = false;
        float given= 0;
        Wood flipper = bottom.get(0);
        for(int i = 0;i<bottom.size();i++)
        {
            if((bottom.get(i)).getY() < getY()&&(bottom.get(i)).getY() > getY()-16&&(bottom.get(i)).getX() > getX()-5&&(bottom.get(i)).getX() < getX()+5)
            {
                verdict = true;
                flipper = bottom.get(i);
            }
            else if((bottom.get(i)).getY() < getY()&&(bottom.get(i)).getY() > getY()-16&&(bottom.get(i)).getX() > getX()-10&&(bottom.get(i)).getX() < getX()+10)
            {
                verdict = true;
                flipper = bottom.get(i);
            }
            
        }
        if(verdict = true){
            given += .1;
            given += flipper.getAbove();
        }
        
        return given;
    }
    public void slideGetAbove()
    {
        List<Wood> bottom= getWorld().getObjects(Wood.class);
        boolean verdict = false;
        boolean flip = false;
        float given= 0;
        Wood flipper = bottom.get(0);
        for(int i = 0;i<bottom.size();i++)
        {
            if((bottom.get(i)).getY() < getY()&&(bottom.get(i)).getY() > getY()-16&&(bottom.get(i)).getX() > getX()-5&&(bottom.get(i)).getX() < getX()+5)
            {
                //if(bottom.get(i) != flipper)
                {verdict = true;
                flipper = bottom.get(i);}
            }
            else if((bottom.get(i)).getY() < getY()&&(bottom.get(i)).getY() > getY()-16&&(bottom.get(i)).getX() > getX()-10&&(bottom.get(i)).getX() < getX()+10)
            {
                //if(bottom.get(i) != flipper)
                {verdict = true;
                flipper = bottom.get(i);}
            }
            
        }
        if(verdict == true){
            flipper.velocityX += velocityX/4;
            //flipper.slideGetAbove();
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
                setLocation(getX(),(bottom.get(i)).getY()-size+4);
            }
            else if((bottom.get(i)).getY() > getY()&&(bottom.get(i)).getY() < getY()+16&&(bottom.get(i)).getX() > getX()-10&&(bottom.get(i)).getX() < getX()+10)
            {
                flip = true;
                verdict = true;
                velocityX += ((bottom.get(i)).getX()-getX())/10;
                rSpeed += ((bottom.get(i)).getX()-getX())/10;
                flipper = bottom.get(i);
            }
        }
        //if(getIntersectingObjects(Animate.class).size()>0)
          //  setLocation(getX()-(int)Math.round(velocityX),getY());
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
        stop();
    }
    public void stop()
    {
        if(Math.pow(Math.pow(velocityY,2)+Math.pow(velocityX,2),.5)>2){
            /*if(second == false){
                setImage(b);
                velocityX = 0;
                velocityY = 0;
                second = true;
            }
            else{
                getWorld().removeObject(this);
                return;
            }*/
        }
        else if(Math.pow(Math.pow(velocityY,2)+Math.pow(velocityX,2),.5)>3){
            getWorld().removeObject(this);
            return;
        }
    }
}

