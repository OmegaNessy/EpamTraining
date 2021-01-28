package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculation {
    static final String LOGGER_INPUT = "Initial array: {}";
    static final String LOGGER_OUTPUT = "Output array: {}";
    static final String LOGGER_ERROR = "Object is empty: {}";

    Logger logger = LogManager.getLogger();

    public  float average (ArrayObj arr) throws InvalidDataException {
        logger.info("Entered average function");
        return (float)sum(arr)/arr.size();
    }

    public  int sum (ArrayObj arr) throws InvalidDataException {
        logger.info("Entered sum function");
        if(DataValidator.isEmpty(arr)){
            logger.error(LOGGER_ERROR,ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int sumValue = 0;
        for (int elem : arr.getArr()){
            sumValue += elem;
        }
        return sumValue;
    }

}
