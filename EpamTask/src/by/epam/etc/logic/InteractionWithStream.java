package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.IntStream;

public class InteractionWithStream {
    static final String LOGGER_INPUT = "Initial array: {}";
    static final String LOGGER_OUTPUT = "Output array: {}";
    static final String LOGGER_ERROR = "Object is empty: {}";
    static Logger logger = LogManager.getLogger();

    public int min(ArrayObj arr) throws InvalidDataException {
        logger.info("Entered min function");
        if(DataValidator.isEmpty(arr)){
            logger.error(LOGGER_ERROR,ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int minValue = arr.getElement(0);
        int[] initialArray = arr.getArr();
        IntStream intStream = IntStream.of(initialArray);
        return intStream.reduce(minValue,
                               (x,y)-> {
                                   if (y < x) {
                                       return y;
                                   } else
                                       return x;
                               });
        //SolarLint tip
    }

    public  int max (ArrayObj arr) throws InvalidDataException {
        logger.info("Entered max function");

        if(DataValidator.isEmpty(arr)){
            logger.error(LOGGER_ERROR,ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }

        int minValue = arr.getElement(0);
        int[] initialArray = arr.getArr();
        IntStream intStream = IntStream.of(initialArray);
        return intStream.reduce(minValue,
                (x,y)-> {
                    if (y > x) {
                        return y;
                    } else
                        return x;
                });
        //SolarLint tip
    }

    public  int[] replacement (ArrayObj arr, int position, int number) throws InvalidDataException {
        logger.info("Entered replacement function");
        if(DataValidator.isEmpty(arr)){
            logger.error(LOGGER_ERROR,ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        arr.setElement(position,number);
        return arr.getArr();
    }

    public  int positiveCount(ArrayObj arr) throws InvalidDataException {
        logger.info("Entered positive count function");
        if(DataValidator.isEmpty(arr)){
            logger.error(LOGGER_ERROR,ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int[] initialArray = arr.getArr();
        IntStream intStream = IntStream.of(initialArray);
        return (int) intStream.filter(x->x>=0).count();
    }

    public  int negativeCount(ArrayObj arr) throws InvalidDataException {
        logger.info("Entered negative count function");

        if(DataValidator.isEmpty(arr)){
            logger.error(LOGGER_ERROR,ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int[] initialArray = arr.getArr();
        IntStream intStream = IntStream.of(initialArray);
        return (int) intStream.filter(x->x<0).count();
    }
}
