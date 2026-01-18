class OneOf implements Prereq {
    private final InfList<Prereq> prereqs;
    
    OneOf(InfList<Prereq> prereqs) {
        this.prereqs = prereqs;
    }

    public boolean satisfiedBy(InfList<Course> courses) {
        return this.prereqs
            .anyMatch(x -> x.satisfiedBy(courses));
    }
    
}
