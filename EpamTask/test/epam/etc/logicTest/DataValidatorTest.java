package epam.etc.logicTest;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.validator.DataValidator;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class DataValidatorTest {
    @Test
    public void testIsStringValid(){
        String testString = "1 3 5 3 6 -2 -43 1 2";
        assertTrue(DataValidator.isStringValid(testString));
    }
    @Test
    public void testIsStringValidWithStream(){
        String testString = "1 3 5 3 6 -2 -43 1 2";
        assertTrue(DataValidator.isStringValidWithStream(testString));
    }
    @Test
    public void testIsEmpty(){
        int[] testArray = {1,3,5,3};
        ArrayObj arr = new ArrayObj(testArray);
        assertFalse(DataValidator.isEmpty(arr));
    }
}
