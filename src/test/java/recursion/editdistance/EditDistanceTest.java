package recursion.editdistance;

import org.junit.Assert;
import org.junit.Test;

public class EditDistanceTest {


    @Test
    public void test1() {
        String sa = "sunday";
        String sb = "saturday";

        EditDistance editDistance = new EditDistance(sa, sb);

        Assert.assertEquals(3, editDistance.getCost());
    }


    @Test
    public void test2() {
        String sa = "horse";
        String sb = "ros";

        EditDistance editDistance = new EditDistance(sa, sb);

        Assert.assertEquals(3, editDistance.getCost());
    }

    @Test
    public void test3() {
        String sa = "intention";
        String sb = "execution";

        EditDistance editDistance = new EditDistance(sa, sb);

        Assert.assertEquals(5, editDistance.getCost());
    }
}
