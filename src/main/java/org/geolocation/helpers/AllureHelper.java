package org.geolocation.helpers;

import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

import static java.lang.System.getProperty;
import static java.nio.file.Files.*;
import static org.geolocation.helpers.FileHelper.cleanFile;

public class AllureHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllureHelper.class);

    @Attachment(value = "{0}")
    public static byte[] attachString(String val) {
        return val.getBytes();
    }

    @Attachment(value = "{1}", type = "text/log", fileExtension = "log")
    public static byte[] attachLogFile(String filePath, String attachmentName) {
        return readBytesFromFile(attachmentName, filePath);
    }

    public static void createAllureEnv(Map<String, String> map) {
        Path pathAllureResultsDir = Paths.get(getProperty("user.dir") + "/build/" + "allure-results");
        Path envFilePath = Path.of(pathAllureResultsDir + "/environment.properties");
        try {
            if (!exists(pathAllureResultsDir)) {
                createDirectories(pathAllureResultsDir);
            }
            if (!exists(envFilePath)) {
                createFile(envFilePath);
            } else {
                cleanFile(envFilePath.toString());
            }
            try (OutputStream output = new FileOutputStream(envFilePath.toFile())) {
                Properties p = new Properties();
                map.forEach(p::setProperty);
                p.store(output, null);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static byte[] readBytesFromFile(String attachmentName, String filePath) {
        try {
            return Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return attachString(attachmentName);
        }
    }
}
