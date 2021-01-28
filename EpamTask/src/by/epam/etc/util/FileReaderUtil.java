package by.epam.etc.util;

import by.epam.etc.validator.DataValidator;
import by.epam.etc.exception.FileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderUtil {

    static Logger logger = LogManager.getLogger();

    public String read (String fileName) throws  FileException {
        String data = null;
        Scanner sc;
        File file = new File(FileReaderUtil.class.getClassLoader().getResource(fileName)
                .getPath());
        logger.info(file);
        try {
            sc = new Scanner(file);

        }catch (IOException e) {
            logger.error("File not found");
            throw new FileException("File not found");
        }
        while (sc.hasNextLine()) {
            data = sc.nextLine();
            logger.info("Read line {}", data);
            if (DataValidator.isStringValid(data)) {
                break;
            }
        }
        return data;
    }
}
