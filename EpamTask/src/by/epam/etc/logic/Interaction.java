package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Interaction {
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
        for (int elem : arr.getArr()){
            if (elem < minValue){
                minValue = elem;
            }
        }
        return minValue;
    }

    public  int max (ArrayObj arr) throws InvalidDataException {
        logger.info("Entered max function");
        if(DataValidator.isEmpty(arr)){
            logger.error(LOGGER_ERROR,ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int maxValue = arr.getElement(0);
        for (int elem : arr.getArr()){
            if (elem > maxValue){
                maxValue = elem;
            }
        }
        return maxValue;
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
        int count = 0;
        for (int elem : arr.getArr()){
            if (elem >= 0){
                count++;
            }
        }
        return count;
    }

    public  int negativeCount(ArrayObj arr) throws InvalidDataException {
        logger.info("Entered negative count function");
        if(DataValidator.isEmpty(arr)){
            logger.error(LOGGER_ERROR,ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int count = 0;
        for (int elem : arr.getArr()){
            if (elem < 0){
                count++;
            }
        }
        return count;
    }
}
