import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int[]  parents = {-1,2,0,2,0};
        int expected = 3;
        int actual = new Solution().countHighestScoreNodes(parents);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2(){
        int[]  parents = {-1,3,3,5,7,6,0,0};
        int expected = 2;
        int actual = new Solution().countHighestScoreNodes(parents);

        Assert.assertEquals(expected, actual);
    }
}
