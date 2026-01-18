import java.util.List;

class Sugar implements Drink {
    private final Drink drink;
    private final Nutri sugar = new Nutri("sugar", 8000);
    
    Sugar(Drink drink) {
        this.drink = drink;
        
    }
    
    public Nutri value() {
        return new Nutri(drink.value().nutrientList()).update("sugar", 8000);
    }

    public String toString() {
        return "sugar";
    }
    
    public String prep() {
        return this.toString() + ">" + this.drink.prep();
    }
}
