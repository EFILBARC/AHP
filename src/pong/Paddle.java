package pong;

import java.awt.*;

import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {

    int id;
    int yVelocity;
    int speed = 10;


    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id = id;
    }

    public void keyPressedPaddle(KeyEvent e){

        switch(id) {
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setPaddleY(-speed);
                    movePaddle();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setPaddleY(speed);
                    movePaddle();
                }
                break;

            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setPaddleY(-speed);
                    movePaddle();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setPaddleY(speed);
                    movePaddle();
                }
                break;

        }


    }

    public void keyReleasedPaddle(KeyEvent e){

        switch(id) {
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setPaddleY(0);
                    movePaddle();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setPaddleY(0);
                    movePaddle();
                }
                break;

            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setPaddleY(0);
                    movePaddle();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setPaddleY(0);
                    movePaddle();
                }
                break;

        }

    }

    public void setPaddleY(int yDirection){

        yVelocity = yDirection;

    }
    public void movePaddle(){

        y = y+yVelocity;

    }
    public void drawPaddle(Graphics g){
        if(id==1){
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }
        g.fillRect(x, y, width, height);
    }

}
