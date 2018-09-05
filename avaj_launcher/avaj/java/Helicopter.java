package avaj.java;

import avaj.java.*;
import java.io.*;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    protected Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        try
        {
            File file = new File("./simulation.txt");
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            switch(weather)
            {
                case "SUN":
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                    this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("Lets go kill some Nazi's\n");
                    break;
                case "SNOW":
                    this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("What a day to go to war. Hope the rotor doesn't freeze...\n");
                    break;
                case "FOG":
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("Damn, this fog... I hope there aren't any Nazi's flying around.\n");
                    break;
                case "RAIN":
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("There is no rain in the army... but the army in the rain...\n");
                    break;
            }
            if (this.coordinates.getHeight() == 0)
            {
                writer.append(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") landing.\n");
                weatherTower.unregister(this);
                writer.append(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") unregistered from weather tower.\n");
            }
            writer.close();
        }
        catch(Exception e)
        {
            System.out.println("Cannot log to file: ");
            System.out.println(e.getMessage());
        }
        
    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        this.announce();
    }
}
