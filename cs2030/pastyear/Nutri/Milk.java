class Milk implements Drink {
    private final Drink drink;
    private final Nutri fat = new Nutri("fat", 2680);
    private final Nutri sugar = new Nutri("sugar", 4340);

    Milk(Drink drink) {
        this.drink = drink;
    }
    
    public Nutri value() {
        return new Nutri(drink.value().nutrientList())
                .update("fat", 2680)
                .update("sugar", 4340);
    }

    public String toString() {
        return "milk";
    }

    public String prep() {
        return this.toString() + ">" + this.drink.prep();
    }
}
