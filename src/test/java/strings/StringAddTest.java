package strings;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class StringAddTest {

    @Test
    void test1(){

        assertEquals("108", StringAdd.add("99", "9"));
        assertEquals("110", StringAdd.add("99", "11"));
        assertEquals("135", StringAdd.add("12", "123"));
        assertEquals("401", StringAdd.add("1", "400"));
        assertEquals("5", StringAdd.add("1", "4"));
        assertEquals("15", StringAdd.add("11", "4"));
        assertEquals("411", StringAdd.add("11", "400"));
        assertEquals("401", StringAdd.add("400", "1"));
        assertEquals("1", StringAdd.add("0", "1"));
        assertEquals("0", StringAdd.add("0", "0"));
        assertEquals("100", StringAdd.add("0", "100"));
        assertEquals("100", StringAdd.add("", "100"));
        assertEquals("100", StringAdd.add("100", ""));

    }

    @DisplayName("Dynamic test for StrAdd")
    @TestFactory
    Iterator<DynamicTest> test2() {
        return Arrays.asList(
                DynamicTest.dynamicTest("99 + 9 = 108",
                        () -> assertEquals("108", StringAdd.add("99", "9"))),
                DynamicTest.dynamicTest("12 + 123 = 135",
                        () -> assertEquals("135", StringAdd.add("12", "123"))),
                DynamicTest.dynamicTest("1 + 400 = 401",
                        () -> assertEquals("401", StringAdd.add("1", "400"))),
                DynamicTest.dynamicTest("1 + 4 = 5",
                        () -> assertEquals("5", StringAdd.add("1", "4"))),
                DynamicTest.dynamicTest("1 + 0 = 1",
                        () -> assertEquals("1", StringAdd.add("1", "0"))),
                DynamicTest.dynamicTest("0 + 0 = 0",
                        () -> assertEquals("0", StringAdd.add("0", "0"))),
                DynamicTest.dynamicTest("78588868 + 9875899654 = 9954488522",
                        () -> assertEquals("9954488522", StringAdd.add("78588868", "9875899654")))
        ).iterator();
    }
}
