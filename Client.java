public class Client {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupBoard();   
        board.printBoard();
        
        board.movePiece(1,1,1,2);
        board.printBoard();
    }
}