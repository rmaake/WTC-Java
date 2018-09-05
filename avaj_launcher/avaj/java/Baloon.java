package avaj.java;

import avaj.*;
import java.io.*;
public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    protected Baloon(String name, Coordinates coordinates)
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
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                    this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("Quite a beautifull day it is... let's enjoy the view.\n");
                    break;
                case "SNOW":
                    this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("Oh no we gonna freeze to death.\n");
                    break;
                case "FOG":
                    this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("What a sad day to go air balooning.\n");
                    break;
                case "RAIN":
                    this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("This rain is ruining the day :-(\n");
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
            System.out.print("Failed to log to file: ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        this.announce();
    }
}