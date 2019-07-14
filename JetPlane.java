class JetPlane extends Aircraft implements Flyable{
    public JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    };
    public void updateConditions(){
        if(hasLanded == false){
            String weather = weatherTower.getWeather(coordinates);
            switch(weather){
                case "Sun":
                    coordinates.setLatitude(10);
                    coordinates.setHeight(2);
                    System.out.println("JetPlane" + name + "(" + id + "): " + "Suns out, guns out.");
                    break;
                case "Rain":
                    coordinates.setLatitude(5);
                    System.out.println("JetPlane" + name + "(" + id + "): " + "Rain of terror!");
                    break;
                case "Fog":
                    coordinates.setLatitude(1);
                    System.out.println("JetPlane" + name + "(" + id + "): " + "I don't have the foggiest idea where I am!");
                    break;
                case "Snow":
                    coordinates.setHeight(-7);
                    System.out.println("JetPlane" + name + "(" + id + "): " + "Let it Jon Snow.");
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
        System.out.println("Tower says: JetPlane#" + name + "(" + id + ") " + "registered to weather tower.");
    };
    public void unregisterTower(){
        System.out.println("JetPlane#" + name + "(" + id + ") " + "landing.");
        System.out.println("Tower says: JetPlane#" + name + "(" + id + ") " + "unregistered from weather tower.");
        System.out.println("JetPlane#" + name + "(" + id + "): longitude: " + coordinates.getLongitude() + " latitude: " + coordinates.getLatitude() + " Height: " + coordinates.getHeight());
        hasLanded = true;
    };
    
    private WeatherTower weatherTower = new WeatherTower();
    boolean hasLanded = false;
}