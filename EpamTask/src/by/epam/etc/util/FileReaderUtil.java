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
        if (fileName==null){
            throw new FileException("Filename cant be null");
        }        
        if (fileName.isEmpty()){
            throw new FileException("Filename is Empty");
        }
        String data = null;
        Scanner scanner = null;
        File file = new File(fileName);
        logger.info(file);
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
                logger.info("Reading line {}", data);
                if (DataValidator.isStringValid(data)) {
                    break;
                }
            }
        }catch (IOException e) {
            logger.error("File not found: {}", fileName);
            throw new FileException("File not found");
        }finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return data;
    }
}
