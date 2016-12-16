import java.util.Scanner;
public class Board {    
    private Square[][] board = new Square[8][8];

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // when initializing the board, each square is
                // to be set as empty, and the piece equal to null
                board[i][j] = (new Square(i,j,true,null));
            }
        }
    }

    // setupBoard() puts the pieces in their original starting positions
    public void setupBoard() {
        clearBoard();
       
        // first, the pawns
        for (int x = 0; x < 8; x++) {
            // for white
            board[x][1] = (new Square(x,1,false,(new Pawn(x,1,true))));
            // for black
            board[x][6] = (new Square(x,6,false,(new Pawn(x,6,false))));
        }

        // white's other pieces
        board[0][0] = (new Square(0,0,false,(new Rook(0,0,true))));
        board[1][0] = (new Square(1,0,false,(new Knight(1,0,true))));
        board[2][0] = (new Square(2,0,false,(new Bishop(2,0,true))));
        board[3][0] = (new Square(3,0,false,(new Queen(3,0,true))));
        board[4][0] = (new Square(4,0,false,(new King(4,0,true))));
        board[5][0] = (new Square(5,0,false,(new Bishop(5,0,true))));
        board[6][0] = (new Square(6,0,false,(new Knight(6,0,true))));
        board[7][0] = (new Square(7,0,false,(new Rook(7,0,true))));

        // black's other pieces
        board[0][7] = (new Square(0,7,false,(new Rook(0,7,false))));
        board[1][7] = (new Square(1,7,false,(new Knight(1,7,false))));
        board[2][7] = (new Square(2,7,false,(new Bishop(2,7,false))));
        board[3][7] = (new Square(3,7,false,(new Queen(3,7,false))));
        board[4][7] = (new Square(4,7,false,(new King(4,7,false))));
        board[5][7] = (new Square(5,7,false,(new Bishop(5,7,false))));
        board[6][7] = (new Square(6,7,false,(new Knight(6,7,false))));
        board[7][7] = (new Square(7,7,false,(new Rook(7,7,false))));
    }

    // wrapper for addPiece(x,y,piece) method
    public void addPiece() {
        Piece piece = null;
        boolean color = false;

        String pieceType = javax.swing.JOptionPane.showInputDialog("What piece would you like to add?");

        String whatColor = javax.swing.JOptionPane.showInputDialog("What color?");
        if (whatColor.equalsIgnoreCase("White") || whatColor.equalsIgnoreCase("W")) {
            color = true;
        }
        else if (whatColor.equalsIgnoreCase("Black") || whatColor.equalsIgnoreCase("B")) {
            color = false;
        }

        String coordinate = javax.swing.JOptionPane.showInputDialog("Where would you like to add it?");
        int[] coordinates = determineCoordinate(coordinate);

        int x = coordinates[0];
        int y = coordinates[1];

        if (pieceType.equalsIgnoreCase("Pawn") || pieceType.equalsIgnoreCase("P")) {
            piece = new Pawn(x,y,color);
        }
        else if (pieceType.equalsIgnoreCase("Knight") || pieceType.equalsIgnoreCase("N")) {
            piece = new Knight(x,y,color);
        }
        else if (pieceType.equalsIgnoreCase("Bishop") || pieceType.equalsIgnoreCase("B")) {
            piece = new Bishop(x,y,color);
        }
        else if (pieceType.equalsIgnoreCase("Rook") || pieceType.equalsIgnoreCase("R")) {
            piece = new Rook(x,y,color);
        }
        else if (pieceType.equalsIgnoreCase("Queen") || pieceType.equalsIgnoreCase("Q")) {
            piece = new Queen(x,y,color);
        }
        else if (pieceType.equalsIgnoreCase("King") || pieceType.equalsIgnoreCase("K")) {
            piece = new King(x,y,color);
        }
        else {
            System.out.println("Sorry, an error occurred. Try entering a Chess piece.");
            addPiece();
        }   

        addPiece(x,y,piece);
    }

    // determineCoordinate(coordinate) takes as input a String that is the format of Chess notation (ex: a4, b6, or c2)
    // and returns an array that contains the x and y value of the matching coordinate
    private int[] determineCoordinate(String coordinate) {
        int x = 0;
        if ((coordinate.charAt(0) == 'a')) {
            x = 0;
        }
        else if ((coordinate.charAt(0) == 'b')) {
            x = 1;
        }
        else if ((coordinate.charAt(0) == 'c')) {
            x = 2;
        }
        else if ((coordinate.charAt(0) == 'd')) {
            x = 3;
        }
        else if ((coordinate.charAt(0) == 'e')) {
            x = 4;
        }
        else if ((coordinate.charAt(0) == 'f')) {
            x = 5;
        }
        else if ((coordinate.charAt(0) == 'g')) {
            x = 6;
        }
        else if ((coordinate.charAt(0) == 'h')) {
            x = 7;
        }

        int y = 0;
        if (coordinate.charAt(1) == '1') {
            y = 0;
        }
        else if (coordinate.charAt(1) == '2') {
            y = 1;
        }
        else if (coordinate.charAt(1) == '3') {
            y = 2;
        }
        else if (coordinate.charAt(1) == '4') {
            y = 3;
        }
        else if (coordinate.charAt(1) == '5') {
            y = 4;
        }
        else if (coordinate.charAt(1) == '6') {
            y = 5;
        }
        else if (coordinate.charAt(1) == '7') {
            y = 6;
        }
        else if (coordinate.charAt(1) == '8') {
            y = 7;
        }

        int[] coordinates = {x,y};
        return coordinates;
    }

    // addPiece(x,y,piece) adds a piece to the board at the specified (x,y) location
    private void addPiece(int x, int y, Piece piece) {
        if (piece == null) {
            System.out.println("No piece was added.");
            return;
        }
        
        // if the user tries to add a pawn to rank 1 or rank 8, tell him that he can't do that
        if ((piece instanceof Pawn) && ((y == 7) || (y == 0))) {
            System.err.println("You cannot add a pawn to the rank " + y + ".");
            return;
        }

        if ((board[x][y]).isEmpty()) {
            // if the square is empty, set it equal to the specified piece
            board[x][y] = (new Square(x,y,false,piece));
        }
        else if ((board[x][y]).isEmpty() == false) {
            System.out.println("\n" + "That square is occupied!" + "\n");
            return;
        }
    }

    public void removePiece(int x, int y) {
        // simply change "empty" to true, and piece to null
        board[x][y] = (new Square(x,y,true,null));
    }

    public void clearBoard() {
        initializeBoard();
    }
    
    // Wrapper for movePiece(currentX,currentY,moveToX,moveToY)
    // movePiece() asks the user to enter a move in the format: Ke1-e2
    public void movePiece() {
        // "move" must be in the format of piece, current location of that piece, and where to move that piece
        // (ex: the String "Ke1-e2" would move the King on e1 to e2)
        String move = javax.swing.JOptionPane.showInputDialog("Enter the move");
        
        // create a String[] where the first index is the current piece and its location
        // and the second index is the square to move that piece to
        String[] movement = move.split("-");
        
        String currentPiece = movement[0];
        String moveToHere = movement[1];
        
        int[] currentPieceCoordinate,moveToHereCoordinate;
        
        if (move.charAt(0) != 'K' && move.charAt(0) != 'Q' && move.charAt(0) != 'B' && move.charAt(0) != 'R' && move.charAt(0) != 'N') {
            // if the String move does not specify a piece to move, the user must want to move a pawn
            // (ex: the user could enter d2-d4; no piece is specified so it must be a pawn) <-- Algebraic Chess Notation
            
            // get the (x,y) coordinate of the piece you want to move
            currentPieceCoordinate = determineCoordinate(currentPiece);
        }
        // if the user did specify a piece
        else {
            // get the (x,y) coordinate of the piece you want to move
            // we must delete the piece type (K,Q,B,R,N) from "move" in order to find the coordinate 
            currentPieceCoordinate = determineCoordinate(currentPiece.substring(1,currentPiece.length()));
        }
        
        // get the (x,y) coordinate of the square you want to move that piece to
        moveToHereCoordinate = determineCoordinate(moveToHere);
        
        int currentX = currentPieceCoordinate[0];
        int currentY = currentPieceCoordinate[1];
        int moveToX = moveToHereCoordinate[0];
        int moveToY = moveToHereCoordinate[1];
        
        // now move the piece
        movePiece(currentX,currentY,moveToX,moveToY);
    }

    private void movePiece(int currentX, int currentY, int moveToX, int moveToY) {
        Square current = board[currentX][currentY];
        Square desired = board[moveToX][moveToY];

        if (current.isEmpty()) {
            System.err.println("There's no piece on " + current.getNotation() + ".");
            return;
        }
        
        if (desired.isEmpty() == false) {
            System.err.println("As of right now, you cannot capture any pieces.");
            return;
        }

        boolean color = current.getPiece().getColor();
        if (current.getPiece() instanceof Pawn) {
            if (currentX != moveToX) {
                System.err.println("Pawns can only move straight except when capturing pieces.");
                return;
            }
            removePiece(currentX,currentY);
            addPiece(moveToX,moveToY,(new Pawn(moveToX,moveToY,color)));
        }
        else if (current.getPiece() instanceof King) {
            removePiece(currentX,currentY);
            addPiece(moveToX,moveToY,(new King(moveToX,moveToY,color)));
        }
        else if (current.getPiece() instanceof Queen) {
            removePiece(currentX,currentY);
            addPiece(moveToX,moveToY,(new Queen(moveToX,moveToY,color)));
        }
        else if (current.getPiece() instanceof Bishop) {
            removePiece(currentX,currentY);
            addPiece(moveToX,moveToY,(new Bishop(moveToX,moveToY,color)));
        }
        else if (current.getPiece() instanceof Knight) {
            removePiece(currentX,currentY);
            addPiece(moveToX,moveToY,(new Knight(moveToX,moveToY,color)));
        }
        else if (current.getPiece() instanceof Rook) {
            removePiece(currentX,currentY);
            addPiece(moveToX,moveToY,(new Rook(moveToX,moveToY,color)));
        }
    }

    public void printBoard(boolean color) {
        // printBoard(color) prints from White's perspective when color is true 
        // and prints from Black's perspective when color is false
        if (color == true) {
            System.out.println();
            String[] alphabet = {"8","7","6","5","4","3","2","1"};
            System.out.println("\t" + "     BLACK" + "\t");
            System.out.println("--------------------------------");

            int i = 0;
            for (int x = 7; x >= 0; x--, i++) {
                for (int y = 0 ; y < 8; y++) {
                    if ((board[y][x]).getPiece() != null) {
                        if ((board[y][x].getPiece().getColor() == false)) {
                            // if the piece is black, print it in lowercase
                            String s = (board[y][x]).getPiece().toString();
                            System.out.print("| " + s.toLowerCase() + " ");
                        }
                        else {
                            // otherwise, print it normally (in uppercase)
                            System.out.print("| " + (board[y][x]).getPiece() + " ");
                        }
                    }
                    else {
                        System.out.print("|  " + " ");
                    }
                }
                System.out.println("  " + alphabet[i] + " ");
                System.out.println("--------------------------------");
            }
            System.out.println("  a   b   c   d   e   f   g   h  ");
            System.out.println("\t" + "     WHITE" + "\t");
            System.out.println();
        }
        else if (color == false) {
            System.out.println();
            String[] alphabet = {"8","7","6","5","4","3","2","1"};
            System.out.println("\t" + "     WHITE" + "\t");
            System.out.println("--------------------------------");

            int i = 7;
            for (int x = 0; x < 8; x++, i--) {
                for (int y = 7 ; y >= 0; y--) {
                    if ((board[y][x]).getPiece() != null) {
                        if ((board[y][x].getPiece().getColor() == false)) {
                            // if the piece is black, print it in lowercase
                            String s = (board[y][x]).getPiece().toString();
                            System.out.print("| " + s.toLowerCase() + " ");
                        }
                        else {
                            // otherwise, print it normally (in uppercase)
                            System.out.print("| " + (board[y][x]).getPiece() + " ");
                        }
                    }
                    else {
                        System.out.print("|  " + " ");
                    }
                }
                System.out.println("  " + alphabet[i] + " ");
                System.out.println("--------------------------------");
            }
            System.out.println("  h   g   f   e   d   c   b   a  ");
            System.out.println("\t" + "     BLACK" + "\t");
            System.out.println();
        }
    }
}