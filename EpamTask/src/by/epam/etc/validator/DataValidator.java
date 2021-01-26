package by.epam.etc.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataValidator {
    static Logger logger = LogManager.getLogger();

    public boolean isStringValid(String data) {
        boolean response = true;
        String[] dataArr = data.split(" ");
        try {
            for (String element : dataArr) {
                Integer.parseInt(element);
            }
        } catch (NumberFormatException e) {
            logger.info("String is not valid");
            response = false;
        }
        return response;
    }
}

