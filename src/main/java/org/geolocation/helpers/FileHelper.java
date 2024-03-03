package org.geolocation.helpers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileHelper.class);

    public static void cleanFile(String path) {
        write(path, "");
    }

    public static void write(String path, String val) {
        try (PrintWriter writer = new PrintWriter(path, StandardCharsets.UTF_8.toString())) {
            writer.print(val);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static boolean exists(Path path) {
        return path.toFile()
                .exists();
    }

    public static boolean exists(String path) {
        return exists(Paths.get(path));
    }
}
