import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[][] edges = {
                {0,1},
                {1,2},
                {1,3},
                {4,2},
        };
        int[][] guesses = {
                {1,3},
                {0,1},
                {1,0},
                {2,4},
        };
        int k = 3;
        int expected = 3;
        int actual = new Solution().rootCount(edges, guesses, k);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        int[][] edges = {
                {0,1},
                {1,2},
                {2,3},
                {3,4},
        };
        int[][] guesses = {
                {1,0},
                {3,4},
                {2,1},
                {3,2},
        };
        int k = 1;
        int expected = 5;
        int actual = new Solution().rootCount(edges, guesses, k);

        Assert.assertEquals(expected, actual);
    }
}
