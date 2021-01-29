package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.IntStream;

public class CalculationWithStream {
    static Logger logger = LogManager.getLogger();

    public  int sum (ArrayObj array) throws InvalidDataException {
        logger.info("Entered sum function");
        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int[] initialArray = array.getArray();

        return IntStream.of(initialArray)
                .reduce((x,y)->x+y).getAsInt();
    }
}
