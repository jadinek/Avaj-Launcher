class Coordinates{
    public Coordinates(int lon, int lat, int h){
        longitude = lon;
        latitude = lat;
        height = h;

    };
    public int getLongitude(){return longitude;};
    public int getLatitude(){return latitude;};
    public int getHeight(){return height;};
    public void setLongitude(int lon){
        longitude += lon;
    };
    public void setLatitude(int lat){
        latitude += lat;
    };
    public void setHeight(int h){
        height += h;
        if (height <= 0)
         height = 0;
        if (height >= 100)
            height = 100;
    };

    private int longitude;
    private int latitude;
    private int height;
}