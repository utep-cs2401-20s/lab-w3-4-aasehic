public class GameOfLife {
    int Size;
    int[][] Board;
    int[][] Previous;

    GameOfLife () {

    }

    GameOfLife (int Size) {
        this.Size = Size;
        this.Board = new int[Size][Size];
        this.Previous = new int[Size][Size];
    }

    GameOfLife (int[][] A) {
        this.Board = new int[A.length][A[0].length];
        this.Previous = A;
    }

    public int[][] getBoard () {
        return Board;
    }

    public void oneStep() {
        int[][] temp = Board;
        int result;
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board[i].length; j++) {
                result = neighbors(i,j);
                Board[i][j] = result;
            }
        }

        Previous = Board;
        Board = temp;
    }


    public int neighbors(int r, int c) {
        int living = 0;
        int rPlus = r + 1;
        int rMinus = r - 1;
        int cPlus = c + 1;
        int cMinus = c - 1;

        if ((-1 < rPlus) && (rPlus < Board.length) && (-1 < cMinus) && (cMinus < Board.length)) {
            if (Previous[rPlus][cMinus] == 1) {
                living = living + 1;
            }
        }

        if ((-1 < rPlus) && (rPlus <Board.length) && (-1 < c) && (c < Board.length)) {
            if (Previous[rPlus][c] == 1) {
                living = living + 1;
            }
        }

        if ((-1 < rPlus) && (rPlus <Board.length) && (-1 < cPlus) && (cPlus < Board.length)) {
            if (Previous[rPlus][cPlus] == 1) {
                living = living + 1;
            }
        }

        if ((-1 < r) && (r <Board.length) && (-1 < cPlus) && (cPlus < Board.length)) {
            if (Previous[r][cPlus] == 1) {
                living = living + 1;
            }
        }

        if ((-1 < r) && (r <Board.length) && (-1 < cMinus) && (cMinus < Board.length)) {
            if (Previous[r][cMinus] == 1) {
                living = living + 1;
            }
        }

        if ((-1 < rMinus) && (rMinus <Board.length) && (-1 < cMinus) && (cMinus < Board.length)) {
            if (Previous[rMinus][cMinus] == 1) {
                living = living + 1;
            }
        }

        if ((-1 < rMinus) && (rMinus <Board.length) && (-1 < c) && (c < Board.length)) {
            if (Previous[rMinus][c] == 1) {
                living = living + 1;
            }
        }

        if ((-1 < rMinus) && (rMinus <Board.length) && (-1 < cPlus) && (cPlus < Board.length)) {
            if (Previous[rMinus][cPlus] == 1) {
                living = living + 1;
            }
        }

        if (Previous[r][c] == 1) {
            if (living < 2) {
                return 0;
            }

            if ((living == 2) || (living == 3)) {
                return 1;
            } else {
                return 0;
            }

        }

        if (Previous[r][c] == 0) {
            if (living == 3) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public void evolution(int n) {
        for (int i = 1; i <= n; i++) {
            oneStep();
        }
    }
}
