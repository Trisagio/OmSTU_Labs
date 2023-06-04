package org.example;

public class PlanetsModel {
    private int id;
    private String name;
    private String planetNum;
    private String numOfMoons;
    private String diameter;
    private String distanceFromSun;

    public PlanetsModel(String name, String planetNum, String numOfMoons, String diameter, String distanceFromSun) {
        this.name = name;
        this.planetNum = planetNum;
        this.numOfMoons = numOfMoons;
        this.diameter = diameter;
        this.distanceFromSun = distanceFromSun;
    }

    public PlanetsModel() {
    }

    // Getters and setters
    public String getPlanetName() {
        return name;
    }

    public void setPlanetName(String nameParam) {
        this.name = nameParam;
    }

    public String getNumberOfPlanet() {
        return planetNum;
    }

    public void setNumberOfPlanet(String planetNumParam) {
        this.planetNum = planetNumParam;
    }

    public String getNumOfMoons() {
        return numOfMoons;
    }

    public void setNumOfMoons(String numOfMoonsParam) {
        this.numOfMoons = numOfMoonsParam;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameterParam) {
        this.diameter = diameterParam;
    }

    public String getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(String distanceFromSunParam) {
        this.distanceFromSun = distanceFromSunParam;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}