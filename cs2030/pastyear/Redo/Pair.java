class Pair<T,U> {
    private final T t;
    private final U u;

    Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    public T t() {
        return this.t;
    }

    public U u() {
        return this.u;
    }

    public String toString() {
        return this.t.toString() + "--" + this.u.toString();
    }
}
