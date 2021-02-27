import java.lang.reflect.Array;
import java.util.Scanner;

public class MorseCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to the Morse code translator. To start, press 1 to\ntranslate from Morse code to English or 2 to translate from\nEnglish to Morse code then press enter: ");
        String userChoice = input.nextLine();
        String splitString = "";

        System.out.println(userChoice);

        System.out.println();
        if (userChoice.equals("1")) {
            System.out.print("Please type the English phrase you want to translate.\nPlease only use alphanumeric characters (a-z, 0-9): ");
        } else if (userChoice.equals("2")) {
            System.out.print("Please type the Morse code phrase you want to translate.\nSeparate each letter with a space and each word with a | character.\nExample: '.... . .-.. .-.. --- | .-- --- .-. .-.. -..' (means 'hello world'): ");
            splitString = " ";
        }
        String userInput = input.nextLine();
        System.out.println();
        System.out.println(userInput);
        String[] userInputArr = userInput.split(splitString);

        for(int i=0; i < userInputArr.length; i++){
            System.out.println(userInputArr[i]);
        }

        // String str = ".... . .-.. .-.. --- | .-- --- .-. .-.. -..";
        // String splitLetters = " ";
  
        // String strArray[] = str.split(splitLetters);
        
        
    }

    // public static Array getArray(strInput) {
    //     String userInput = strInput;
    //     return userInput;
    // }
}