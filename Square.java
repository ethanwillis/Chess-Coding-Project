import javafx.util.Pair;
public class Square
{
    // piece stores what Piece occupies the square
    private Piece piece;
    
    // point stores the point (x,y);
    private Pair<Integer,Integer> point;
    
    // x,y are the coordinates for the square
    private int x,y;
    
    // empty is true when the square is empty (i.e. no piece occupies the square)
    private boolean empty;
    
    public Square(int x, int y, boolean empty, Piece piece) {
        this.x = x;
        this.y = y;
        this.empty = empty;
        
        point = new Pair<>(x,y);
        
        // this is to ensure that no piece can occupy an empty square
        if (empty == true) {
            piece = null;
        }
        else {
            this.piece = piece;
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Pair<Integer,Integer> getPoint() {
        return point;
    }

    // getPiece() returns the Piece at the calling Square
    public Piece getPiece() {
        return piece;
    }
    
    // getNotation() returns the Chess notation of the calling Square
    public String getNotation() {
        if (x == 0) {
            if (y == 0) {
                // board[0][0] 
                return "a1";
            }
            else if (y == 1) {
                // board[0][1]
                return "a2";
            }
            else if (y == 2) {
                // board[0][2]
                return "a3";
            }
            else if (y == 3) {
                // board[0][3]
                return "a4";
            }
            else if (y == 4) {
                // board[0][4]
                return "a5";
            }
            else if (y == 5) {
                // board[0][5]
                return "a6";
            }
            else if (y == 6) {
                // board[0][6]
                return "a7";
            }
            else if (y == 7) {
                // board[0][7]
                return "a8";
            }
        }
        else if (x == 1) {
            if (y == 0) {
                // board[1][0] 
                return "b1";
            }
            else if (y == 1) {
                // board[1][1]
                return "b2";
            }
            else if (y == 2) {
                // board[1][2]
                return "b3";
            }
            else if (y == 3) {
                // board[1][3]
                return "b4";
            }
            else if (y == 4) {
                // board[1][4]
                return "b5";
            }
            else if (y == 5) {
                // board[1][5]
                return "b6";
            }
            else if (y == 6) {
                // board[1][6]
                return "b7";
            }
            else if (y == 7) {
                // board[1][7]
                return "b8";
            }
        }
        else if (x == 2) {
            if (y == 0) {
                // board[2][0] 
                return "c1";
            }
            else if (y == 1) {
                // board[2][1]
                return "c2";
            }
            else if (y == 2) {
                // board[2][2]
                return "c3";
            }
            else if (y == 3) {
                // board[2][3]
                return "c4";
            }
            else if (y == 4) {
                // board[2][4]
                return "c5";
            }
            else if (y == 5) {
                // board[2][5]
                return "c6";
            }
            else if (y == 6) {
                // board[2][6]
                return "c7";
            }
            else if (y == 7) {
                // board[2][7]
                return "c8";
            }
        }
        else if (x == 3) {
            if (y == 0) {
                // board[3][0] 
                return "d1";
            }
            else if (y == 1) {
                // board[3][1]
                return "d2";
            }
            else if (y == 2) {
                // board[3][2]
                return "d3";
            }
            else if (y == 3) {
                // board[3][3]
                return "d4";
            }
            else if (y == 4) {
                // board[3][4]
                return "d5";
            }
            else if (y == 5) {
                // board[3][5]
                return "d6";
            }
            else if (y == 6) {
                // board[3][6]
                return "d7";
            }
            else if (y == 7) {
                // board[3][7]
                return "d8";
            }
        }
        else if (x == 4) {
            if (y == 0) {
                // board[4][0] 
                return "e1";
            }
            else if (y == 1) {
                // board[4][1]
                return "e2";
            }
            else if (y == 2) {
                // board[4][2]
                return "e3";
            }
            else if (y == 3) {
                // board[4][3]
                return "e4";
            }
            else if (y == 4) {
                // board[4][4]
                return "e5";
            }
            else if (y == 5) {
                // board[4][5]
                return "e6";
            }
            else if (y == 6) {
                // board[4][6]
                return "e7";
            }
            else if (y == 7) {
                // board[4][7]
                return "e8";
            }
        }
        else if (x == 5) {
            if (y == 0) {
                // board[5][0] 
                return "f1";
            }
            else if (y == 1) {
                // board[5][1]
                return "f2";
            }
            else if (y == 2) {
                // board[5][2]
                return "f3";
            }
            else if (y == 3) {
                // board[5][3]
                return "f4";
            }
            else if (y == 4) {
                // board[5][4]
                return "f5";
            }
            else if (y == 5) {
                // board[5][5]
                return "f6";
            }
            else if (y == 6) {
                // board[5][6]
                return "f7";
            }
            else if (y == 7) {
                // board[5][7]
                return "f8";
            }
        }
        else if (x == 6) {
            if (y == 0) {
                // board[6][0] 
                return "g1";
            }
            else if (y == 1) {
                // board[6][1]
                return "g2";
            }
            else if (y == 2) {
                // board[6][2]
                return "g3";
            }
            else if (y == 3) {
                // board[6][3]
                return "g4";
            }
            else if (y == 4) {
                // board[6][4]
                return "g5";
            }
            else if (y == 5) {
                // board[6][5]
                return "g6";
            }
            else if (y == 6) {
                // board[6][6]
                return "g7";
            }
            else if (y == 7) {
                // board[6][7]
                return "g8";
            }
        }
        else if (x == 7) {
            if (y == 0) {
                // board[7][0] 
                return "h1";
            }
            else if (y == 1) {
                // board[7][1]
                return "h2";
            }
            else if (y == 2) {
                // board[7][2]
                return "h3";
            }
            else if (y == 3) {
                // board[7][3]
                return "h4";
            }
            else if (y == 4) {
                // board[7][4]
                return "h5";
            }
            else if (y == 5) {
                // board[7][5]
                return "h6";
            }
            else if (y == 6) {
                // board[7][6]
                return "h7";
            }
            else if (y == 7) {
                // board[7][7]
                return "h8";
            }
        }
        
        return "Square not found.";
    }
    
    // isEmpty() returns true if the calling Square is empty, false if the calling Square is occupied by a Piece
    public boolean isEmpty() {
        return empty;
    }
}
