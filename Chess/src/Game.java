import java.io.File;
import java.util.Scanner;

public class Game {

    public static Game game;

    private Board board;
    private PieceList pieces;

    public Game() {

        board = new Board();
        pieces = new PieceList();
        assignPieces();

        board.print();

    }

    public Square getSquare(String locStr) { return game.board.getSquare(locStr); }

    // Example line from data/startingPieces.txt : d1 WHITE QUEEN
    // Use a "// " before a line in data/startingPieces.txt to remove it from the starting board
    private void assignPieces() {
        try {
            Scanner scan = new Scanner(new File("data/startingPieces.txt"));
            while (scan.hasNext()) {
                String locationStr = scan.next();
                PieceColor pieceCol = PieceColor.getFromString(scan.next());
                PieceType pieceType = PieceType.getFromString(scan.next());
                if (!locationStr.equals("//")) {
                    Piece piece = new Piece(pieceCol, pieceType, locationStr);
                    board.getSquare(locationStr).setPiece(piece);
                    pieces.add(piece);
                } else {
                    scan.next();
                }
            }
            scan.close();
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    public boolean isPlayerInCheck(PieceColor color) {
        return pieces.isPlayerInCheck(color);
    }

    // Bishop = 3, Rook = 5, etc
    public int getTotalValueFor(PieceColor color) {
        return pieces.getTotalValueFor(color);
    }

}
