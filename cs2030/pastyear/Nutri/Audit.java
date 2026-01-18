class Audit {
    private final int goodest;
    private final int good;
    private final int fair;
    private final int bad;
    
    Audit() {
        this.goodest = 0;
        this.good = 0;
        this.fair = 0;
        this.bad = 0;
    }

    Audit(int goodest, int good, int fair, int bad) {
        this.goodest = goodest;
        this.good = good;
        this.fair = fair;
        this.bad = bad;
    }
    
    public String toString() {
        return String.format("[(A, %d), (B, %d), (C, %d), (D, %d)]", 
                this.goodest, this.good, this.fair, this.bad);
    }

    public Audit add(Drink drink) {
        String letter = drink.value().grade();
        if (letter.equals("A")) {
            int newGoodest = this.goodest + 1;
            return new Audit(newGoodest, good, fair, bad);
        } else if (letter.equals("B")) {
            int newGood = this.good + 1;
            return new Audit(goodest, newGood, fair, bad);
        } else if (letter.equals("C")) {
            int newFair = this.fair + 1;
            return new Audit(goodest, good, newFair, bad);
        } else {
            int newBad = this.bad + 1;
            return new Audit(goodest, good, fair, newBad);
        }
    }
}
