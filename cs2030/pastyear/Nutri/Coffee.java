class Coffee implements Drink {
    private final Nutri value;
    
    Coffee() {
        this.value = new Nutri("caffeine", 100);
    }

    public Nutri value() {
        return this.value; 
    }

    public String toString() {
        return "coffee";
    }

    public String prep() {
        return "[" + this.toString() + "]";    
    }
}
