package pong;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH*(0.555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;



    GamePanel() {
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new actionListener());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
    }

    public void newPaddles(){
        paddle1 = new Paddle(0,(GAME_HEIGHT/2) - (PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2) - (PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }

    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0,0,this);
    }

    public void draw(Graphics g){
        paddle1.drawPaddle(g);
        paddle2.drawPaddle(g);
        ball.drawBall(g);
    }

    public void move(){
        paddle1.movePaddle();
        paddle2.movePaddle();
        ball.moveBall();
    }

    public void checkCollision(){

        //stop paddles from going off screen
        if(paddle1.y <= 0)
            paddle1.y = 0;
        if(paddle1.y >= GAME_HEIGHT - PADDLE_HEIGHT)
            paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        if(paddle2.y <= 0)
            paddle2.y = 0;
        if(paddle2.y >= GAME_HEIGHT - PADDLE_HEIGHT)
            paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;

        //bounce ball off top and bottom panel edges
        if(ball.y <= 0 || ball.y >= GAME_HEIGHT - BALL_DIAMETER)
            //ball.yVelocity = -ball.yVelocity;         QUESTION: why do i have to use the setter and not just this?
            ball.setBallY(-ball.yVelocity);

        //bounce ball off paddles
        if(ball.intersects(paddle1))
            ball.setBallX(-ball.xVelocity);
        if(ball.intersects(paddle2))
            ball.setBallX(-ball.xVelocity);

        //check ball in endzone
        if(ball.x <= 0) {
            score.score2++;
            newPaddles();
            newBall();
            System.out.println("SCORE [ " + score.score1 + " : " + score.score2 + " ]");
        }
        if(ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.score1++;
            newPaddles();
            newBall();
            System.out.println("SCORE [ " + score.score1 + " : " + score.score2 + " ]");
        }
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class actionListener extends KeyAdapter {

        public void keyPressed(KeyEvent e){
            paddle1.keyPressedPaddle(e);
            paddle2.keyPressedPaddle(e);
        }

        public void keyReleased(KeyEvent e){
            paddle1.keyReleasedPaddle(e);
            paddle2.keyReleasedPaddle(e);

        }
    }

}