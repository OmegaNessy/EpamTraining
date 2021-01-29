package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import by.epam.etc.exception.InvalidDataException;
import by.epam.etc.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class Sorting {
    static Logger logger = LogManager.getLogger();
    static final float FACTOR = 1.127f;

    public void bubbleSorting(ArrayObj array) throws InvalidDataException {
        logger.info("Initial array: {}", array);
        if (DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int[] mutableArray = array.getArray();
        int arrayLength = array.size();
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if (mutableArray[j] > mutableArray[j + 1]) {
                    int temp = mutableArray[j];
                    mutableArray[j] = mutableArray[j + 1];
                    mutableArray[j + 1] = temp;
                }
            }
        }
        array.setArray(mutableArray);

        if (logger.isDebugEnabled()) {
            logger.debug("Output array: {}", Arrays.toString(mutableArray));
        }
        //QUESTION: Стоит ли возвращать копию поля или работать с ним напрямую копируя ссылку на него
    }

    public void shakeSorting(ArrayObj array) throws InvalidDataException {
        logger.info("Initial array: {}", array);
        if (DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int[] mutableArray = array.getArray();
        int leftBoarder = 0;
        int rightBoarder = array.size();
        while (leftBoarder <= rightBoarder) {
            for (int i = leftBoarder; i < rightBoarder - 1; i++) {
                if (mutableArray[i] > mutableArray[i + 1]) {
                    int temp = mutableArray[i];
                    mutableArray[i] = mutableArray[i + 1];
                    mutableArray[i + 1] = temp;
                }
            }
            rightBoarder--;
            for (int i = rightBoarder - 1; i > leftBoarder; i--) {
                if (mutableArray[i] < mutableArray[i - 1]) {
                    int temp = mutableArray[i];
                    mutableArray[i] = mutableArray[i - 1];
                    mutableArray[i - 1] = temp;
                }
            }
            leftBoarder++;
        }
        array.setArray(mutableArray);
        if (logger.isDebugEnabled()) {
            logger.debug("Output array: {}", Arrays.toString(mutableArray));
        }
    }

    public void combSorting(ArrayObj array) throws InvalidDataException {
        logger.info("Initial array: {}", array);
        if (DataValidator.isEmpty(array)){
            logger.error("Object is empty: {}",ArrayObj.class.getSimpleName());
            throw new InvalidDataException("Object: "+ ArrayObj.class.getSimpleName() +" cant be empty");
        }
        int[] mutableArray = array.getArray();
        int arrayLength = array.size();
        float gapFactor = arrayLength / FACTOR;
        while (gapFactor > 1) {
            int gap = Math.round(gapFactor);
            for (int i = 0; i + gap < arrayLength; i++) {
                if (mutableArray[i] > mutableArray[i + gap]) {
                    int temp = mutableArray[i];
                    mutableArray[i] = mutableArray[i + gap];
                    mutableArray[i + gap] = temp;
                }
            }
            gapFactor /= FACTOR;
        }
        array.setArray(mutableArray);
        if (logger.isDebugEnabled()) {
            logger.debug("Output array: {}", Arrays.toString(mutableArray));
        }
    }
}
