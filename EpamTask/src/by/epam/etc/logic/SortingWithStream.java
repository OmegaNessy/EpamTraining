package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingWithStream {
    static final String LOGGER_INPUT = "Initial array: {}";
    static final String LOGGER_OUTPUT = "Output array: {}";
    static final String LOGGER_ERROR = "Object is empty: {}";
    static Logger logger = LogManager.getLogger();
    static final float FACTOR = 1.127f;

    public void sortingWithStream(ArrayObj arr) throws InvalidDataException {
        logger.info(LOGGER_INPUT, arr);
        if (DataValidator.isEmpty(arr)){
            logger.error(LOGGER_ERROR,ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int[] mutableArray = arr.getArr();
        int[] result = IntStream.of(mutableArray).sorted().toArray();
        arr.setArr(result);

        if (logger.isDebugEnabled()) {
            logger.debug(LOGGER_OUTPUT, Arrays.toString(mutableArray));
        }
    }
}
