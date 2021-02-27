import java.util.Arrays;
import java.util.Scanner;

public class MorseCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to the Morse code translator. To start, press 1 to\ntranslate from Morse code to English or 2 to translate from\nEnglish to Morse code then press enter: ");
        int userChoice = input.nextInt();
        input.nextLine();
        
        String[] theArray = getUserPhrase(userChoice, input);
           
        translateUserPhrase(theArray, userChoice);

        // String[] name = {"H", "E", "Y"};

        // String[] englishChars = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
        //                         "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2",
        //                         "3", "4", "5", "6", "7", "8", "9", "0"};

        // int index = Arrays.asList(englishChars).indexOf("Y");

        // for (int i = 0; i < name.length; i++) {
        //     int index = Arrays.asList(englishChars).indexOf(name[i]);
        //     System.out.println(index);
        // }

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

        String userInput = userInputNum == 1 ? scan.nextLine() : scan.nextLine().toUpperCase();

        String[] userInputArr = userInput.split(splitString);

        System.out.println(userInputArr.length);

        // for (int i = 0; i < userInputArr.length; i++) {
        //     System.out.println("Content: " + userInputArr[i] + "\t Length: " + userInputArr[i].length());
        // }

        return userInputArr;
    }

    public static void translateUserPhrase(String[] arrInput, int choiceNum) {
        // String[][] englishMorse = {{".-", "A"}, {"-...", "B"}, {"-.-.", "C"}, {"-..", "D"}, {".", "E"}, 
        //                             {"..-.", "F"}, {"--.", "G"}, {"....", "H"}, {"..", "I"}, {".---", "J"},
        //                             {"-.-", "K"}, {".-..", "L"}, {"--", "M"}, {"-.", "N"}, {"---", "O"},
        //                             {".--.", "P"}, {"--.-", "Q"}, {".-.", "R"}, {"...", "S"}, {"-", "T"},
        //                             {"..-", "U"}, {"...-", "V"}, {".--", "W"}, {"-..-", "X"}, {"-.--", "Y"},
        //                             {"--..", "Z"}, {".----", "1"}, {"..---", "2"}, {"...--", "3"}, {"....-", "4"},
        //                             {".....", "5"}, {"-....", "6"}, {"--...", "7"}, {"---..", "8"}, {"----.", "9"},
        //                             {"-----", "0"}};

        // int[] inputtedArrIndexes = new int[arrInput.length];

        // for (int i = 0; i < arrInput.length; i++) {
        //     inputtedArrIndexes[i] = 
        // }

        String[] englishChars = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
                                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2",
                                "3", "4", "5", "6", "7", "8", "9", "0"};

        String[] morseChars = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                                "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", 
                                "....-", ".....", "-....", "--...", "---..", "----.", "-----"};
        
        String[] arrTranslated = new String[arrInput.length];

        if (choiceNum == 1) {
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

        String response = String.join(" ", arrTranslated);

        // for (int k = 0; k < arrTranslated.length; k++) {
        //     System.out.println(arrTranslated[k]);
        // }

        System.out.println(response);
    }
}