/**
 * This game was built according to:
 * https://www.youtube.com/watch?v=bI6e6qjJ8JQ&t=173s
 */

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    GameFrame() {
//    GamePanel panel = new GamePanel();
//    this.add(panel);

        // Building the GUI of the Game
        this.add(new GamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); // Won't be able to resize the frame of the game
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null); // If we want it to be in the middle of the screen

        // till here crating a small frane in the middle of the screen
    }


}
