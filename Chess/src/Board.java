public class Board {

    public static final int SIZE = 8;

    private Square[][] squares;

    public Board() {

        squares = new Square[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                squares[i][j] = new Square(i, j);
            }
        }

        assignPieces();

    }

    private void assignPieces() {
        
    }

    public Square getSquare(String locationStr) {
        int file = (int) locationStr.charAt(0) - 97;
        int rank = Integer.parseInt(locationStr.substring(1)) - 1;
        return squares[file][rank];
    }

}
