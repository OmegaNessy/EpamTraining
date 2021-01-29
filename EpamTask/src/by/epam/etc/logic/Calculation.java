package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculation {
    static Logger logger = LogManager.getLogger();

    public  float average (ArrayObj array) throws InvalidDataException {
        logger.info("Entered average function");
        return (float)sum(array)/array.size();
    }

    public  int sum (ArrayObj array) throws InvalidDataException {
        logger.info("Entered sum function");
        if(DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int sumValue = 0;
        for (int elememt : array.getArray()){
            sumValue += elememt;
        }
        return sumValue;
    }

}
