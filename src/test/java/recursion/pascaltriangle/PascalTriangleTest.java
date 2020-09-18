package recursion.pascaltriangle;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import utils.ArrayUtils;

import java.util.Arrays;

public class PascalTriangleTest {

    @Test
    public void testPascalTriangle() {

        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(1), PascalTriangle.getRows(0)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(1, 1), PascalTriangle.getRows(1)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(1, 2, 1), PascalTriangle.getRows(2)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(1, 3, 3, 1), PascalTriangle.getRows(3)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(1, 4, 6, 4, 1), PascalTriangle.getRows(4)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(1, 5, 10, 10, 5, 1), PascalTriangle.getRows(5)));
    }
}
