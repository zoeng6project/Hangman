
public class Hangman {
    public String[] SetOne = {"TORONTO","MONTREAL","CALGARY","VANCOUVER","OTTAWA","EDMONTON","QUEBEC","WINNIPEG","HALIFAX","VICTORIA"};
    public String[] SetTwo = {"RED","BLUE","GREEN","YELLOW","ORANGE","PURPLE","PINK","BROWN","GRAY","BLACK"};
    public String[] SetThree = {"SOCCER","TENNIS","GOLF","SWIMMING","HOCKEY","BASEBALL","BADMINTON","CURLING","SKIING","RUGBY"};

    int win = 0;
    int haveLetter = 0;


    public String returnWordChoice(int choice) {
        if (choice > 0 && choice <= 10) {
            return SetOne[choice - 1];
        } else if (choice > 10 && choice <= 20) {
            return SetTwo[choice -11];
        } else if (choice > 20 && choice <= 30) {
            return SetThree[choice - 21];
        } else {
            return null;
        }
    }

    public String returnEmptyWord(String selectedWord){
        char[] empty = new char[selectedWord.length()];

        for (int i =0 ; i<selectedWord.length(); i++) {
            empty[i] = '_';
        }
         win = 0;
        return new String(empty);
    }

    public char[] returnEmptyGuess(char letter, String selectedWord , char[] emptyGuess1){
        char[] emptyGuess = emptyGuess1.clone();
        haveLetter = 0;

        for (int i =0 ; i<selectedWord.length(); i++) {
            if (emptyGuess[i] == '_') {
                if (letter == selectedWord.charAt(i)) {
                    emptyGuess[i] = letter;
                    haveLetter++;
                } else {
                    emptyGuess[i] = '_';
                }
            }
            else {
            };
        }
        if (haveLetter == 0) {
            win++ ;
        }
        else {};

        for (char c : emptyGuess) {
            System.out.print(c );
        }
        System.out.println("");
        System.out.println("incorrect count:" + win);
        return  emptyGuess;

    }

    public int returnImage(int win){
        switch (win) {
            case 0:
                System.out.println("-------");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 1:
                System.out.println("-------");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 2:
                System.out.println("-------");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 3:
                System.out.println("-------");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 4:
                System.out.println("-------");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("      |");

                break;
            case 5:
                System.out.println("-------");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 6:
                System.out.println("-------");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("      |");
                break;
            case 7:
                System.out.println("-------");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("      |");
                System.out.println("*** Last Chance !! ***");
                this.win = 11;
                break;
            default:
                System.out.println(" ");
                break;
        }
        return win;
    }



    public String returnHint(String selectedWord ,int choice,String hint ,String empty ){
        if(hint.equals(selectedWord)) {
            System.out.println("Congratulation !! ");
             this.win = 10;
        }
        else if(hint.equals("HINT") ) {
            if (choice <= 10 ) {
                System.out.println("Hint : cities in Canada " );
            }
            if (choice >= 11 && choice <= 20 ) {
                System.out.println("Hint : colour " );
            }

            if (choice >= 21 && choice <= 30 ) {
                System.out.println("Hint : sport ");
            }
        }
        else {
            System.out.println("Sorry, it's not correct, keep it up! ");
        }
        System.out.println("");

        return empty;

    }

}