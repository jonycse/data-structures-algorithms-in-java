package strings;


import org.junit.Assert;
import org.junit.Test;

public class StringSubTest {

    @Test
    public void test1() {

        Assert.assertEquals("99", StringSub.subtract("100", "1"));
        Assert.assertEquals("98", StringSub.subtract("100", "2"));
        Assert.assertEquals("1", StringSub.subtract("100", "99"));
        Assert.assertEquals("1", StringSub.subtract("1000", "999"));
        Assert.assertEquals("91", StringSub.subtract("100", "9"));
        Assert.assertEquals("991", StringSub.subtract("1000", "9"));
        Assert.assertEquals("9991", StringSub.subtract("10000", "9"));
        Assert.assertEquals("-887", StringSub.subtract("112", "999"));
        Assert.assertEquals("3", StringSub.subtract("10", "7"));
        Assert.assertEquals("5", StringSub.subtract("7", "2"));
        Assert.assertEquals("0", StringSub.subtract("7", "7"));
        Assert.assertEquals("5", StringSub.subtract("100", "95"));
        Assert.assertEquals("887", StringSub.subtract("999", "112"));
        Assert.assertEquals("885", StringSub.subtract("922", "37"));
        Assert.assertEquals(7879 - 56899 + "", StringSub.subtract("7879", "56899"));
        Assert.assertEquals(56899 - 7879 + "", StringSub.subtract("56899", "7879"));
        Assert.assertEquals(1000 - 99999 + "", StringSub.subtract("1000", "99999"));
        Assert.assertEquals(1000 - 9 + "", StringSub.subtract("1000", "9"));
        Assert.assertEquals(111000 - 9 + "", StringSub.subtract("111000", "9"));
        Assert.assertEquals(1 - 1000 + "", StringSub.subtract("1", "1000"));
        Assert.assertEquals(100 - 1000 + "", StringSub.subtract("100", "1000"));
        Assert.assertEquals(10 - 1000 + "", StringSub.subtract("10", "1000"));
        Assert.assertEquals(100 - 0 + "", StringSub.subtract("100", "0"));
        Assert.assertEquals(0 - 100 + "", StringSub.subtract("0", "100"));
    }
}
