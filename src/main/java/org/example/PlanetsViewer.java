package org.example;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetsViewer {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_lw";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public List<PlanetsModel> getAllPlanets() throws IOException {
        List<PlanetsModel> planetList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM planets")) {

            while (rs.next()) {
                PlanetsModel planet = new PlanetsModel();
                planet.setId(rs.getInt("id"));
                planet.setPlanetName(rs.getString("name"));
                planet.setNumberOfPlanet(rs.getString("planetNum"));
                planet.setNumOfMoons(rs.getString("numOfMoons"));
                planet.setDiameter(rs.getString("diameter"));
                planet.setDistanceFromSun(rs.getString("distanceFromSun"));
                planetList.add(planet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planetList;
    }

    public PlanetsModel getPlanetById(int planetId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM planets WHERE id = ?")) {
            stmt.setInt(1, planetId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                PlanetsModel planet = new PlanetsModel();
                planet.setId(rs.getInt("id"));
                planet.setPlanetName(rs.getString("name"));
                planet.setNumberOfPlanet(rs.getString("planetNum"));
                planet.setNumOfMoons(rs.getString("numOfMoons"));
                planet.setDiameter(rs.getString("diameter"));
                planet.setDistanceFromSun(rs.getString("distanceFromSun"));
                return planet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void addPlanet(PlanetsModel planet) throws IOException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            try (PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO planets (name, planetNum, numOfMoons, diameter, distanceFromSun) VALUES (?, ?, ?, ?, ?)")) {
                stmt.setString(1, planet.getPlanetName());
                stmt.setString(2, planet.getNumberOfPlanet());
                stmt.setString(3, planet.getNumOfMoons());
                stmt.setString(4, planet.getDiameter());
                stmt.setString(5, planet.getDistanceFromSun());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePlanet(PlanetsModel planet) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE planets SET name=?, planetNum=?, numOfMoons=?, diameter=?, distanceFromSun=? WHERE id=?")) {
            stmt.setString(1, planet.getPlanetName());
            stmt.setString(2, planet.getNumberOfPlanet());
            stmt.setString(3, planet.getNumOfMoons());
            stmt.setString(4, planet.getDiameter());
            stmt.setString(5, planet.getDistanceFromSun());
            stmt.setInt(6, planet.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePlanet(int planetId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM planets WHERE id=?")) {
            stmt.setInt(1, planetId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
