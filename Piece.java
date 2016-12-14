public class Piece
{
    // color is true when the piece is white's, false if the piece is black's
    private boolean color;
    
    // integers x and y store the coordinate at which the Piece is located
    private int x,y;
    
    public Piece(int x, int y, boolean color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public void setColor(boolean color) {
        this.color = color;
    }
    
    public boolean getColor() {
        return color;
    }
}
