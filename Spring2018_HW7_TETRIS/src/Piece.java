import java.awt.*;

public interface Piece {
    void draw(Graphics g);
    Point[] getLocations();
    void move(Direction direction);
    Color getColor();
    boolean canMove(Direction direction);
    void rotate();





}
