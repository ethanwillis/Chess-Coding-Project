public class Client {
    public static void main(String[] args) {
        System.out.println("TEXT-BASED CHESS by Marshal Hayes");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Hello, and welcome to Text-Based Chess by Marshal Hayes!");
        System.out.println("The rules are simple: Play Chess! However, there are a few small things you need to know.");
        System.out.println();
        System.out.println("1. White's pieces are uppercase, and Black's pieces are lowercase.");
        System.out.println("2. Currently, there is no way to capture a piece (i.e. move a piece onto an occupied square)");
        System.out.println();

        Board board = new Board();
        board.setupBoard(); 
        board.printBoard();
    }
}