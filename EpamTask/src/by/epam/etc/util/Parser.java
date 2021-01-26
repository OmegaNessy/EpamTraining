package by.epam.etc.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Parser {
    static Logger logger = LogManager.getLogger();
    public int[] fromStringToIntArray(String data) {
            String[] dataArray = data.split(" ");
            int size = dataArray.length;
            int[] result = new int[size];
            for (int i = 0; i < size; i++) {
                result[i] = Integer.parseInt(dataArray[i]);
            }
        return result;
    }
}
