import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TorusGameOfLifeTest {
    @Test
    public void oneStep() {
        int[][] A = {{0, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] B = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        TorusGameOfLife t1 = new TorusGameOfLife(A);
        t1.oneStep();
        int[][] i = t1.getBoard();
        Assertions.assertArrayEquals(B, t1.getBoard());
    }
}