public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        if (longitude < 0 || latitude < 0 || height <= 0)
            type = "abc";
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        switch(type){
            case "Baloon":
                return new Baloon(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            case "Helicopter":
                return new Helicopter(name, coordinates);
            default:
                return null;
        }
    }

}