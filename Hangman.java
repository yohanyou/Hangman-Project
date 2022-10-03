import java.util.Random;
import java.util.Scanner;

public class Hangman {

    // properties
    static StringBuffer secretWord = new StringBuffer();
    static StringBuffer allLetters = new StringBuffer();
    static StringBuffer usedLetters = new StringBuffer();
    static int numberOfIncorrectTries;
    static int maxAllowedIncorrectTries;
    static StringBuffer knownSoFar = new StringBuffer();
    // list of words that can be selected from
    static String[] fixedList = { "banana", "apple", "watermelon", "kiwi", "dragonfruit" };

    // constructor
    Hangman() {
        
        // generating a random number
        Random randomWord = new Random();
        int randomNumber = randomWord.nextInt(fixedList.length - 1);

        numberOfIncorrectTries = 0;
        // "default max 6 incorrect tries"
        maxAllowedIncorrectTries = 6;
        // "english alphabet"
        allLetters.append("abcdefghijklmnopqrstuvwxyz");
        // "chooses secretWord from fixed list"
        secretWord.append(fixedList[randomNumber]);
        knownSoFar.append(secretWord);
        usedLetters.append("0");

        chooseSecretWord();

    }

    public int getNumOfIncorrectTries() {
        return numberOfIncorrectTries;
    }

    public static String getAllLetters() {
        String str = allLetters.toString();
        return str;
    }

    public String getUsedLetters() {
        String str = usedLetters.toString();
        return str;
    }

    public int getMaxAllowedIncorrectTries() {
        return maxAllowedIncorrectTries;
    }

    public static StringBuffer getKnownSoFar() {

        StringBuffer theWord = new StringBuffer();
        for (int k = 0; k < secretWord.length(); k++) {
            for(int j = 0; j < usedLetters.length(); j++){
                if (secretWord.substring(k).equals(usedLetters.substring(j))) {
                   theWord.insert(k, usedLetters.substring(j));
                }
                else {
                    theWord.insert(k, "_");
                }
            
            }
        }
        //theWord = knownSoFar.substring(0); // why we need it?
        //return theWord;
        return(theWord);
    };

    public static int tryThis(char letter) {

        int occurencesInTheWord = 0;
        String theWord = secretWord.substring(0);
        for (int k = 0; k < secretWord.length(); k++) {
            if (theWord.substring(k, k + 1).equals(letter)) {
                occurencesInTheWord++;
            }
        }
        return occurencesInTheWord;
    }

    /**
     * Checks if player has lost or not and decides game is over or not.
     * 
     * @return
     */
    public boolean isGameOver() {
        if (hasLost() == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * If incorrect tries surpasses allowed limit, it means player has lost
     * 
     * @return
     */
    public static boolean hasLost() {
        if (numberOfIncorrectTries > maxAllowedIncorrectTries) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Finds a random index and then according to that index chooses random word
     * from the list.
     * 
     * @return
     */
    public static String chooseSecretWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(fixedList.length); // creating a random index to get a word from the list.
        return fixedList[randomIndex];
    }

    // gui
    // not 100% ready waiting others to complete..

    public static void main(String[] args) {

        Hangman demo = new Hangman();
        int numberOfIncorrectTries = demo.getNumOfIncorrectTries();
        Scanner sc = new Scanner(System.in);

        chooseSecretWord();
        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the letters of the word:");
        while(!hasLost()){
        char letterGuess = sc.next().charAt(0);
        tryThis(letterGuess);
        System.out.println(getKnownSoFar());
        while (numberOfIncorrectTries <= 6)

        {

            if (numberOfIncorrectTries == 1) {
                System.out.println("");
                System.out.println("");
                System.out.println("          O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");
                System.out.println("|");
            }

            else if (numberOfIncorrectTries == 2) {
                System.out.println("|");
                System.out.println("|");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");
                System.out.println("|");

            }

            else if (numberOfIncorrectTries == 3) {
                System.out.println("|_____");
                System.out.println("|");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");
                System.out.println("|");

            }

            else if (numberOfIncorrectTries == 4) {
                System.out.println("|__________");
                System.out.println("|");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");
                System.out.println("|");

            }

            else if (numberOfIncorrectTries == 5) {
                System.out.println("|__________");
                System.out.println("|         |");
                System.out.println("|          ");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");

            }

            else if (numberOfIncorrectTries == 6) {
                System.out.println("|__________");
                System.out.println("|         |");
                System.out.println("|         |");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");
                System.out.println("GAME OVER!!!");



            }

        }
        }
    }
}