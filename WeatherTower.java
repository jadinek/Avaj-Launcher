class WeatherTower extends Tower{
    public void changeWeather(){};
    public String getWeather(Coordinates coordinates){
        return getCurrentWeather(coordinates);
    };
    public String getCurrentWeather(Coordinates coordinates){
        int min = 0;
        int max = 3;

        int x = (int)(Math.random()*((max-min)+1)) + min;
        return weather[x];
    };

    private String weather[] = {"Rain", "Fog", "Sun", "Snow"};
}