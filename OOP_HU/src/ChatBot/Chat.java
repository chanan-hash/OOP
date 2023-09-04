package ChatBot;

import ChatBot.ChatterBot2;

import java.util.Arrays;
import java.util.Scanner;


public class Chat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String statement = sc.nextLine(); // The argument 'statement' getting by nextLine() an input form outside/user.

        String [] repliesToIllegalRequest = {"What ", "say: I should say "};

        // creating 2 bots that speaking which each other

//        ChatterBot bot = new ChatterBot(repliesToIllegalRequest); // we didn't define a constructor, so java has a default constructor that doesn't get anything and doesn't do anything
//        while (!statement.equals("Exit")) {
//            String reply = bot.replyTo(statement);
//            System.out.println(reply);
//            statement = sc.nextLine();
//        }
//        System.out.println("Bye!");


//        String legalRequest = ChatterBot.REQUEST_PREFIX + "hello";
//        ChatterBot[] bots = {new ChatterBot(), new ChatterBot()};
//        String statement2 = "hello";
//        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; ; i = (i + 1) % 2) { // The mod is for each iteration it's the other bot
//            statement2 = bots[i].replyTo(statement2);
//            System.out.println("bot " + i + " said: " + statement2);
//            scanner.nextLine();
//        }

        ChatterBot2[] bots = new ChatterBot2[2];
        bots[0] = new ChatterBot2(repliesToIllegalRequest);
        repliesToIllegalRequest[1] = "say say he";
        bots[1] = new ChatterBot2(repliesToIllegalRequest);

        int curBot = 0;
        String stem = "";
        while (true){
            stem = bots[curBot].replyTo(stem);
            System.out.print(stem);
            sc.nextLine();
            curBot = (curBot + 1) % 2;
            // curBot = 1 - curBot;
        }
    }


    /**
     * calculate factorial for input
     *
     * @param n -  a positive integer
     * @return factorial of n
     */
    public static int solve(int n) {
        //implemt your code here
        if (n <= 1) {
            return 1;
        }
        return solve(n - 1) * n;
    }

    public static int[] sort(int[] triplet) {
        //implement your code here
        Arrays.sort(triplet);
        return triplet;
    }
}