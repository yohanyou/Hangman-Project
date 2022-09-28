import java.util.Random;
public class Hangman{
    
    //properties
    StringBuffer secretWord;
    StringBuffer allLetters;
    StringBuffer usedLetters;
    int numberOfIncorrectTries;
    int maxAllowedIncorrectTries;
    StringBuffer knownSoFar;
    //list of words that can be selected from
    String[] fixedList = {"banana", "apple", "watermelon", "kiwi", "dragonfruit"};
    
        
    //constructor
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
    
}
