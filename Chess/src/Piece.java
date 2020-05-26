public class Piece {

    private PieceColor color;
    private PieceType type;
    private String locationStr;

    public Piece(PieceColor pCol, PieceType pType, String loc) {
        color = pCol;
        type = pType;
        locationStr = loc;
    }

    public PieceColor getColor() { return color; }
    public PieceType getType() { return type; }
    public String getLocationString() { return locationStr; }
    public int getValue() { return PieceType.getValue(type); }

    public boolean isAttacking(String boardLoc) {
        SquareList attackingSquares = getAttackingSquares();
        return attackingSquares.containsWithLocation(boardLoc);
    }

    public SquareList getAttackingSquares() {

        SquareList squareList = new SquareList();
        Direction[] directions = { };

        switch (type) {

            case PAWN:
            case KING:
                if (type == PieceType.PAWN) {
                    if (color == PieceColor.WHITE) directions = Direction.WHITE_PAWN_ATTACKS;
                    else if (color == PieceColor.BLACK) directions = Direction.BLACK_PAWN_ATTACKS;
                } else if (type == PieceType.KING) directions = Direction.ALL_DIRECTIONS;
                for (Direction dir : directions) {
                    String loc = Board.getNextLocStrInDir(locationStr, dir);
                    if (loc != null) {
                        Square square = Game.game.getSquare(loc);
                        if (square.hasPiece()) {
                            if (square.getPiece().getColor() != color) {
                                squareList.add(Game.game.getSquare(loc));
                            }
                        } else {
                            squareList.add(Game.game.getSquare(loc));
                        }
                    }
                } break;

            case BISHOP:
            case ROOK:
            case QUEEN:
                if (type == PieceType.BISHOP) directions = Direction.DIAGONALS;
                else if (type == PieceType.ROOK) directions = Direction.CARDINALS;
                else if (type == PieceType.QUEEN) directions = Direction.ALL_DIRECTIONS;
                for (Direction dir : directions) {
                    String movingLocStr = locationStr;
                    while (true) {
                        String loc = Board.getNextLocStrInDir(movingLocStr, dir);
                        if (loc == null) break;
                        Square square = Game.game.getSquare(loc);
                        if (square.hasPiece()) {
                            if (square.getPiece().getColor() == color) break;
                            squareList.add(Game.game.getSquare(loc));
                            break;
                        } else {
                            squareList.add(Game.game.getSquare(loc));
                            movingLocStr = Board.getNextLocStrInDir(movingLocStr, dir);
                        }
                    }
                } break;

            case KNIGHT: break;

        }

        System.out.println(locationStr + " - " + squareList.getSize());

        return squareList;

    }

    public String getTextRepresentation() {
        String str = null;
        if (type == PieceType.PAWN) str = "P";
        else if (type == PieceType.KNIGHT) str = "N";
        else if (type == PieceType.BISHOP) str = "B";
        else if (type == PieceType.ROOK) str = "R";
        else if (type == PieceType.QUEEN) str = "Q";
        else if (type == PieceType.KING) str = "K";
        if (color == PieceColor.BLACK) str = str.toLowerCase();
        return str;
    }

    public String toString() {
        return color + " " + type + " at " + locationStr;
    }

}
