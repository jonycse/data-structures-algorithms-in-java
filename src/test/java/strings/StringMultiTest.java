package strings;

import org.junit.Assert;
import org.junit.Test;

public class StringMultiTest {


    @Test
    public void test1() {

        Assert.assertEquals("1476", StringMulti.multi("123", "12"));
        Assert.assertEquals("0", StringMulti.multi("0", "12"));
        Assert.assertEquals("15", StringMulti.multi("3", "5"));
        Assert.assertEquals(254 * 4568 + "", StringMulti.multi("254", "4568"));
        Assert.assertEquals(254 * 4568 + "", StringMulti.multi("4568", "254"));
        Assert.assertEquals(2589 * 4568 + "", StringMulti.multi("4568", "2589"));
        Assert.assertEquals(6521 * 9856 + "", StringMulti.multi("6521", "9856"));
    }
}
