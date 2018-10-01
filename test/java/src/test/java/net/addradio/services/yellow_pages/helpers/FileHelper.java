package net.addradio.services.yellow_pages.helpers;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHelper {

    public static String readResource(String relativePath) throws IOException {
        URL resource = FileHelper.class.getResource(relativePath);

        if (resource == null) {
            throw new IOException("Resource file not found:" + relativePath);
        }

        Path path = Paths.get(resource.getPath());

        byte[] fileContent = Files.readAllBytes(path);
        return new String(fileContent, StandardCharsets.UTF_8);
    }

}
