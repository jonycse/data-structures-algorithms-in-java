package dsalgo.linklist;

import org.junit.Assert;
import org.junit.Test;

public class LinkListTest {

    @Test
    public void linkListAddTest() {

        LinkList ll = new LinkList();
        String expectedList = "";

        Assert.assertEquals(expectedList, ll.getList());

        ll.append(5);
        expectedList = "5";
        Assert.assertEquals(expectedList, ll.getList());

        ll.append(7);
        expectedList = "5 7";
        Assert.assertEquals(expectedList, ll.getList());

        ll.append(8);
        ll.append(2);
        expectedList = "5 7 8 2";
        Assert.assertEquals(expectedList, ll.getList());

        ll.append(100, 0);
        expectedList = "100 5 7 8 2";
        Assert.assertEquals(expectedList, ll.getList());

        ll.append(200, 5);
        expectedList = "100 5 7 8 2 200";
        Assert.assertEquals(expectedList, ll.getList());

        ll.append(11, 1);
        expectedList = "100 11 5 7 8 2 200";
        Assert.assertEquals(expectedList, ll.getList());

        ll.append(11, 99);
        expectedList = "100 11 5 7 8 2 200"; // insert nothing
        Assert.assertEquals(expectedList, ll.getList());

        ll.append(99, 3);
        expectedList = "100 11 5 99 7 8 2 200";
        Assert.assertEquals(expectedList, ll.getList());

        ll.append(999);
        expectedList = "100 11 5 99 7 8 2 200 999";
        Assert.assertEquals(expectedList, ll.getList());

        ll.prepend(555);
        expectedList = "555 100 11 5 99 7 8 2 200 999";
        Assert.assertEquals(expectedList, ll.getList());


        ll.prepend(666);
        expectedList = "666 555 100 11 5 99 7 8 2 200 999";
        Assert.assertEquals(expectedList, ll.getList());

        ll.append(555);
        expectedList = "666 555 100 11 5 99 7 8 2 200 999 555";
        Assert.assertEquals(expectedList, ll.getList());



        ll.deleteByValue(555);
        expectedList = "666 100 11 5 99 7 8 2 200 999 555";
        Assert.assertEquals(expectedList, ll.getList());

        ll.deleteByValue(555);
        expectedList = "666 100 11 5 99 7 8 2 200 999";
        Assert.assertEquals(expectedList, ll.getList());


        ll.deleteByValue(666);
        expectedList = "100 11 5 99 7 8 2 200 999";
        Assert.assertEquals(expectedList, ll.getList());

        ll.deleteByValue(999);
        expectedList = "100 11 5 99 7 8 2 200";
        Assert.assertEquals(expectedList, ll.getList());
    }


    @Test
    public void linkListDeleteTest() {

        LinkList ll = new LinkList();
        String expectedList = "";
        Assert.assertEquals(expectedList, ll.getList());

        ll.prepend(2);
        ll.append(5);
        ll.append(11);
        ll.append(1);

        expectedList = "2 5 11 1";
        Assert.assertEquals(expectedList, ll.getList());

        ll.delete(0);
        expectedList = "5 11 1";
        Assert.assertEquals(expectedList, ll.getList());


        ll.delete(200);
        expectedList = "5 11 1"; // delete nothing
        Assert.assertEquals(expectedList, ll.getList());

        ll.delete(2);
        expectedList = "5 11";
        Assert.assertEquals(expectedList, ll.getList());

        ll.delete(1);
        expectedList = "5";
        Assert.assertEquals(expectedList, ll.getList());

        ll.delete(0);
        expectedList = "";
        Assert.assertEquals(expectedList, ll.getList());


        expectedList = "";
        String sp = "";
        int n = 10;
        for (int i = 1; i <= n; i++) {
            ll.append(i);
            expectedList = expectedList + sp + i;
            sp = " ";
        }
        Assert.assertEquals(expectedList, ll.getList());

        for (int i = 1; i <= n; i++) {
            ll.delete(0);

            expectedList = removeFirst(expectedList);
            Assert.assertEquals(expectedList, ll.getList());
        }

    }

    private String removeFirst(String expectedList) {
        boolean flag = false;
        String r = "", sp = "";
        for (String w : expectedList.split(" ")) {
            if (!flag) {
                flag = true;
                continue;
            }
            r = r + sp + w;
            sp = " ";
        }
        return r;
    }
}
