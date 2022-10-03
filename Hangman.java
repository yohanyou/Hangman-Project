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
        numberOfIncorrectTries = 0;
        // "default max 6 incorrect tries"
        maxAllowedIncorrectTries = 6;
        // "english alphabet"
        allLetters.append("abcdefghijklmnopqrstuvwxyz");


        //chooses secret word from fixed list
        secretWord = chooseSecretWord();

    }

    //methods
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

    public static String getKnownSoFar() {

        StringBuffer theWord = new StringBuffer();
        for (int k = 0; k < secretWord.length(); k++) {
            int tries = 0;
            for(int j = 0; j < usedLetters.length(); j++){
                if (secretWord.substring(k,k+1).equals(usedLetters.substring(j,j+1))) {
                   theWord.insert(k, usedLetters.substring(j,j+1));
                }
                else 
                {
                    tries ++;
                }
            }
            if(tries == usedLetters.length())
            {theWord.insert(k, "_");}
            
        }

        String outputString = "";

        for (int i = 0; i < theWord.length(); i++){
            outputString += theWord.substring(i,i+1);
        }

        return(outputString);
    };

    //returns # of occurences of letter in secretWord
    public static int tryThis(char letter) {

        //converts char ot String for easier calculations
        String letterToString = "" + letter;

        int occurencesInTheWord = 0;
        String theWord = secretWord.substring(0);
        for (int k = 0; k < secretWord.length(); k++) {
            if (theWord.substring(k, k + 1).equals(letterToString)) {
                occurencesInTheWord++;
            }
        }

        if (occurencesInTheWord == 0)
            {numberOfIncorrectTries++;}

        else
            {usedLetters.append(letterToString);}

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
    public static StringBuffer chooseSecretWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(fixedList.length - 1); // creating a random index to get a word from the list.
        StringBuffer chosenSecretWord = new StringBuffer();
        chosenSecretWord.append(fixedList[randomIndex]);
        return chosenSecretWord;
    }

    // gui

    public static void main(String[] args) {

        Hangman demo = new Hangman();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the letters of the word:");
        while(!hasLost()){
            System.out.println(Hangman.getKnownSoFar());
            char letterGuess = sc.next().charAt(0);
            tryThis(letterGuess);
            System.out.println("");
            System.out.println("here is your guess: ");
            System.out.println(Hangman.getKnownSoFar());
            System.out.println("");
        

            if (demo.getNumOfIncorrectTries() == 1) {
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("          O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");
                System.out.println("|");
            }

            else if (demo.getNumOfIncorrectTries() == 2) {
                System.out.println("");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");
                System.out.println("|");

            }

            else if (demo.getNumOfIncorrectTries() == 3) {
                System.out.println("");
                System.out.println("|_____");
                System.out.println("|");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");
                System.out.println("|");

            }

            else if (demo.getNumOfIncorrectTries() == 4) {
                System.out.println("");
                System.out.println("|__________");
                System.out.println("|");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");
                System.out.println("|");

            }

            else if (demo.getNumOfIncorrectTries() == 5) {
                System.out.println("");
                System.out.println("|__________");
                System.out.println("|         |");
                System.out.println("|          ");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");

            }

            else if (demo.getNumOfIncorrectTries() == 6) {
                System.out.println("");
                System.out.println("|__________");
                System.out.println("|         |");
                System.out.println("|         |");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");
                System.out.println("GAME OVER!!!");
            }
            if(Hangman.getKnownSoFar().substring(0).equals(demo.secretWord.substring(0)))
            {
                System.out.println("YOU WON!");
                break;
            }

        }
        }
    }

