package TicTacToe;

public class Arr2D {
    public static void main(String[] args) {
        float[][] pic = {
                {0,1,0,1},
                {1,0,1,0},
                {0,1,0,1}
        };
        float avg = 0;
        for (int row = 0; row < pic.length; row++) {
            for (int col = 0; col < pic[row].length; col++) {
                avg += pic[row][col];
            }
        }
        avg /= (pic.length * pic[0].length);
        System.out.println("Tha average is: " + avg);
        System.out.println((false && false));
    }


//    public static void main(String[] args) {
//        //the Image.loadImage() function in just for initializing the 2D pixels array.
//        char[][] pixels = Image.loadImage();
//
//        //write you answer here to "inverse" the picture
//        for (int i = 0; i < pixels.length; i++) {
//            for (int j = 0; j < pixels[i].length; j++) {
//                if (pixels[i][j] == '*') {
//                    pixels[i][j] = '-';
//                } else {
//                    pixels[i][j] = '*';
//                }
//            }
//
//            //this function get the 2D-array and print it to the screen.
//            // pay attention, if you run the code without any changes,
//            // the image will printe to screen with "black" background
//            Image.printImage(pixels);
//        }
//    }

}
