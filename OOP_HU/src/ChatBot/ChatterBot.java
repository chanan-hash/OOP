package ChatBot;

import java.util.Random;

public class ChatterBot {
    // Getting a Statement and returning it
    // Constants
    static final String REQUEST_PREFIX = "say "; // legal start of a  statement
    static final String RESPONSE_TO_ILLEGAL_REQUEST = "What "; // legal start of a  statement
    static final String REQUESTED_PHRASE_PLACEHOLDER = "<phrase>";

    static final String ILLEGAL_REQUEST_PLACEHOLDER = "<request>";

    static final String RESPONSE_ALL = "<statement>";

    private Random random = new Random();

    private String[] repliesToIllegalRequest; // So we'll be able to pass that String between the method and the constructor.
    // making it from local variable to global one.
    private String[] repliesToLegalRequest;
    private String name = "";

    // constructor of possible answers
    // An empty constructor
    ChatterBot() {
    }

    ChatterBot(String[] repliesToIllegalRequest) {
        // now in every creation of a ChatterBot Object, it will creat a new String a rray/ a copy of it
        // so we can change things in the array for each ChatterBot in separate without changing the other One.
        this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length]; // now field of the class is pointing to the method function, like we've done usually in constructors
        // copying the content
        for (int i = 0; i < repliesToIllegalRequest.length; i++) {
            this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
        }
    }

    ChatterBot(String name, String[] repliesToIllegalRequest) {
        this.name = name;
        this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length]; // now field of the class is pointing to the method function, like we've done usually in constructors
        // copying the content
        for (int i = 0; i < repliesToIllegalRequest.length; i++) {
            this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
        }

    }

    ChatterBot(String name, String[] repliesToLegalRequest, String[] repliesToIllegalRequest) {
        this.name = name;
        this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length]; // now field of the class is pointing to the method function, like we've done usually in constructors
        // copying the content
        for (int i = 0; i < repliesToIllegalRequest.length; i++) {
            this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
        }
        // copying the legal replies
        this.repliesToLegalRequest = new String[repliesToLegalRequest.length];
        for (int i = 0; i < repliesToLegalRequest.length; i++) {
            this.repliesToLegalRequest[i] = repliesToLegalRequest[i];
        }
    }

    public String replyTo(String statement) {
        if (statement.startsWith(REQUEST_PREFIX)) {
//            return statement.substring(4);
//            return statement.replaceFirst("say ","");

//            String phrase = statement.substring(4); // Instead cutting the word in the method 'replyToLegalRequest',
            //  wa can do it here so the method will get only hte part of "word" and not "say word".
//            return replyToLegalRequest(phrase);

            return replyToLegalRequest(statement);

        }
        return replyToIllegalRequest(statement);
    }


    public String replyToIllegalRequest(String statement) {
        int randIndex = random.nextInt(repliesToIllegalRequest.length);// A random number between 0, to array length
        String reply = repliesToIllegalRequest[randIndex];
        // String reply = RESPONSE_TO_ILLEGAL_REQUEST;
        // coins toss - if the number will be heads, so we'll add to RESPONSE, the same word of statement
        //boolean toss = random.nextBoolean(); // Throwing in random, 1 or 0
        if (random.nextBoolean()) {
            reply = reply + statement;
        }
//        return reply;
        return reply.replaceAll(ILLEGAL_REQUEST_PLACEHOLDER, statement.substring(4));
    }

    public String replyToLegalRequest(String statement) {
        int randIndex = random.nextInt(repliesToLegalRequest.length);// A random number between 0, to array length
        String reply = repliesToLegalRequest[randIndex];
//        if (random.nextBoolean()) {
//           reply = reply.replaceAll("<phrase>", statement);
//        }
//        return reply;
        return reply.replaceAll(REQUESTED_PHRASE_PLACEHOLDER, statement.substring(4));
        // we did to statement sub string, to get only the word it self and not "say word" only "word"
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // This method handling possible all kinds of answers legal and illegal
    public String replacePlaceholderInARandomPattern(String[] possibleAns) {
        int rand = random.nextInt(possibleAns.length);
        String ans = possibleAns[rand];
        if (random.nextBoolean()) {
            return ans.replaceAll(RESPONSE_ALL, ans.substring(4)); // adding the statement to the response
        }
        return ans; // Just responding
    }

}

    /*
        public String replyTo(String statement){
           return statement;
        }
     */