package by.epam.etc.logic;

import by.epam.etc.entity.ArrayObj;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Interaction {
    static Logger logger = LogManager.getLogger();

    public int min(ArrayObj arr){
        logger.info("Entered min function");
        int minValue = arr.getElement(0);
        for (int elem : arr.getArr()){
            if (elem < minValue){
                minValue = elem;
            }
        }
        return minValue;
    }

    public  int max (ArrayObj arr){
        logger.info("Entered max function");
        int maxValue = arr.getElement(0);
        for (int elem : arr.getArr()){
            if (elem > maxValue){
                maxValue = elem;
            }
        }
        return maxValue;
    }

    public  int[] replacement (ArrayObj arr, int position, int number){
        logger.info("Entered replacement function");
        arr.setElement(position,number);
        return arr.getArr();
    }

    public  float average (ArrayObj arr){
        logger.info("Entered average function");
        return (float)sum(arr)/arr.size();
    }

    public  int sum (ArrayObj arr){
        logger.info("Entered sum function");
        int sumValue = 0;
        for (int elem : arr.getArr()){
            sumValue += elem;
        }
        return sumValue;
    }

    public  int positiveCount(ArrayObj arr) {
        logger.info("Entered positive count function");
        int count = 0;
        for (int elem : arr.getArr()){
            if (elem >= 0){
                count++;
            }
        }
        return count;
    }

    public  int negativeCount(ArrayObj arr) {
        logger.info("Entered negative count function");
        int count = 0;
        for (int elem : arr.getArr()){
            if (elem < 0){
                count++;
            }
        }
        return count;
    }
}
