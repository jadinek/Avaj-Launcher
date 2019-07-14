class Aircraft{
    public Aircraft(String aName, Coordinates theCoordinates){
        name = aName;
        coordinates = theCoordinates;
        id = nextId();
    };
    public long nextId(){
        return ++idCounter;
    };
    
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected static long idCounter = 0;
    protected boolean unregistered = false;
}