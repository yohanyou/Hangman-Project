import java.util.Random;

public class Hangman {

    // properties
    StringBuffer secretWord;
    StringBuffer allLetters;
    StringBuffer usedLetters;
    int numberOfIncorrectTries = 0;
    int maxAllowedIncorrectTries;
    StringBuffer knownSoFar;
    // list of words that can be selected from
    String[] fixedList = { "banana", "apple", "watermelon", "kiwi", "dragonfruit" };

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

        chooseSecretWord();
    }

    public int getNumOfIncorrectTries() {
        return numberOfIncorrectTries;
    }

    public String getAllLetters() {
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

    public String getKnownSoFar() {

        String theWord = "";
        for (int k = 0; k < secretWord.length(); k++) {
            if (secretWord.substring(0).substring(k, k + 1).equals(usedLetters.substring(k, k + 1))) {
                knownSoFar.setCharAt(k, usedLetters.charAt(k));
            } else {
                knownSoFar.setCharAt(k, '_');
            }
        }
        theWord = knownSoFar.substring(0);
        return theWord;
    }

    public int tryThis(char letter) {

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
    public boolean hasLost() {
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
    private String chooseSecretWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(fixedList.length); // creating a random index to get a word from the list.
        return fixedList[randomIndex];
    }

    // gui
    // not 100% ready waiting others to complete..

    public static void main(String[] args) {

        Hangman demo = new Hangman();
        int numberOfIncorrectTries = demo.getNumOfIncorrectTries();

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

            else if (numberOfIncorrectTries == 5) {
                System.out.println("|__________");
                System.out.println("|         |");
                System.out.println("|         |");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        / \"");

            }

        }

    }
}
