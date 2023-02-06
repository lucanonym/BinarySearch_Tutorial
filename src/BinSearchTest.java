import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;


import static org.junit.jupiter.api.Assertions.*;

public class BinSearchTest {
    private static StringJoiner joiner;
    private final String[] testValid = new String[]{"a", "c", "d", "e", "f", "g", "h"};
    private final SomeUtil util = new SomeUtil();


    @BeforeAll
    public static void generateJoiner() {
        String[] test = {"first", "second", "third", "fourth", ""};
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (String testString : test) {
            if (!testString.isEmpty()) joiner.add("Item: " + testString);
        }
        BinSearchTest.joiner = joiner;
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "c", "d", "e", "f", "g", "h"})
    public void binSearchTest(String toTest) {
        assertEquals(toTest, this.util.binSearch(testValid, toTest), "String should be found");
    }

    @ParameterizedTest
    @ValueSource(strings = {"hallo", "i", "am", "not", "valid"})
    public void binSearchFail(String toTest) {
        assertNull(this.util.binSearch(testValid, toTest), "String should be found");
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testNullAndEmptyBinSearch(String test) {
        assertNull(this.util.binSearch(testValid, test));
    }

    @ParameterizedTest
    @NullSource
    public void testNullAndEmptyPrettyPrint(List<String> test) {
        assertThrows(IllegalArgumentException.class, () -> this.util.prettyPrint(test));
    }

    @Test
    public void prettyPrintTest() {
        assertEquals(joiner.toString(),
                this.util.prettyPrint(Arrays.asList("first", "second", "third", "fourth", "")),
                "Should be pretty printed");
    }



}


