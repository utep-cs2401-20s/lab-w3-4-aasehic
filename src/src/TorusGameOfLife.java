public class TorusGameOfLife extends GameOfLife {
    TorusGameOfLife () {

    }

    TorusGameOfLife (int Size) {
        this.Size = Size;
        this.Board = new int[Size][Size];
        this.Previous = new int[Size][Size];
    }

    TorusGameOfLife (int[][] A) {
        this.Board = new int[A.length][A[0].length];
        this.Previous = A;
    }

    public int neighbors (int r, int c) {
        int living = 0;
        int rPlus;
        int rMinus;
        int cPlus;
        int cMinus;

        if ((r + 1) % Board.length == 0) {
            rPlus = 0;
        } else {
            rPlus = r + 1;
        }

        if ((r - 1) < 0) {
            rMinus = Board.length - 1;
        } else {
            rMinus = r - 1;
        }

        if ((c + 1) % Board[0].length == 0) {
            cPlus = 0;
        } else {
            cPlus = c + 1;
        }

        if ((c - 1) < 0) {
            cMinus = Board[0].length - 1;
        } else {
            cMinus = c - 1;
        }

        if (Previous[rMinus][cMinus] == 1) {
            living = living + 1;
        }

        if (Previous[rMinus][c] == 1) {
            living = living + 1;
        }

        if (Previous[rMinus][cPlus] == 1) {
            living = living + 1;
        }

        if (Previous[r][cMinus] == 1) {
            living = living + 1;
        }

        if (Previous[r][cPlus] == 1) {
            living = living + 1;
        }

        if (Previous[rPlus][cMinus] == 1) {
            living = living + 1;
        }

        if (Previous[rPlus][c] == 1) {
            living = living + 1;
        }

        if (Previous[rPlus][cPlus] == 1) {
            living = living + 1;
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
}
