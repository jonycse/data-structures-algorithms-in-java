package recursion.permutation;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PermutationTest {

    @Test
    public void test1(){

        List<String> permutes = Permutation.permute("ABC");
        Assert.assertEquals(permutes.size() , 6);

        Assert.assertEquals(permutes.get(0), "ABC");
        Assert.assertEquals(permutes.get(1), "ACB");
        Assert.assertEquals(permutes.get(2), "BAC");
        Assert.assertEquals(permutes.get(3), "BCA");
        Assert.assertEquals(permutes.get(4), "CBA");
        Assert.assertEquals(permutes.get(5), "CAB");
    }


    @Test
    public void test2(){

        List<String> permutes = Permutation.permute("ABCD");
        Assert.assertEquals(permutes.size() , 24);
    }


    @Test
    public void test3(){

        List<String> permutes = Permutation.permute("AB");
        Assert.assertEquals(permutes.size() , 2);
    }

    @Test
    public void test4(){

        List<String> permutes = Permutation.permute("A");
        Assert.assertEquals(permutes.size() , 1);
    }
}
