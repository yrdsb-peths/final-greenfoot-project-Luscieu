import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    private static final int RAISED_HEIGHT = 5;  // Adjust the raised height as needed
    private static final int ORIGINAL_HEIGHT = 0;  // Original height of the button
    private boolean isRaised = false;  // Track whether the button is raised
    private int moveCounter = 0;  // Counter for smooth movement
    private int moveSpeed = 2;    // Adjust the movement speed as needed
    
    public void act() {
        if (Greenfoot.mouseMoved(this)) {
            if (!isRaised) {
                raiseButton();
            }
        } else {
            if (isRaised && Greenfoot.mouseMoved(null)) {
                lowerButton();
            }
        }
    }
    
    /**
     * Moves the button up
     */
    private void raiseButton() {
        int targetY = getY() - RAISED_HEIGHT;

        // Smoothly move up
        if (moveCounter < RAISED_HEIGHT) {
            setLocation(getX(), getY() - moveSpeed);
            moveCounter += moveSpeed;
        } else {
            setLocation(getX(), targetY);
            isRaised = true;
            moveCounter = 0;
        }
    }
    /**
     * Moves the button down
     */
    private void lowerButton() {
        int targetY = getY() + RAISED_HEIGHT;

        // Smoothly move down
        if (moveCounter < RAISED_HEIGHT) {
            setLocation(getX(), getY() + moveSpeed);
            moveCounter += moveSpeed;
        } else {
            setLocation(getX(), targetY);
            isRaised = false;
            moveCounter = 0;
        }
    }
}
