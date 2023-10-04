/**
 * This game was built according to:
 * https://www.youtube.com/watch?v=bI6e6qjJ8JQ&t=173s
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    // Variables
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25; // How big we want the objects in this game
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE; // How many objects we can fit on the screen
    static final int DELAY = 75;

    // Tow arrays for the snake body parts including the head
    final int[] x = new int[GAME_UNITS]; // The snake won't be bigger than the game itself
    final int[] y = new int[GAME_UNITS];
    int bodyParts = 6; // the snake size int the beginning
    int appleEaten = 0;
    int appleX; // Coordinates of the apple
    int appleY;
    char direction = 'R'; // In which direction the snake will start. 'R' - right, 'L' - left, 'U' - up, 'D' - down
    boolean running = false;
    Timer timer;
    Random random; // For throwing the apples

    // Constructors
    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter()); // Key listener

        // Calling the game's panel method
        startGame();

    }

    public void startGame() {
        // In the beginning of the game we want to have a new apple on the screen
        newApple();
        running = true; // So the snake will start to run\move
        timer = new Timer(DELAY, this); // This will dictate how fast the game will run
        timer.start();
    }

    public void paintComponent(Graphics g) {
        // Coloring it on black
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // Drawing a grid on the screen
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                // giving start and end coordinates
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // Drawing the snake
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) { // Head of the snake
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else { // The rest of the body parts
//                    g.setColor(new Color(45, 180, 0));
                    // In each time throwing a new color for the snake
                    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            // Showing the score
            g.setColor(Color.cyan);
            g.setFont(new Font("Ink Free", Font.BOLD, 30));
            FontMetrics metrics = getFontMetrics(g.getFont()); // TO put it on the middle of the screen
            g.drawString("Score: " + appleEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + appleEaten)) / 2, g.getFont().getSize()); // Put it on the top

        } else {
            gameOver(g);
        }
    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

    }

    public void move() {
        // A loop that going over al the body parts
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) { // Changes the direction of the snake's is headed
            case 'U' -> y[0] = y[0] - UNIT_SIZE;
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
            case 'R' -> x[0] = x[0] + UNIT_SIZE;
        }
    }

    // To get score
    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            appleEaten++;
            newApple();// To generate a new apple for us
        }
    }

    // Checking if losing
    public void checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && y[0] == y[i]) { // if the head (x[0], y[0]) is equal to another body part, it means we have a collision
                running = false; // Game Over
            }
        }
        // Checking if the head of the snake touching any borders
        // Left border
        if (x[0] < 0) {
            running = false;
        }
        // Right border
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }
        // TOP border
        if (y[0] < 0) {
            running = false;
        }
        // Bottom border
        if (y[0] > SCREEN_HEIGHT) {
            running = false;
        }
        if (!running) { // If running == false
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        // Here we also will want to write some text on the screen
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics1 = getFontMetrics(g.getFont()); // TO put it on the middle of the screen
        g.drawString("Game Over", (SCREEN_WIDTH - metrics1.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);

        // Showing the score after the game have ended
        g.setColor(Color.orange);
        g.setFont(new Font("Ink Free", Font.BOLD, 30));
        FontMetrics metrics2 = getFontMetrics(g.getFont()); // TO put it on the middle of the screen
        g.drawString("Score: " + appleEaten, (SCREEN_WIDTH - metrics2.stringWidth("Score: " + appleEaten)) / 2, g.getFont().getSize()); // Put it on the top

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        // if the game is no longer running
        repaint();
    }

    // Creating inner class
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) { // controlling the snake movement
                case KeyEvent.VK_LEFT -> // we don't want the snake just do 180 degrees turn, then it will collide it's head
                // We'll limit the movement for 90 degrees turn, if it is not going right. you can turin left
                {
                    if (direction != 'R') {
                        direction = 'L';
                    }
                }
                case KeyEvent.VK_RIGHT -> {
                    if (direction != 'L') {
                        direction = 'R';
                    }
                }
                case KeyEvent.VK_UP -> {
                    if (direction != 'D') {
                        direction = 'U';
                    }
                }
                case KeyEvent.VK_DOWN -> {
                    if (direction != 'U') {
                        direction = 'D';
                    }
                }
            }
        }
    }

}
