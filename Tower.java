class Tower{
    public boolean register(){
        if (isRegistered == false){
            isRegistered = true;
            return true;
        }
        else
        return false;
    };
    public void register(Flyable flyable){};
    public void unregister(Flyable flyable){};
    public void conditionsChanged(){};

    private boolean isRegistered = false;
}