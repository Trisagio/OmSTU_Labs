package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlanetsViewer {
    private static final String FILE_PATH = "D:\\Documents\\ОмГТУ\\Остальное\\Объектно-ориентированное программирование\\4 семестр\\ЛР3\\LW3\\list.txt";

    public List<PlanetsModel> getAllPlanets() throws IOException {
        List<PlanetsModel> library = loadLibrary();

        if (library == null) {
            library = new ArrayList<>();
        }

        return library;
    }

    public void addPlanet(PlanetsModel planet) throws IOException {
        List<PlanetsModel> library = loadLibrary();
        library.add(planet);
        saveLibrary(library);
    }

    private List<PlanetsModel> loadLibrary() throws IOException {
        System.out.println("loadLibrary");
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        List<PlanetsModel> library = new Gson().fromJson(reader, new TypeToken<List<PlanetsModel>>(){}.getType());
        reader.close();

        if (library == null) {
            library = new ArrayList<>();
        }

        return library;
    }

    private void saveLibrary(List<PlanetsModel> library) throws IOException {
        System.out.println("saveLibrary");
        FileWriter writer = new FileWriter(FILE_PATH);
        new Gson().toJson(library, writer);
        writer.close();
    }
}
