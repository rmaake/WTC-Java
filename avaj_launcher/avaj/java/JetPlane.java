package avaj.java;

import avaj.java.*;
import java.io.*;
public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    protected JetPlane(String name, Coordinates coordinates)
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
                    this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                    this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("Its a good day to take a vacation... (could use a beer...), if only..\n");
                    break;
                case "SNOW":
                    this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("May-Day May-Day... We loosing altitude... experiencing engine failure...\n");
                    break;
                case "FOG":
                    this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("We passing above one of the most beautifull countries... sadly there is a fog..\n");
                    break;
                case "RAIN":
                    this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                    writer.append(this.getClass().getSimpleName() + "#" + "(" + this.id + "): ");
                    writer.append("In an unfortunate turn of events... for those going to Hauwii, its raining outside..\n");
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

        }
        
    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        this.announce();
    }
}