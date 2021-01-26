package by.epam.etc.util;

import by.epam.etc.validator.DataValidator;
import by.epam.etc.exception.FileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderUtil {
    static final String FILE_PATH = "./src/by/epam/etc/data/";
    static final String FILENAME = "ArrayData.txt";
    static Logger logger = LogManager.getLogger();

    private FileReader fileReader;
    private Scanner sc;
    private String data ;

    DataValidator dataValidator = new DataValidator();

    public String read () throws IOException, FileException {
        try {
            fileReader = new FileReader(FILE_PATH+FILENAME);
            sc = new Scanner(fileReader);
            while (sc.hasNextLine()) {
                data = sc.nextLine();
                logger.info("Read line {}", data);
                if (dataValidator.isStringValid(data)) {
                    break;
                }
            }
        } catch (IOException e) {
            logger.error("File not found");
            throw new FileException("File not found");
        } finally {
            if(fileReader!=null) {
                fileReader.close();
                sc.close();
            }
        }
        return data;
    }
}
