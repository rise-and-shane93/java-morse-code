import java.util.Arrays;
import java.util.Scanner;

public class MorseCode {
    public static void main(String[] args) {

        // Initialize scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to the Morse code translator. To start, press 1 to\ntranslate from Morse code to English or 2 to translate from\nEnglish to Morse code then press enter: ");
        int userChoice = input.nextInt(); // get user choice
        input.nextLine(); // clears the next line in order for the user phrase to properly input
        
        String[] theArray = getUserPhrase(userChoice, input); // getUserPhrase method to convert the user input to an array
           
        translateUserPhrase(theArray, userChoice); // translateUserPhrase method to output the translated phrase

    }

    // converts the user input to an array. Takes the user choice and scanner as arguments
    public static String[] getUserPhrase(int choiceNum, Scanner scan) {
        int userInputNum = choiceNum;
        
        /* String to use to split the input into an array. If the user wants to translate English to Morse,
        then each letter and space will be one element in the array. If it's vice versa, then
        each sequence of Morse characters will be an element */
        String splitString = "";

        if (userInputNum == 1) {
            System.out.print("Please type the English phrase you want to translate.\nPlease only use alphanumeric characters (a-z, 0-9): ");
        } else if (userInputNum == 2) {
            System.out.print("Please type the Morse code phrase you want to translate.\nSeparate each letter with a space and each word with a | character.\nExample: '.... . .-.. .-.. --- | .-- --- .-. .-.. -..' (means 'hello world'): ");
            splitString = " ";
        }

        // Only convert to uppercase if the user input is alphanumeric
        String userInput = userInputNum == 1 ? scan.nextLine().toUpperCase() : scan.nextLine();

        // split and return the resultant array
        String[] userInputArr = userInput.split(splitString);

        return userInputArr;
    }

    // translates the phrase to the other language. Takes the array version of the user input and user choice as arguments
    public static void translateUserPhrase(String[] arrInput, int choiceNum) {

        // Similar to the splitString variable in the getUserPhrase method
        String joinString = "";

        // Initialize english/morse alphabets and numbers in the same order
        String[] englishChars = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
                                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2",
                                "3", "4", "5", "6", "7", "8", "9", "0"};

        String[] morseChars = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                                "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", 
                                "....-", ".....", "-....", "--...", "---..", "----.", "-----"};
        
        // Initialize translated array with the correct length
        String[] arrTranslated = new String[arrInput.length];

        /* If user translates english to morse, set the joinString variable to one space,
        replace the space between words (if any) with a pipe character, and build the array
        with the translated characters.
        
        Otherwise, replace the pipe character with a space and keep the joinString variable's value
        to 0 spaces. */
        if (choiceNum == 1) {
            joinString = " ";
            for (int j = 0; j < arrInput.length; j++) {
                if (arrInput[j].equals(" ")) {
                    arrTranslated[j] = "|";
                } else {
                    arrTranslated[j] = morseChars[Arrays.asList(englishChars).indexOf(arrInput[j])];
                }
            }
        } else {
            for (int k = 0; k < arrInput.length; k++) {
                if (arrInput[k].equals("|")) {
                    arrTranslated[k] = " ";
                } else {
                    arrTranslated[k] = englishChars[Arrays.asList(morseChars).indexOf(arrInput[k])];
                }
            }

        }

        // join the array with the correct delimiter and the translated array
        String response = String.join(joinString, arrTranslated);

        System.out.println(response);
    }
}