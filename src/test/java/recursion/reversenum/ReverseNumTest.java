package recursion.reversenum;

import org.junit.Assert;
import org.junit.Test;

public class ReverseNumTest {


    @Test
    public void test1() {
        verify(321);
        verify(120);
        verify(3);
        verify(5999);
        verify(0);
        verify(2);
        verify(10);
        verify(215);
        verify(319);
        verify(10000);
    }


    private void verify(int num) {
        ReverseNum reverseNum = new ReverseNum();
        StringBuilder sb = new StringBuilder("" + num);
        sb = sb.reverse();
        int manualReverse = Integer.parseInt(sb.toString());
        Assert.assertEquals(manualReverse, reverseNum.reverse(num));
    }


}
