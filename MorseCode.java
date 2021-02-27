import java.lang.reflect.Array;
import java.util.Scanner;

public class MorseCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to the Morse code translator. To start, press 1 to\ntranslate from Morse code to English or 2 to translate from\nEnglish to Morse code then press enter: ");
        int userChoice = input.nextInt();
        input.nextLine();
        System.out.println(userChoice);
        
        String[] theArray = getUserPhrase(userChoice, input);

        // for(int i=0; i < theArray.length; i++){
        //     System.out.println(theArray[i]);
        // }
           
        translateUserPhrase(theArray, userChoice);
    }

    public static String[] getUserPhrase(int choiceNum, Scanner scan) {
        int userInputNum = choiceNum;
        String splitString = "";

        if (userInputNum == 1) {
            System.out.print("Please type the English phrase you want to translate.\nPlease only use alphanumeric characters (a-z, 0-9): ");
        } else if (userInputNum == 2) {
            System.out.print("Please type the Morse code phrase you want to translate.\nSeparate each letter with a space and each word with a | character.\nExample: '.... . .-.. .-.. --- | .-- --- .-. .-.. -..' (means 'hello world'): ");
            splitString = " ";
        }

        String userInput = scan.nextLine();

        String[] userInputArr = userInput.split(splitString);

        return userInputArr;
    }

    public static void translateUserPhrase(String[] arrInput, int choiceNum) {
        String[][] englishMorse = {{".-", "A"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."}, 
                                    {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
                                    {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
                                    {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                                    {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
                                    {"Z", "--.."}, {"1", ".----"}, {"2", "..---"}, {"3", "...--"}, {"4", "....-"},
                                    {"5", "....."}, {"6", "-...."}, {"7", "--..."}, {"8", "---.."}, {"9", "----."},
                                    {"0", "-----"}};
        
        String[] arrTranslated = new String[arrInput.length];
        
        for (int i = 0; i < arrInput.length; i++) {
            arrTranslated[i] = englishMorse[i][choiceNum - 1];
        }

        // String response = arrTranslated.join("");

        for (int j = 0; j < arrTranslated.length; j++) {
            System.out.println(arrTranslated[j]);
        }
    }
}