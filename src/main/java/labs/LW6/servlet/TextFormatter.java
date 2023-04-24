package labs.servlet.LW6;

import java.io.*;

public class TextFormatter {

    public static String formatText(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        String indent = "   ";
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                // Удаляем начальные и конечные пробелы
                line = line.trim();
                // Добавляем отступы
                line = indent + line;
                // Разбиваем строку на подстроки длиной 80 символов
                while (line.length() > 80) {
                    int index = line.lastIndexOf(" ", 80);
                    sb.append(line.substring(0, index)).append("\n");
                    line = indent + line.substring(index + 1);
                }
                sb.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            sb.append("File not found: ").append(fileName);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return sb.toString();
    }

    public static void writeToFile(String fileName, String text) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(text);
        writer.close();
    }
}
