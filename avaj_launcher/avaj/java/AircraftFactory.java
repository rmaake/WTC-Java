package avaj.java;

import avaj.*;
import java.lang.*;

public class AircraftFactory
{
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception
    {
        if (height  > 100)
            height = 100;
        Coordinates coor = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "JetPlane":
                return new JetPlane(name, coor);
            case "Baloon":
                return new Baloon(name, coor);
            case "Helicopter":
                return new Helicopter(name, coor);
            default:
                throw new Exception("Invalid aircraft type :-(\n");
        }
        //return null;
    }
}