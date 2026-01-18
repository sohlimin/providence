class Cream implements Drink{
    private final Drink drink;

    Cream(Drink drink) {
        this.drink = drink;
    }

    public Nutri value() {
        return new Nutri(this.drink.value().nutrientList()).update("fat", 10000).update("sugar", 2000);
    }

    public String toString() {
        return "cream";
    }

     public String prep() {
         return this.drink.prep() + "<" + this.toString();
     }
}
