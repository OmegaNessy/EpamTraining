package by.epam.etc.validator;

import by.epam.etc.entity.ArrayObj;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class DataValidator {
    static Logger logger = LogManager.getLogger();

    private DataValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isStringValid(String data) {
        boolean response = true;
        String[] dataArr = data.split(" ");
        try {
            for (String element : dataArr) {
                Integer.parseInt(element);
            }
        } catch (NumberFormatException e) {
            logger.info("String is not valid. Input string: \"{}\"", data);
            response = false;
        }
        return response;
    }
    public static boolean isStringValidWithStream(String data) {
        boolean response = true;
        String[] dataArr = data.split(" ");
        try {
            logger.info(Arrays.stream(dataArr).mapToInt(Integer::parseInt).toArray());
        } catch (NumberFormatException e) {
            logger.info("String is not valid. Input string: \"{}\"", data);
            response = false;
        }
        return response;
    }
    public static boolean isEmpty(ArrayObj arr){
        return arr==null||arr.getArr()==null||arr.size()==0;
    }
}

