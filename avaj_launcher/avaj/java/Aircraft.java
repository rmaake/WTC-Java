package avaj.java;

import avaj.java.*;
import java.io.*;

public class Aircraft
{
    protected  long id;
    protected  String name;
    protected  Coordinates coordinates;
    private static long idCounter = 0;
    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId();
    }  
    private long nextId()
    {
        return ++idCounter;
    }
    public void announce()
    {
        String message = this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n";
        try
        {
            File file = new File("./simulation.txt");
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            writer.append(message);
            writer.close();
        }
        catch(Exception e)
        {
            System.out.print("Failed to log to file: ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}