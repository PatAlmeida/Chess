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
    }

    // Returns null if there is no next location in the given direction (off the board)
    public static String getNextLocStrInDir(String locStr, Direction dir) {

        char file = locStr.charAt(0);
        int rank = (int) locStr.charAt(1) - 48;

        String up, down, left, right;

        switch (dir) {
            case UP:
                if (rank != 8) return file + "" + (rank + 1);
                else return null;
            case RIGHT:
                if (file != 'h') return getRightFile(file) + "" + rank;
                else return null;
            case DOWN:
                if (rank != 1) return file + "" + (rank - 1);
                else return null;
            case LEFT:
                if (file != 'a') return getLeftFile(file) + "" + rank;
                else return null;
            case UP_RIGHT:
                up = getNextLocStrInDir(locStr, Direction.UP);
                right = getNextLocStrInDir(locStr, Direction.RIGHT);
                if (up == null || right == null) return null;
                return right.charAt(0) + "" + up.charAt(1);
            case DOWN_RIGHT:
                down = getNextLocStrInDir(locStr, Direction.DOWN);
                right = getNextLocStrInDir(locStr, Direction.RIGHT);
                if (down == null || right == null) return null;
                return right.charAt(0) + "" + down.charAt(1);
            case DOWN_LEFT:
                down = getNextLocStrInDir(locStr, Direction.DOWN);
                left = getNextLocStrInDir(locStr, Direction.LEFT);
                if (down == null || left == null) return null;
                return left.charAt(0) + "" + down.charAt(1);
            case UP_LEFT:
                up = getNextLocStrInDir(locStr, Direction.UP);
                left = getNextLocStrInDir(locStr, Direction.LEFT);
                if (up == null || left == null) return null;
                return left.charAt(0) + "" + up.charAt(1);
        }

        // Indicates off the board
        return null;

    }

    public static char getRightFile(char file) {
        if (file == 'a') return 'b';
        else if (file == 'b') return 'c';
        else if (file == 'c') return 'd';
        else if (file == 'd') return 'e';
        else if (file == 'e') return 'f';
        else if (file == 'f') return 'g';
        else if (file == 'g') return 'h';
        System.out.println("Error: Went off board");
        return ' ';
    }

    public static char getLeftFile(char file) {
        if (file == 'h') return 'g';
        else if (file == 'g') return 'f';
        else if (file == 'f') return 'e';
        else if (file == 'e') return 'd';
        else if (file == 'd') return 'c';
        else if (file == 'c') return 'b';
        else if (file == 'b') return 'a';
        System.out.println("Error: Went off board");
        return ' ';
    }

    public Square getSquare(String locationStr) {
        int file = (int) locationStr.charAt(0) - 97;
        int rank = Integer.parseInt(locationStr.substring(1)) - 1;
        return squares[file][rank];
    }

    public void print() {
        for (int i = SIZE - 1; i >= 0; i--) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(squares[j][i]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
