package labs.LW6.servlet;

import java.io.*;

public class TextFormatter {
    public static String formatText(String fileName) throws IOException {
        String result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = null, indent = "   ";
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            line = sb.toString().trim().replaceAll("\\n", indent);
            sb = new StringBuilder();
            int length = line.length();
            for (int i = 0; i < length; i += 80) {
                int endIndex = Math.min(i + 80, length);
                String substring = line.substring(i, endIndex);

                sb.append(substring).append("\n");
            }
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void writeToFile(String fileName, String text) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)){
            writer.write(text);
        }
    }
}
