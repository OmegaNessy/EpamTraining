package by.epam.etc.validator;

import by.epam.etc.entity.ArrayObj;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class DataValidator {
    static Logger logger = LogManager.getLogger();
    final static String REGEXP= " ";

    private DataValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isStringValid(String data) {
        boolean response = true;
        String[] dataArray = data.split(REGEXP);
        try {
            for (String element : dataArray) {
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
        String[] dataArray = data.split(" ");
        try {
            Arrays.stream(dataArray).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            logger.info("String is not valid. Input string: \"{}\"", data);
            response = false;
        }
        return response;
    }
    public static boolean isEmpty(ArrayObj array){
        return array==null||array.getArray()==null||array.size()==0;
    }
}

