class Baloon extends Aircraft implements Flyable{
    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    };
    public void updateConditions(){
        if(hasLanded == false){
        String weather = weatherTower.getWeather(coordinates);
        switch(weather){
            case "Sun":
                coordinates.setLongitude(2);
                coordinates.setHeight(4);
                System.out.println("Baloon#" + name + "(" + id + "): " + "Suns out, guns out.");
                break;
            case "Rain":
                coordinates.setHeight(-5);
                System.out.println("Baloon#" + name + "(" + id + "): " + "Rain of terror!");
                break;
            case "Fog":
                coordinates.setHeight(-3);
                System.out.println("Baloon#" + name + "(" + id + "): " + "I don't have the foggiest idea where I am!");
                break;
            case "Snow":
                coordinates.setHeight(-15);
                System.out.println("Baloon#" + name + "(" + id + "): " + "Let it Jon Snow.");
                break;
            default:
                break;
        }

        if (coordinates.getHeight()== 0){
            unregisterTower();
        }
    }
    };
    public void registerTower(WeatherTower weatherTower){};
    
    public void registerTower(){
        System.out.println("Tower says: Baloon#" + name + "(" + id + ") " + "registered to weather tower.");
    };

    public void unregisterTower(){
        System.out.println("Baloon#" + name + "(" + id + ") " + "landing.");
        System.out.println("Tower says: Baloon#" + name + "(" + id + ") " + "unregistered from weather tower.");
        System.out.println("Baloon#" + name + "(" + id + "): longitude: " + coordinates.getLongitude() + " latitude: " + coordinates.getLatitude() + " Height: " + coordinates.getHeight());
        hasLanded = true;
    };

    public void getWeatherTower(){
        System.out.println(this);
    }
    
    private WeatherTower weatherTower = new WeatherTower();
    boolean hasLanded = false;
}