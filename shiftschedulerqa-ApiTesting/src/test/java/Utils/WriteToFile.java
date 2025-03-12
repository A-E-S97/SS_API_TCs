package Utils;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile
{
    public static void writeFile(String filePath, String content, boolean append) {
        try (FileWriter writer = new FileWriter(filePath, append)) { writer.write(content); }
        catch (IOException e) { e.printStackTrace(); }
    }
}
