package logicTest;

import logic.Interaction;
import entity.ArrayObj;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class InteractionTest {
    Interaction interaction = new Interaction();
    ArrayObj testArray = new ArrayObj();
    @BeforeClass
    public void setUp (){
        testArray.setArr(new int[]{0, -3, 66, -7, 3, 23, 76, -23, -15});
    }
    @Test()
    public void testMin (){
        int actual = interaction.min(testArray);
        int expected = -23;
        assertEquals(actual,expected);
    }
    @Test()
    public void testMax (){
        int actual = interaction.max(testArray);
        int expected = 76;
        assertEquals(actual,expected);
    }
    @Test()
    public void testReplacement (){
        int[] actual = interaction.replacement(testArray,2,25);
        int[] expected = {0,-3,25,-7,3,23,76,-23,-15};
        assertEquals(actual,expected);
    }
    @Test()
    public void testAverage (){
        float actual = interaction.average(testArray);
        float expected = 13.3f;
        assertEquals(actual,expected,0.1);
    }
    @Test()
    public void testSum (){
        int actual = interaction.sum(testArray);
        int expected = 79;
        assertEquals(actual,expected);
    }
    @Test()
    public void testPositiveCount (){
        int actual = interaction.positiveCount(testArray);
        int expected = 5;
        assertEquals(actual,expected);
    }
    @Test()
    public void testNegativeCount (){
        int actual = interaction.negativeCount(testArray);
        int expected = 4;
        assertEquals(actual,expected);
    }

}
