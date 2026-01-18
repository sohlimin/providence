class AllOf implements Prereq {
    private final InfList<Prereq> prereqs;
    
    AllOf(InfList<Prereq> prereqs) {
        this.prereqs = prereqs;
    }
    
    public boolean satisfiedBy(InfList<Course> courses) {
        return prereqs
            .allMatch(x -> x.satisfiedBy(courses));
    }

}
