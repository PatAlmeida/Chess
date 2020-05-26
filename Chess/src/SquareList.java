import java.util.ArrayList;

public class SquareList {

    private ArrayList<Square> squares;

    public SquareList() {
        squares = new ArrayList<Square>();
    }

    public int getSize() { return squares.size(); }

    public void add(Square square) {
        squares.add(square);
    }

    public boolean containsWithLocation(String locationStr) {
        for (Square square : squares) {
            if (square.getLocationString().equals(locationStr)) return true;
        }
        return false;
    }

}
