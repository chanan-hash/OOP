package ChatBot;

import java.util.Scanner;

public class Chatter {
    public static void main(String[] args) {
        String[] repliesToIllegalRequest1 = {"What ", "say: I should say "};
        String[] repliesToIllegalRequest2 = {"whaaat ", "say what? " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + "? what’s " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + "?"};
        //"say what? " + ILLEGAL_REQUEST_PLACEHOLDER + "? what’s " + ILLEGAL_REQUEST_PLACEHOLDER + "?"

        String[] repliesToLegalRequest1 = {"say " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + "? okay: <phrase>"};
        String[] repliesToLegalRequest2 = {"You want me to say " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + " , do you? alright: " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER};

        ChatterBot[] bots = new ChatterBot[2];
        bots[0] = new ChatterBot("bot1", repliesToLegalRequest1, repliesToIllegalRequest1);
        bots[1] = new ChatterBot("bot2", repliesToLegalRequest2, repliesToIllegalRequest2);

        Scanner scanner = new Scanner(System.in);
        String statement = "orange";
        // To put the foreach loop as an infinte koop we'll put it in a while True loop
        while (true) {
            for (ChatterBot bot : bots) {
                statement = bot.replyTo(statement);
                System.out.print(bot.getName() + ": " + statement);
                scanner.nextLine(); //wait for “enter” before continuing
            }
//        String statement = scanner.nextLine();
//        System.out.println(bots[0].replyTo(statement));

        }
        /*
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; ; i++) {
	        statement = bots[ i % bots.length ].replyTo(statement);
            System.out.print(statement);
        	scanner.nextLine();
        }
         */
    }
}
