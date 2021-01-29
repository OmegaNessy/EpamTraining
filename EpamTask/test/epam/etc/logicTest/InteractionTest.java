package epam.etc.logicTest;

import by.epam.etc.exception.FileException;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.logic.Interaction;
import by.epam.etc.entity.ArrayObj;
import by.epam.etc.logic.InteractionWithStream;
import by.epam.etc.util.FileReaderUtil;
import by.epam.etc.util.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.testng.Assert.*;

public class InteractionTest {
    final String FILENAME = "data/ArrayData.txt";
    final int[] DEFAULT_ARRAY = {23,43,-1,0,43,54,2,-34,3};
    static Logger logger = LogManager.getLogger();

    Interaction interaction = new Interaction();
    InteractionWithStream interactionWithStream = new InteractionWithStream();
    FileReaderUtil fileReaderUtil = new FileReaderUtil();
    Parser parser = new Parser();
    ArrayObj testArray;

    @BeforeMethod
    public void beforeMethod() throws IOException {
        try {
            String initialData = fileReaderUtil.read(FILENAME);
            int[] parsedData = parser.fromStringToIntArray(initialData);
            testArray = new ArrayObj(Arrays.copyOf(parsedData, parsedData.length));
        }catch (FileException e){
            logger.error("File not found");
            testArray = new ArrayObj(Arrays.copyOf(DEFAULT_ARRAY, DEFAULT_ARRAY.length));
        }
    }

    @Test()
    public void testMin () throws InvalidDataException {
        int actual = interaction.min(testArray);
        int expected = -32;
        assertEquals(actual,expected);
    }
    @Test()
    public void testMax () throws InvalidDataException {
        int actual = interaction.max(testArray);
        int expected = 65;
        assertEquals(actual,expected);
    }
    @Test()
    public void testReplacement () throws InvalidDataException {
        int[] actual = interaction.replacement(testArray,2,25);
        int[] expected = {34, 32, 25, 54, -32, 0, 23, 0, 1,};
        assertEquals(actual,expected);
    }
    @Test()
    public void testPositiveCount () throws InvalidDataException {
        int actual = interaction.positiveCount(testArray);
        int expected = 8;
        assertEquals(actual,expected);
    }
    @Test()
    public void testNegativeCount () throws InvalidDataException {
        int actual = interaction.negativeCount(testArray);
        int expected = 1;
        assertEquals(actual,expected);
    }
    @Test()
    public void testMinStream () throws InvalidDataException {
        int actual = interactionWithStream.min(testArray);
        int expected = -32;
        assertEquals(actual,expected);
    }
    @Test()
    public void testMaxStream () throws InvalidDataException {
        int actual = interactionWithStream.max(testArray);
        int expected = 65;
        assertEquals(actual,expected);
    }

    @Test()
    public void testPositiveCountStream () throws InvalidDataException {
        int actual = interactionWithStream.positiveCount(testArray);
        int expected = 8;
        assertEquals(actual,expected);
    }
    @Test()
    public void testNegativeCountStream () throws InvalidDataException {
        int actual = interactionWithStream.negativeCount(testArray);
        int expected = 1;
        assertEquals(actual,expected);
    }

}
