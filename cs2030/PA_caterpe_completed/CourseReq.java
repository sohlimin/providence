class CourseReq extends Course implements Prereq {
    private final Maybe<Prereq> prereq; 
    
    CourseReq(String courseCode) {
        super(courseCode);
        prereq = Maybe.empty();
    }

    CourseReq(String courseCode, Prereq prereq) {
        super(courseCode);
        this.prereq = Maybe.of(prereq);
    }

    public boolean satisfiedBy(InfList<Course> courses) {
        return courses.anyMatch(x -> x.equals(this)) && 
             prereq.map(x -> x.satisfiedBy(courses)).orElse(true);
    

    }

    public String toString() {
        return super.toString();
    }


}
