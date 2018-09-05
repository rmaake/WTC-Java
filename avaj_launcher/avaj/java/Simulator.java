package avaj.java;

import java.io.*;
import avaj.*;

public class Simulator
{
    private static String[]    readFile(String path)
    {
        String content = "";
        try
        {
            FileReader file = new FileReader(path);
            BufferedReader buffer = new BufferedReader(file);
            String line;
            
            while((line = buffer.readLine()) != null)
            {
                content += line + "\n";
            }
            buffer.close();
            file.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return content.split("\n");
    }
    private static Boolean  validateLine(String[] lineContent)
    {
        String[] aircraftModels = {"JetPlane", "Baloon", "Helicopter"};
        try
        {
            if (lineContent.length != 5)
                return false;
            Integer.parseInt(lineContent[2]);
            Integer.parseInt(lineContent[3]);
            if (Integer.parseInt(lineContent[4]) < 0)
                return false;
            for (String var : aircraftModels)
            {
                if (lineContent[0].equals(var) == true)
                {
                    return true;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("File not validated: possible reason(s)");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return false;
    }
    private static Boolean  validateFile(String[] fileContent)
    {
        String[] lineContent;
        try
        {
            if (Integer.parseInt(fileContent[0]) <= 0)
            {
                System.out.println("Simulation number cannot be less or equal to zero.");
                return false;
            }
            for(int i = 1; i < fileContent.length; i++)
            {
                lineContent = fileContent[i].split(" ");
                if (validateLine(lineContent) == false)
                {
                    System.out.println("File is invalid: Inspect line " + (i + 1) + ".");
                    return false;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("File not validated: possible reason(s)");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return true;
    }
    private static void     simulate(String[] fileContent)
    {
        AircraftFactory factory = new AircraftFactory();
        Flyable fly;
        WeatherTower weatherTower = new WeatherTower();
        int nbr = Integer.parseInt(fileContent[0]);
        try
        {
            String[] line;
            File file = new File("./simulation.txt");
            if (file.exists() == true)
                file.delete();
            //file.close();
            for(int i = 1; i < fileContent.length; i++)
            {
                line = fileContent[i].split(" ");
                fly = factory.newAircraft(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                fly.registerTower(weatherTower);
            }
            for(int i = 0; i < nbr; i++)
            {
                weatherTower.changeWeather();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
       
    }
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Usage: java avaj/Simulator <scenario file>");
            return ;
        }
        String[] fileContent = readFile(args[0]);
        if (validateFile(fileContent) == false)
            System.exit(1);
        simulate(fileContent);
    }
}