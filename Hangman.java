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
    Hangman(){
        //generating a random number
        Random randomWord = new Random();
        int randomNumber = randomWord.nextInt(fixedList.length-1);
        
        numberOfIncorrectTries = 0;
        //"default max 6 incorrect tries"
        maxAllowedIncorrectTries = 6;
        //"english alphabet"
        allLetters.append("abcdefghijklmnopqrstuvwxyz");
        //"chooses secretWord from fixed list"
        secretWord.append(fixedList[randomNumber]);
        
        
    }

    public int getNumOfIncorrectTries()
    {
        return numberOfIncorrectTries;
    }

    // gui
    // not 100% ready waiting others to complete..

    
    public static void main(String [] args){

    
        Hangman demo = new Hangman();
        int numberOfIncorrectTries = demo.getNumOfIncorrectTries();

        while(numberOfIncorrectTries<=6)

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
