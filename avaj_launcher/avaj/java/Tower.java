package avaj.java;

import java.util.*;
import java.io.*;
public class Tower
{
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable)
    {
        observers.add(flyable);
        String message = "Tower says: ";
        try
        {
            File file = new File("../simulation.txt");
            PrintWriter writer = new PrintWriter(file);
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
    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
        String message = "Tower says: ";
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
    protected void conditionChanged()
    {
        int i = this.observers.size();
        for (Flyable fly : observers)
        {
            fly.updateConditions();
            if (i  != this.observers.size())
                return ;
        }
    }
}
