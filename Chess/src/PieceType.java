public enum PieceType {

    PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING;

    public static PieceType getFromString(String str) {
        if (str.equals("PAWN")) return PAWN;
        else if (str.equals("KNIGHT")) return KNIGHT;
        else if (str.equals("BISHOP")) return BISHOP;
        else if (str.equals("ROOK")) return ROOK;
        else if (str.equals("QUEEN")) return QUEEN;
        else if (str.equals("KING")) return KING;
        return null;
    }

    public static int getValue(PieceType type) {
        switch (type) {
            case PAWN: return 1;
            case KNIGHT: return 3;
            case BISHOP: return 3;
            case ROOK: return 5;
            case QUEEN: return 9;
            case KING: return 0;
        }
        return 0;
    }

}
