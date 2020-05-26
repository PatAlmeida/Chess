import java.util.ArrayList;

public class PieceList {

    private ArrayList<Piece> pieces;

    public PieceList() {
        pieces = new ArrayList<Piece>();
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public boolean isPlayerInCheck(PieceColor color) {
        String playerKingLocation = getPlayerKing(color).getLocationString();
        for (Piece piece : pieces) {
            if (piece.getColor() != color) {
                if (piece.isAttacking(playerKingLocation)) return true;
            }
        }
        return false;
    }

    public Piece getPlayerKing(PieceColor color) {
        for (Piece piece : pieces) {
            if (piece.getColor() == color && piece.getType() == PieceType.KING) return piece;
        }
        System.out.println("Error: King not found");
        return null;
    }

    // Bishop = 3, Rook = 5, etc
    public int getTotalValueFor(PieceColor color) {
        int total = 0;
        for (Piece piece : pieces) {
            if (piece.getColor() == color) {
                total += piece.getValue();
            }
        }
        return total;
    }

}
