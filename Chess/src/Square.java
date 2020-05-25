public class Square {

    private boolean hasPiece;
    private Piece piece;
    private String locationStr;

    public Square(int i, int j) {

        hasPiece = false;
        piece = null;

        char file = (char) (i + 97);
        int rank = j + 1;
        locationStr = file + "" + rank;

    }

    public void setPiece(Piece myPiece) {
        hasPiece = true;
        piece = myPiece;
    }

    public String toString() {
        return locationStr;
    }

}
