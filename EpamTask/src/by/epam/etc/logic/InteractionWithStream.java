package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.IntStream;

public class InteractionWithStream {
    static Logger logger = LogManager.getLogger();

    public int min(ArrayObj array) throws InvalidDataException {
        logger.info("Entered min function");
        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int minValue = array.getElement(0);
        int[] initialArray = array.getArray();
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

    public  int max (ArrayObj array) throws InvalidDataException {
        logger.info("Entered max function");

        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }

        int minValue = array.getElement(0);
        int[] initialArray = array.getArray();
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

    public  int[] replacement (ArrayObj array, int position, int number) throws InvalidDataException {
        logger.info("Entered replacement function");
        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        array.setElement(position,number);
        return array.getArray();
    }

    public  int positiveCount(ArrayObj array) throws InvalidDataException {
        logger.info("Entered positive count function");
        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int[] initialArray = array.getArray();
        return (int) IntStream.of(initialArray).filter(x->x>=0).count();
    }

    public  int negativeCount(ArrayObj array) throws InvalidDataException {
        logger.info("Entered negative count function");

        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int[] initialArray = array.getArray();
        return (int) IntStream.of(initialArray).filter(x->x<0).count();
    }
}
