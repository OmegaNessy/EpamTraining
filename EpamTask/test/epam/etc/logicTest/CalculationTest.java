package epam.etc.logicTest;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.FileException;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.logic.Calculation;
import by.epam.etc.logic.CalculationWithStream;
import by.epam.etc.util.FileReaderUtil;
import by.epam.etc.util.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class CalculationTest {
    final String FILENAME = "data/ArrayData.txt";
    final int[] DEFAULT_ARRAY = {23,43,-1,0,43,54,2,-34,3};
    static Logger logger = LogManager.getLogger();

    Calculation calculation  = new Calculation();
    CalculationWithStream calculationWithStream = new CalculationWithStream();
    FileReaderUtil fru = new FileReaderUtil();
    Parser parser = new Parser();
    ArrayObj testArray;

    @BeforeMethod
    public void beforeMethod() throws IOException {
        try {
            String initialData = fru.read(FILENAME);
            int[] parsedData = parser.fromStringToIntArray(initialData);
            testArray = new ArrayObj(Arrays.copyOf(parsedData, parsedData.length));
        }catch (FileException e){
            logger.error("File not found");
            testArray = new ArrayObj(Arrays.copyOf(DEFAULT_ARRAY, DEFAULT_ARRAY.length));
        }
    }

    @Test()
    public void testAverage () throws InvalidDataException {
        float actual = calculation.average(testArray);
        float expected = 19.6f;
        assertEquals(actual,expected,0.1);
    }

    @Test()
    public void testSum () throws InvalidDataException {
        float actual = calculation.sum(testArray);
        int expected = 177;
        assertEquals(actual,expected);
    }

    @Test()
    public void testSumStream () throws InvalidDataException {
        float actual = calculationWithStream.sum(testArray);
        int expected = 177;
        assertEquals(actual,expected);
    }
}
