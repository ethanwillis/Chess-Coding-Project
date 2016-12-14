import javafx.util.Pair;
public class Square
{
    // piece stores what Piece occupies the square
    private Piece piece;
    
    // plot stores the point (x,y);
    private Pair<Integer,Integer> point;
    // x,y are the coordinates for the square
    private int x,y;
    
    // empty is true when the square is empty
    // (i.e. no piece occupies the square)
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

    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty() {
        return empty;
    }
}
