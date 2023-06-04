package org.example;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
@WebServlet(name = "PlanetsServlet", value = "/planets")
public class PlanetsController extends HttpServlet {
    private PlanetsViewer planetViewer;

    @Override
    public void init() throws ServletException {
        planetViewer = new PlanetsViewer();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\ndoGet_Start");
        List<PlanetsModel> library = planetViewer.getAllPlanets();
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

        PlanetsModel newPlanet = new PlanetsModel(name, planetNum, numOfMoons, diameter, distanceFromSun);
        System.out.println("doPost_Work");
        planetViewer.addPlanet(newPlanet);
        response.setStatus(HttpServletResponse.SC_OK);
        System.out.println("doPost_End");
    }

}
