public class Hangman{
    


    Hangman(){

        
    }    

    Hangman (StringBuffer secretWord){
        //used to remove/append to usedLetters (when it gets removed, it becomes "used")
        StringBuffer allLetters = new StringBuffer(26);
        allLetters.append("abcdefghijklmnopqrstuvwxyz");

        //used to record the used letters (to see if the user inputs the same characters)
        StringBuffer usedLetters = new StringBuffer(26);

        int numberOfIncorrectTries = 0;
        int maxAllowedIncorrectTries = 6;

    }
}
