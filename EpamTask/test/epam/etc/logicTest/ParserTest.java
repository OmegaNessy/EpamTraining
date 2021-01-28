package epam.etc.logicTest;

import by.epam.etc.util.Parser;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParserTest {
    Parser parser = new Parser();
    @Test
    public void testFromStringToIntArray(){
        String testStringData = "1 3 5 3 6 -2 -43 1 2";
        int[] actual = parser.fromStringToIntArray(testStringData);
        int[] expected = {1,3,5,3,6,-2,-43,1,2};
        assertEquals(actual, expected);
    }

    @Test
    public void testFromStringToIntArrayWithStream(){
        String testStringData = "1 3 5 3 6 -2 -43 1 2";
        int[] actual = parser.fromStringToIntArrayWithStream(testStringData);
        int[] expected = {1,3,5,3,6,-2,-43,1,2};
        assertEquals(actual, expected);
    }
}
