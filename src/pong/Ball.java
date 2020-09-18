package pong;

import java.awt.*;

import java.util.*;

public class Ball extends Rectangle {

    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 2;


    Ball(int xPos, int yPos, int width, int height) {
        super(xPos,yPos,width,height);
        random = new Random();

        int randomXDir = random.nextInt(2);
        if (randomXDir == 0)
            randomXDir--;
        setBallX(randomXDir*initialSpeed);

        int randomYDir = random.nextInt(2);
        if (randomYDir == 0)
            randomYDir--;
        setBallY(randomYDir*initialSpeed);

    }

    public void setBallX(int randomXDirection){
        xVelocity = randomXDirection;
    }

    public void setBallY(int randomYDirection){
        yVelocity = randomYDirection;
    }

    public void moveBall(){
        x += xVelocity;
        y += yVelocity;
    }

    public void drawBall(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,height,width);
    }

}
