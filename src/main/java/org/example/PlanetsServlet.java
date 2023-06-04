package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "PlanetsServlet", value = "/planets")
public class PlanetsServlet extends HttpServlet {
    private static final String FILE_PATH = "D:\\Documents\\ОмГТУ\\Остальное\\Объектно-ориентированное программирование\\4 семестр\\ЛР2\\LW2\\list.txt";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\ndoGet_Start");
        List<Planets> library = loadLibrary();
        System.out.println("doGet_Work");
        String json = new Gson().toJson(library);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        System.out.println("doGet_End");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\ndoPost_Start");
        String name = request.getParameter("name");
        String planetNum = request.getParameter("planetNum");
        String numOfMoons = request.getParameter("numOfMoons");
        String diameter = request.getParameter("diameter");
        String distanceFromSun = request.getParameter("distanceFromSun");

        Planets newPlanet = new Planets(name, planetNum, numOfMoons, diameter, distanceFromSun);
        List<Planets> library = loadLibrary();
        System.out.println("doPost_Work");
        library.add(newPlanet);
        saveLibrary(library);
        System.out.println("doPost_End");
    }

    private List<Planets> loadLibrary() throws IOException {
        System.out.println("loadLibrary");
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        List<Planets> library = new Gson().fromJson(reader, new TypeToken<List<Planets>>(){}.getType());
        reader.close();

        if (library == null) {
            library = new ArrayList<>();
        }

        return library;
    }

    private void saveLibrary(List<Planets> library) throws IOException {
        System.out.println("saveLibrary");
        FileWriter writer = new FileWriter(FILE_PATH);
        new Gson().toJson(library, writer);
        writer.close();
    }
}
