package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Interaction {
    static Logger logger = LogManager.getLogger();

    public int min(ArrayObj array) throws InvalidDataException {
        logger.info("Entered min function");
        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int minValue = array.getElement(0);
        for (int element : array.getArray()){
            if (element < minValue){
                minValue = element;
            }
        }
        return minValue;
    }

    public  int max (ArrayObj array) throws InvalidDataException {
        logger.info("Entered max function");
        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int maxValue = array.getElement(0);
        for (int element : array.getArray()){
            if (element> maxValue){
                maxValue = element;
            }
        }
        return maxValue;
    }

    public  int[] replacement (ArrayObj arr, int position, int number) throws InvalidDataException {
        logger.info("Entered replacement function");
        if(DataValidator.isEmpty(arr)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        arr.setElement(position,number);
        return arr.getArray();
    }

    public  int positiveCount(ArrayObj array) throws InvalidDataException {
        logger.info("Entered positive count function");
        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int count = 0;
        for (int element : array.getArray()){
            if (element >= 0){
                count++;
            }
        }
        return count;
    }

    public  int negativeCount(ArrayObj array) throws InvalidDataException {
        logger.info("Entered negative count function");
        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int count = 0;
        for (int elem : array.getArray()){
            if (elem < 0){
                count++;
            }
        }
        return count;
    }
}
