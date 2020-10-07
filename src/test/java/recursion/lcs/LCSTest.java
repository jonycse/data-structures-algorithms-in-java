package recursion.lcs;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LCSTest {
    @Test
    public void test1() {

        Assert.assertEquals(4, LCS.LCS("AGGTAB", "GXTXAYB"));
        Assert.assertEquals(3, LCS.LCS("abcde", "ace"));
        Assert.assertEquals(3, LCS.LCS("abc", "abc"));
        Assert.assertEquals(0, LCS.LCS("abc", "def"));

    }

    @Test
    public void test2() {

        Assert.assertEquals(4, LCSMemo.LCS("AGGTAB", "GXTXAYB"));
        Assert.assertEquals(3, LCSMemo.LCS("abcde", "ace"));
        Assert.assertEquals(3, LCSMemo.LCS("abc", "abc"));
        Assert.assertEquals(0, LCSMemo.LCS("abc", "def"));
    }
}
