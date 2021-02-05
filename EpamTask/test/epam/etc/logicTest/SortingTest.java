package epam.etc.logicTest;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.FileException;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.logic.Sorting;
import by.epam.etc.logic.SortingWithStream;
import by.epam.etc.util.FileReaderUtil;
import by.epam.etc.util.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Arrays;



import static org.testng.Assert.*;

public class SortingTest {
    static Logger logger = LogManager.getLogger();
    final int[] DEFAULT_ARRAY = {23,43,-1,0,43,54,2,-34,3};
    final String FILENAME = "./resources/data/ArrayData.txt";

    Sorting sorting = new Sorting();
    SortingWithStream streamSorting = new SortingWithStream();
    FileReaderUtil fileReaderUtil = new FileReaderUtil();
    Parser parser = new Parser();
    int[] sortedArr = {-32, 0, 0, 1, 23, 32, 34, 54, 65};
    ArrayObj testArray = null;

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
    public void testBubbleSorting () throws InvalidDataException {
        logger.info("BubbleSorting");
        sorting.bubbleSorting(testArray);
        int[] actual = testArray.getArray();
        int[] expected = sortedArr;
        assertEquals(actual, expected);

    }

    @Test()
    public void testShakeSorting() throws InvalidDataException {
        logger.info("ShakeSorting");
        sorting.shakeSorting(testArray);
        int[] actual = testArray.getArray();
        int[] expected = sortedArr;
        assertEquals(actual, expected);
    }

    @Test()
    public void testCombSorting() throws InvalidDataException {
        logger.info("CombSorting");
        sorting.combSorting(testArray);
        int[] actual = testArray.getArray();
        int[] expected = sortedArr;
        assertEquals(actual, expected);
    }

    @Test()
    public void testStreamSort() throws InvalidDataException {
        logger.info("StreamSorting");
        streamSorting.sortingWithStream(testArray);
        int[] actual = testArray.getArray();
        int[] expected = sortedArr;
        assertEquals(actual,expected);
    }
}
