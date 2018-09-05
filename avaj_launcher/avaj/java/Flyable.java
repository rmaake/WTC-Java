package avaj.java;

import avaj.java.WeatherTower;

interface Flyable
{
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}