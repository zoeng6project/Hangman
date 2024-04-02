import java.util.Scanner;

public class Hangman_Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a number (1-30) for your word choice: ");
        int choice = scanner.nextInt();
        Hangman wordChoice = new Hangman();
        String selectedWord = wordChoice.returnWordChoice(choice);

        while (selectedWord == null ){
            System.out.println("Invalid input. Please choose a number from 1 to 30. ");
            choice = scanner.nextInt();
            selectedWord = wordChoice.returnWordChoice(choice);
        }
        String empty = wordChoice.returnEmptyWord(selectedWord);
        //System.out.println("selectedWord: "+selectedWord);
        System.out.println("selected word : "+empty);
        char[] emptyArray = empty.toCharArray();
        char[] emptyGuess1 = emptyArray.clone();

        while ( wordChoice.win <= 7 ){
            System.out.println("Guess a letter. ");
            char letter = scanner.next().toUpperCase().charAt(0);
            char [] emptyGuess = wordChoice.returnEmptyGuess( letter, selectedWord , emptyGuess1);
            emptyGuess1 = emptyGuess.clone();
            int win = wordChoice.returnImage(wordChoice.win);
            System.out.println("Guess the word or input 'hint'.  ");
            String hint = scanner.next().toUpperCase();
            wordChoice.returnHint(selectedWord , choice, hint , empty );
        }

        System.out.println("Answer is: " + selectedWord);

    }
}
