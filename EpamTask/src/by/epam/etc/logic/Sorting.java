package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Sorting {
    static final String LOGGER_INPUT = "Initial array: {}";
    static final String LOGGER_OUTPUT = "Output array: {}";
    static Logger logger = LogManager.getLogger();
    static final float FACTOR = 1.127f;

    public int[] bubbleSorting(ArrayObj arr) {
        logger.info(LOGGER_INPUT, arr);
        int[] mutableArray = arr.getArr();
        int arrLength = arr.size();
        for (int i = 0; i < arrLength - 1; i++) {
            for (int j = 0; j < arrLength - 1 - i; j++) {
                if (mutableArray[j] > mutableArray[j + 1]) {
                    int temp = mutableArray[j];
                    mutableArray[j] = mutableArray[j + 1];
                    mutableArray[j + 1] = temp;
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug(LOGGER_OUTPUT, Arrays.toString(mutableArray));
        }
        return mutableArray;
        //QUESTION: Стоит ли возвращать копию поля или работать с ним напрямую копируя ссылку на него
    }

    public int[] shakeSorting(ArrayObj arr) {
        logger.info(LOGGER_INPUT, arr);
        int[] mutableArray = arr.getArr();
        int leftBoarder = 0;
        int rightBoarder = arr.size();
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
        if (logger.isDebugEnabled()) {
            logger.debug(LOGGER_OUTPUT, Arrays.toString(mutableArray));
        }
        return mutableArray;
    }

    public int[] combSorting(ArrayObj arr) {
        logger.info(LOGGER_INPUT, arr);
        int[] mutableArray = arr.getArr();
        int arrLength = arr.size();
        float gapFactor = arrLength / FACTOR;
        while (gapFactor > 1) {
            int gap = Math.round(gapFactor);
            for (int i = 0; i + gap < arrLength; i++) {
                if (mutableArray[i] > mutableArray[i + gap]) {
                    int temp = mutableArray[i];
                    mutableArray[i] = mutableArray[i + gap];
                    mutableArray[i + gap] = temp;
                }
            }
            gapFactor /= FACTOR;
        }
        if (logger.isDebugEnabled()) {
            logger.debug(LOGGER_OUTPUT, Arrays.toString(mutableArray));
        }
        return mutableArray;
    }
}
