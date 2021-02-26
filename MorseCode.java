import java.util.Scanner;

public class MorseCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput;

        System.out.print("Welcome to the Morse code translator. To start, press 1 to\ntranslate from Morse code to English or 2 to translate from\nEnglish to Morse code then press enter: ");
        int userChoice = input.nextInt();

        // System.out.println();
        if (userChoice == 1) {
            System.out.print("Please type the English phrase you want to translate.\nPlease only use alphanumeric characters (a-z, 0-9): ");
        } else {
            System.out.print("Please type the Morse code phrase you want to translate.\nSeparate each letter with a space and each word with a | character.\nExample: '.... . .-.. .-.. --- | .-- --- .-. .-.. -..' (means 'hello world') ");
        }
        userInput = input.next();
        System.out.println(userInput);
    }
}