class Tea implements Drink {
    private final Nutri value;
    
    Tea() {
        this.value = new Nutri("caffeine", 50);
    }

    public Nutri value() {
        return this.value; 
    }

    public String toString() {
        return "tea";
    }

    public String prep() {
        return "[" + this.toString() + "]";
    }
}
