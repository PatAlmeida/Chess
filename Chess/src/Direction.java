public enum Direction {

    UP, RIGHT, DOWN, LEFT, UP_RIGHT, DOWN_RIGHT, DOWN_LEFT, UP_LEFT;

    public static final Direction[] WHITE_PAWN_ATTACKS =
        { UP_RIGHT, UP_LEFT };

    public static final Direction[] BLACK_PAWN_ATTACKS =
        { DOWN_RIGHT, DOWN_LEFT };

    public static final Direction[] CARDINALS =
        { UP, RIGHT, DOWN, LEFT };

    public static final Direction[] DIAGONALS =
        { UP_RIGHT, DOWN_RIGHT, DOWN_LEFT, UP_LEFT };

    public static final Direction[] ALL_DIRECTIONS =
        { UP, RIGHT, DOWN, LEFT, UP_RIGHT, DOWN_RIGHT, DOWN_LEFT, UP_LEFT };

}
