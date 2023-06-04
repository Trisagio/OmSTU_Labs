package org.example;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/planets/*")
public class PlanetsController extends HttpServlet {
    private PlanetsViewer planetViewer;

    @Override
    public void init() throws ServletException {
        planetViewer = new PlanetsViewer();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            List<PlanetsModel> planetList = planetViewer.getAllPlanets();
            String json = new Gson().toJson(planetList);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } else {
            int planetId = Integer.parseInt(request.getPathInfo().substring(1));
            PlanetsModel planet = planetViewer.getPlanetById(planetId);
            if (planet != null) {
                String json = new Gson().toJson(planet);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String planetNum = request.getParameter("planetNum");
        String numOfMoons = request.getParameter("numOfMoons");
        String diameter = request.getParameter("diameter");
        String distanceFromSun = request.getParameter("distanceFromSun");

        PlanetsModel planet = new PlanetsModel();
        planet.setPlanetName(name);
        planet.setNumberOfPlanet(planetNum);
        planet.setNumOfMoons(numOfMoons);
        planet.setDiameter(diameter);
        planet.setDistanceFromSun(distanceFromSun);

        PlanetsViewer.addPlanet(planet);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int planetId = Integer.parseInt(request.getPathInfo().substring(1));
        PlanetsModel planet = planetViewer.getPlanetById(planetId);
        if (planet != null) {
            String name = request.getParameter("name");
            String planetNum = request.getParameter("planetNum");
            String numOfMoons = request.getParameter("numOfMoons");
            String diameter = request.getParameter("diameter");
            String distanceFromSun = request.getParameter("distanceFromSun");

            planet.setPlanetName(name);
            planet.setNumberOfPlanet(planetNum);
            planet.setNumOfMoons(numOfMoons);
            planet.setDiameter(diameter);
            planet.setDistanceFromSun(distanceFromSun);

            planetViewer.updatePlanet(planet);

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int planetId = Integer.parseInt(request.getPathInfo().substring(1));
        PlanetsModel planet = planetViewer.getPlanetById(planetId);
        if (planet != null) {
            planetViewer.deletePlanet(planetId);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
