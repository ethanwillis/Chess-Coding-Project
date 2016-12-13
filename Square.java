public class Square
{
    // piece stores what Piece occupies the square
    private Piece piece;
    
    // x,y are the coordinates for the square
    private int x,y;
    
    // empty is true when the square is empty
    // (i.e. no piece occupies the square)
    private boolean empty;
    
    public Square(int x, int y, boolean empty, Piece piece) {
        this.x = x;
        this.y = y;
        this.empty = empty;
        
        // this is to ensure that no piece can occupy an empty square
        if (empty == true) {
            piece = null;
        }
        else {
            this.piece = piece;
        }
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty() {
        return empty;
    }
}
