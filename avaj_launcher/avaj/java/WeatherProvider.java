package avaj.java;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private WeatherProvider()
    {
        return ;
    }
    public static WeatherProvider getProvider()
    {
        return weatherProvider;
    }
    public static String getCurrentWeather(Coordinates coordinates)
    {
        int i = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        i = i % 4;
        return weather[i];
    }

}