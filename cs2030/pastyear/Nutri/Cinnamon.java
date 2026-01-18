class Cinnamon implements Drink{
    private final Drink drink;
    
    Cinnamon(Drink drink) {
        this.drink = drink;
    }

    public Nutri value() {
        return new Nutri(this.drink.value().nutrientList()).update("fat", 220).update("sugar", 150);
    }

    public String toString() { 
        return "cinnamon";
    }

    public String prep() {
        return this.drink.prep() + "<" + this.toString();
    }
}
