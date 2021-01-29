package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingWithStream {
    static Logger logger = LogManager.getLogger();

    public void sortingWithStream(ArrayObj array) throws InvalidDataException {
        logger.info("Initial array: {}", array);
        if (DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int[] mutableArray = array.getArray();
        int[] result = IntStream.of(mutableArray).sorted().toArray();
        array.setArray(result);

        if (logger.isDebugEnabled()) {
            logger.debug("Output array: {}", Arrays.toString(mutableArray));
        }
    }
}
