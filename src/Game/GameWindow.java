package Game;


import Bricks.Brick;
import PowerUps.PowerUp;
import PowerUps.PowerUpType;
import static PowerUps.PowerUpType.*;
import Projectiles.*;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */
class GameWindow extends JInternalFrame implements Runnable{
    private final String WINNER = "You win!",
                         LOSER  = "Game Over!";
    
    private final MainMenu mainMenu;
    private final JDesktopPane desktop;
    private final GameWindow gameWindow;
    
    private final Robot robot;
    
    private Thread animator;
    private boolean paused,
                    gameOver;
    private final Paddle paddle;
    private final List<Ball> balls;
    private List<Brick> bricks;
    private final List<PowerUp> powerUps;
    private final List<Laser> lasers;
    private final List<ExplodingDummy> explodingDummies;
    
    private Image background;
    private final Cursor invisibleCursor;
    private int lives,
                score;
    private double multiplier;
    private String endMessage;
    private boolean[] availablePowerUps;
    
    public GameWindow(MainMenu mainMenu, JDesktopPane desktop) throws AWTException {
        super("", false, false, false, false);
        this.desktop = desktop;
        this.mainMenu = mainMenu;
        gameWindow = this;
        
        availablePowerUps = new boolean[PowerUpType.TOTAL_POWERUPS];
        
        desktop.add(new PowerUpSelector(this, availablePowerUps));
        
        
        invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0,0), "blank cursor");
        setCursor(invisibleCursor);
        
        ((BasicInternalFrameUI)super.getUI()).setNorthPane(null);
        setSize(800,600);
        setVisible(false);
        setBorder(null);
        setFocusable(true);
        
        setDoubleBuffered(true);
        setOpaque(true);
        
        addKeyListener(new KeyboardAdapter());
        addMouseListener(new MouseAdapter());
        addMouseMotionListener(new MouseAdapter());
        
        robot = new Robot();
        
        paused = false;
        gameOver = false;
        paddle = new Paddle();
        balls = new ArrayList<>();
        bricks = new ArrayList<>();
        powerUps = new ArrayList<>();
        lasers = new ArrayList<>();
        explodingDummies = new ArrayList<>();
        
        balls.add(new Ball(paddle.getWidth()/2, paddle.getY()-Ball.getDiameter(), true));
        
        lives = 3;
        score = 0;
        multiplier = 1;
        
        availablePowerUps = new boolean[PowerUpType.TOTAL_POWERUPS];
        for(int i=0; i<PowerUpType.TOTAL_POWERUPS; i++){
            availablePowerUps[i] = true;
        }
    }
    
    protected void selectLevel(){
        JFileChooser fileChooser = new JFileChooser("Level select:");
        fileChooser.setCurrentDirectory(new File("Levels"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Breakout Level", new String[]{"BOL"}));
        switch(fileChooser.showOpenDialog(this)){
            case JFileChooser.APPROVE_OPTION:
                createLevel(fileChooser.getSelectedFile());
                break;
            case JFileChooser.CANCEL_OPTION:
            case JFileChooser.ERROR_OPTION:
                returnToMainMenu();
                break;
            default:
        }
    }
    
    private void returnToMainMenu(){
        mainMenu.setCursor(Cursor.getDefaultCursor());
        mainMenu.setVisible(true);
        gameWindow.dispose();
    }

    @Override
    public void addNotify(){
        super.addNotify();
        animator = new Thread(this);
    }
    
    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        final long delay = 10;
        
        while(!gameOver){
            beforeTime = System.currentTimeMillis();

            if(!paused){
                gameLogic();
                repaint();
            }
            
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = delay - timeDiff;
            if(sleep < 0){
                sleep = 2L;
            }

            try{
                Thread.sleep(sleep);
            }catch(InterruptedException e){
                System.out.println("Thread interrupted!");
            }
        }
        setCursor(Cursor.getDefaultCursor());
        while(true){
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted!");
            }
        }
    }
    
    private void gameLogic(){
        Iterator<Ball> ballIT = balls.iterator();
        while(ballIT.hasNext()){
            Ball ball = ballIT.next();
            ball.move();
            ball.checkCollision(paddle);
            
            Iterator<Brick> brickIT = bricks.iterator();
            while(brickIT.hasNext()){
                Brick brick = brickIT.next();
                ball.checkCollision(brick);
                if(brick.isDestroyed()){
                    increaseScore(brick.getScore());
                    brickIT.remove();
                    if(PowerUp.willSpawn()){
                        powerUps.add(new PowerUp(availablePowerUps, brick.getPosition()));
                    }
                }
            }
            if(ball.isDead())
                ballIT.remove();
        }
        
        Iterator<PowerUp> powerUpIT = powerUps.iterator();
        while(powerUpIT.hasNext()){
            PowerUp powerUp = powerUpIT.next();
            powerUp.move();
            if(paddle.collides(powerUp)){
                applyPowerUp(powerUp);
                powerUpIT.remove();
            }
            else if(powerUp.isOutOfBounds())
                powerUpIT.remove();
        }
        
        Iterator<Laser> laserIT = lasers.iterator();
        while(laserIT.hasNext()){
            Laser laser = laserIT.next();
            laser.move();
            
            Iterator<Brick> brickIT = bricks.iterator();
            while(brickIT.hasNext()){
                Brick brick = brickIT.next();
                laser.checkCollision(brick);
                if(brick.isDestroyed()){
                    increaseScore(brick.getScore());
                    brickIT.remove();
                    if(PowerUp.willSpawn()){
                        powerUps.add(new PowerUp(availablePowerUps, brick.getPosition()));
                    }
                }
            }
            if(laser.isDead())
                laserIT.remove();
        }
        
        if(balls.isEmpty()){
            lives--;
            if(lives > 0)
                balls.add(new Ball(paddle.getWidth()/2, paddle.getY()-Ball.getDiameter(), true));
            else{
                gameOver = true;
                endMessage = LOSER;
            }
        }
        if(bricks.isEmpty()){
            gameOver = true;
            endMessage = WINNER;
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        paintBackground(g);
        
        paddle.paint(g);
        
        for(Laser laser : lasers)
            laser.paint(g);
        
        for(Ball ball : balls)
            ball.paint(g);
        
        for(Brick brick : bricks)
            brick.paint(g);
        
        for(PowerUp powerUp : powerUps)
            powerUp.paint(g);
        
        drawStatusBar(g);
        
        if(gameOver){
            g.setXORMode(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.drawString(endMessage,
                            GameBoundaries.RIGHT/2-g.getFontMetrics().stringWidth(endMessage)/2,
                            GameBoundaries.BOTTOM/2-g.getFontMetrics().getHeight()/2);
        }
        g.dispose();
    }
    
    private void paintBackground(Graphics g){
        g.drawImage(background, 0, 0, GameBoundaries.RIGHT, GameBoundaries.BOTTOM, null);
    }
    
    private void drawStatusBar(Graphics g){
        final int height = 20;
        final int bottomOffset = 5;
        Ball ball = new Ball();
        g.setColor(Color.BLACK);
        g.fillRect(GameBoundaries.LEFT, GameBoundaries.BOTTOM-height, GameBoundaries.RIGHT, height);
        for(int i=0; i<lives; i++)
            ball.paint(g, Ball.getDiameter()*i + 2, GameBoundaries.BOTTOM-Ball.getDiameter()-bottomOffset);
        
        g.setColor(Color.YELLOW);
        String s = "Score: "+score;
        g.drawString(s, GameBoundaries.RIGHT-g.getFontMetrics().stringWidth(s), GameBoundaries.BOTTOM-bottomOffset);
    }

    private void createLevel(File file) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            bricks = (ArrayList<Brick>) ois.readObject();
            background = ImageIO.read(ois);
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Failed to load level. Press OK to return to title.", "Critical error!", JOptionPane.ERROR_MESSAGE);
        }
        animator.start();
    }
    
    private void increaseScore(int score){
        this.score += score*multiplier;
    }
    
    public void drop(List<Brick> bricks){
        ListIterator<Brick> i, j;
        Brick a, b;
        boolean canFall;
        for(i = bricks.listIterator(); i.hasNext(); /* i.next() */){
            a = i.next();
            canFall = a.getY() <= GameBoundaries.BOTTOM - 200; //MAGIC NUMBER
            for(j = bricks.listIterator(i.nextIndex()); j.hasNext() && canFall; /* j.next() */){
                b = j.next();
                if(a.getFallBoundary().intersects((Rectangle2D) b.getCollisionBoundary())){
                    canFall = false;
                }
            }
            if(canFall)
                a.fall();
        }
    }
    
    public void setAvailablePowerUps(boolean[] availablePowerUps){
        this.availablePowerUps = availablePowerUps;
    }

    private void applyPowerUp(PowerUp powerUp) {
        switch(powerUp.getType()){
            case SHOOTING_PADDLE:
                paddle.setShooting(true);
                break;
            case HOLDING_PADDLE:
                paddle.setHolding(true);
                break;
            case FIREBALL:
                for(Ball b : balls){
                    b.setFireBall(true);
                }
                break;
            case THROUGH_BALL:
                for(Ball b : balls){
                    b.setThroughBall(true);
                }
                break;
            case SLOW_BALL:
                for(Ball b : balls){
                    b.setSpeed(Ball.SLOW);
                }
                break;
            case SCORE_MULTIPLIER:
                multiplier*=2;
                break;
            case EXTRA_LIFE:
                lives++;
                break;
            case SPLIT_BALL:
                ArrayList<Ball> split = new ArrayList<>();
                for(Ball b : balls){
                    Ball newBall = b.clone();
                    if(b.isGoingLeft())
                        newBall.bounceLeft();
                    else
                        newBall.bounceRight();
                    split.add(newBall);
                }
                balls.addAll(split);
                break;
            case ENLARGE_PADDLE:
                paddle.grow();
                break;
            case REDUCE_PADDLE:
                paddle.shrink();
                break;
            case FAST_BALL:
                for(Ball b : balls)
                    b.setSpeed(Ball.FAST);
                break;
            case DEATH:
                lives--;
                break;
            case FALLING_BRICKS:
                for(int i=0; i<3; i++)
                    drop(bricks);
                break;
            case MINIATURE_PADDLE:
                paddle.miniaturize();
                break;
            default:
                //Should never happen
        }
        increaseScore(200);
    }
    
    private class KeyboardAdapter extends KeyAdapter{

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_ESCAPE:
                    returnToMainMenu();
                    break;
                case KeyEvent.VK_P:
                    if(paused)
                        gameWindow.setCursor(invisibleCursor);
                    else
                        gameWindow.setCursor(Cursor.getDefaultCursor());
                    paused = !paused;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    private class MouseAdapter implements MouseListener, MouseMotionListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(!paused && !gameOver){
                for(Ball b : balls){
                    b.release();
                }
                if(paddle.isShooting()){
                    paddle.fire(lasers);
                }
            }
            if(gameOver){ //Same as ESC key.
                returnToMainMenu();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //Do nothing
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //Do nothing
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //Do nothing
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //Do nothing
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mouseMoved(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if(!paused && !gameOver){
                lockMouse(e);
                paddle.move(e.getX());
                for(Ball b : balls){
                    b.moveHeld(paddle.getX());
                }
            }
        }
        
        /**
         * Locks mouse within the screen. WARNING: uses magic numbers.
         * @param e The triggering mouse event.
         */
        private void lockMouse(MouseEvent e){
            final int gameWindowX = mainMenu.getXOnScreen(),
                      gameWindowY = mainMenu.getYOnScreen();
            
            int mouseX = e.getX(),
                mouseY = e.getY();
            if(mouseX < GameBoundaries.LEFT   + paddle.getWidth()/4  ||
               mouseX > GameBoundaries.RIGHT  - paddle.getWidth()/4  ||
               mouseY < GameBoundaries.TOP    + 100                  ||
               mouseY > GameBoundaries.BOTTOM - 100)
                robot.mouseMove(gameWindowX + paddle.getCenterX(), gameWindowY + 400);
        }
    }
}

