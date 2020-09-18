package strings;

import org.junit.Assert;
import org.junit.Test;

public class KMPTest {

    @Test
    public void test1() {

        Assert.assertTrue(KMP.hasSubstring("abcxabcdabcdabcy", "abcdabcy"));
        Assert.assertTrue(KMP.hasSubstring("leetcodeleet", "leet"));
        Assert.assertTrue(KMP.hasSubstring("leetcodeleet", "eleet"));
        Assert.assertFalse(KMP.hasSubstring("leetcodeleet", "aleet"));
    }
}
