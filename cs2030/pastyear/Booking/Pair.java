class Pair<T, U> {
    private final T t;
    private final U u;

    Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    T t() {
        return t;
    }

    U u() {
        return u;
    }

    @Override 
    public String toString() {
        return t.toString() + "--" + u.toString();
    }
}
