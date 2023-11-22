/**
 * This whole file is from practice from the CS drive, and based also with the help and check from the answers
 * https://drive.google.com/drive/folders/1mGOnVXaPmFFuvQRRJYnafRV1Ese7tuMG
 */

import java.awt.Point;

public class Football extends Ball {

    // Variables
    private int width, height;

    // Constructors
    public Football(int w, int h) {
        super(new Point(0, 0));
        this.width = w;
        this.height = h;
    }

    public Football(Football f) {
        super(f.getP());
        this.width = f.width;
        this.height = f.height;
    }

    public void moveLeft(int vector) {
        getP().x -= vector;
        if (getP().x < 0) {
            getP().x = 0;
        }
    }


    public void moveRight(int vector) {
        getP().x += vector;
        if (getP().x > this.width) {
            getP().x = this.width - 1; // End of the field
        }
    }

    public void moveForward(int dist) {
        getP().y += dist;
        if (getP().y > this.height) {
            getP().x = this.height - 1; // End of the field
        }
    }

    public void moveBack(int dist) {
        getP().y -= dist;
        if (getP().y < 0) {
            getP().y = 0;
        }
    }


    @Override
    public String toString() {
        String ans = "";
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (super.getP().x == j && super.getP().y == i) {
                    ans += "o";
                } else if (i == this.height - 1) {
                    ans += "_";
                } else if (j == this.width - 1) {
                    ans += "|";
                } else {
                    ans += " ";
                }
            }
            ans += "\n"; // Going down a line
        }
        return ans;
    }


    public static void main(String[] args) {
        Ball ball = new Ball(new Point(5,6));
        Football football = new Football(20,20);

        System.out.println(football);
    }
}
