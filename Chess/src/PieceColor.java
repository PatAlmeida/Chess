public enum PieceColor {

    WHITE, BLACK;

    public static PieceColor getFromString(String str) {
        if (str.equals("WHITE")) return WHITE;
        else if (str.equals("BLACK")) return BLACK;
        return null;
    }

}
