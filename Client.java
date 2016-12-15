import java.util.Scanner;

public class Client {
    private static Board board = new Board();
    
    // play() performs the necessary tasks to let the user play Chess 
    public static void play() {
        double Carlsen = 6.3;
        double Karjakin = 6.1;
        
        Scanner s = new Scanner(System.in);
        
        // set the persective view of the board to white initially
        boolean color = true;
        
        do {            
            System.out.println("What would you like to do?");
            System.out.println("1 Add a piece, 2 Move a piece, 3 Flip the Board, 4 Clear the Board, 5 Setup starting position, 6 Terminate");
            int input = s.nextInt();
            
            if (input == 1) {
                board.addPiece();
                board.printBoard(color);
            }
            else if (input == 2) {
                // board.movePiece();
            }
            else if (input == 3) {
                // if the color was initially set to White's view, change it to Black's and vice versa                
                color = !color;
                board.printBoard(color);
            }
            else if (input == 4) {
                board.clearBoard();
                board.printBoard(color);
            }
            else if (input == 5) {
                board.setupBoard();
                board.printBoard(color);
            }
            else if (input == 6) {
                return;
            }
        }
        while (Carlsen > Karjakin);
    }
    
    public static void main(String[] args) {
        System.out.println("TEXT-BASED CHESS by Marshal Hayes");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Hello, and welcome to Text-Based Chess by Marshal Hayes!");
        System.out.println("The rules are simple: Play Chess! However, there are a few small things you need to know.");
        System.out.println();
        System.out.println("1. White's pieces are uppercase, and Black's pieces are lowercase.");
        System.out.println("2. Currently, there is no way to capture a piece (i.e. move a piece onto an occupied square)");
        
        // print the empty board from white's perspective initially
        board.printBoard(true);
    
        play();
        
        System.out.println();
        System.out.println("Thanks for playing!");
        System.out.println("If you enjoyed this text-based Chess program, please share it!");
    }
}