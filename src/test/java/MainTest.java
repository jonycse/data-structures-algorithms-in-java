import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    public void testReverse() {

        Assert.assertEquals("abc", Main.reverse("cba"));
        Assert.assertEquals("aBc", Main.reverse("cBa"));
        Assert.assertEquals("aBcd", Main.reverse("dcBa"));
    }
}
