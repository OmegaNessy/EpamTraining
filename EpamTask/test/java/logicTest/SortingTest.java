package logicTest;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.FileException;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.logic.Sorting;
import by.epam.etc.util.FileReaderUtil;
import by.epam.etc.util.Parser;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;



import static org.testng.Assert.*;

public class SortingTest {
    static Logger logger = LogManager.getLogger();
    Sorting sorting = new Sorting();
    DataValidator dataValidator = new DataValidator();
    FileReaderUtil fru = new FileReaderUtil();
    Parser parser = new Parser();
    int[] sortedArr = {-23, -15, -7, -3, 0, 3, 23, 66, 76};
    ArrayObj testArray;


    @BeforeMethod
    public void beforeMethod() throws IOException {
        try {
            String initialData = fru.read();
            int[] parsedData = parser.fromStringToIntArray(initialData);
            testArray = new ArrayObj(Arrays.copyOf(parsedData, parsedData.length));
        }catch (FileException e){
            logger.error("File not found");
            testArray = new ArrayObj(Arrays.copyOf(sortedArr, sortedArr.length));
        }
    }
    @Test()
    public void testBubbleSorting (){

        int[] actual = sorting.bubbleSorting(testArray);
        int[] expected = sortedArr;
        assertEquals(actual,expected);
    }

    @Test()
    public void testShakeSorting(){
        int[] actual = sorting.shakeSorting(testArray);
        int[] expected = sortedArr;
        assertEquals(actual,expected);
    }

    @Test()
    public void testCombSorting(){
        int[] actual = sorting.combSorting(testArray);
        int[] expected = sortedArr;
        assertEquals(actual,expected);
    }
}
