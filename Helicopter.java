class Helicopter extends Aircraft implements Flyable{
    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    };

    public void updateConditions(){
        if(hasLanded == false){
        String weather = weatherTower.getWeather(coordinates);
        switch(weather){
            case "Sun":
                coordinates.setLongitude(10);
                coordinates.setHeight(10);
                System.out.println("Helicopter#" + name + "(" + id + "): " + "Suns out, guns out.");
                break;
            case "Rain":
                coordinates.setLongitude(5);
                System.out.println("Helicopter#" + name + "(" + id + "): " + "Rain of terror!");
                break;
            case "Fog":
                coordinates.setLongitude(1);
                System.out.println("Helicopter#" + name + "(" + id + "): " + "I don't have the foggiest idea where I am!");
                break;
            case "Snow":
                coordinates.setHeight(-12);
                System.out.println("Helicopter#" + name + "(" + id + "): " + "Let it Jon Snow.");
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
        System.out.println("Tower says: Helicopter#" + name + "(" + id + ") " + "registered to weather tower.");
    };
    public void unregisterTower(){
        System.out.println("Helicopter#" + name + "(" + id + ") " + "landing.");
        System.out.println("Tower says: Helicopter#" + name + "(" + id + ") " + "unregistered from weather tower.");
        System.out.println("Helicopter#" + name + "(" + id + "): longitude: " + coordinates.getLongitude() + " latitude: " + coordinates.getLatitude() + " Height: " + coordinates.getHeight());
        hasLanded = true;
    };
    private WeatherTower weatherTower = new WeatherTower();
    boolean hasLanded = false;
}