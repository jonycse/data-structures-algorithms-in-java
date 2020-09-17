package dsalgo.sort;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import utils.LogUtils;
import utils.SortUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortTest {


    @Test
    @DisplayName("Test merge sort")
    public void test1(TestInfo testInfo) {

        System.out.println("Running test: " + testInfo.getDisplayName());
        int[] data = {10, 2, 4, 66, 1, 3};

        MergeSort.sort(data);

        assertEquals(true, SortUtils.isSortedArrayAsc(data));
        assertEquals(false, SortUtils.isSortedArrayDesc(data));


        int[] data2 = {4, 11, 102, 4, 3, 3};
        MergeSort.sort(data2);


        assertEquals(true, SortUtils.isSortedArrayAsc(data2));
        assertEquals(false, SortUtils.isSortedArrayDesc(data2));

        int[] data3 = {2, 1};
        MergeSort.sort(data3);
        assertEquals(true, SortUtils.isSortedArrayAsc(data3));

        int[] data4 = {2, 1, 4};
        MergeSort.sort(data4);
        assertEquals(true, SortUtils.isSortedArrayAsc(data4));
    }

}
