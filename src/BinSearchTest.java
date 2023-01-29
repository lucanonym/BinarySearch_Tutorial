import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinSearchTest {


    @Test
    public void binSearchTest() {
        String[] testValid = {"a", "c", "d", "e", "f", "g", "h"};
        String[] notValid = {"b", "C", "Hallo", "", "f"};
        SomeUtil bin = new SomeUtil();
        for (String valid : testValid) {
            assertEquals(valid, bin.binSearch(testValid, valid), "String should be found");
        }
        for(String notVal : notValid) {
            assertNull(bin.binSearch(testValid, notVal), "String should be found");
        }
    }

    @Test
    public void prettyPrintTest() {
        SomeUtil util = new SomeUtil();
        String[] test = {"first", "second", "third", "fourth", ""};
        List<Integer> anotherTest = List.of(1, 2, 3, 4, 5, 6, 7);
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (String testString : test) {
            joiner.add("Item: " + testString);
        }
        assertEquals(joiner.toString() ,util.prettyPrint(Arrays.asList(test)), "Should be pretty printed");
        String anotherExam = anotherTest.stream()
                .map(elem -> "Item: " + elem)
                .collect(Collectors.joining(System.lineSeparator()));
        assertEquals(anotherExam, util.prettyPrint(anotherTest), "Should be pretty printed");

    }



}