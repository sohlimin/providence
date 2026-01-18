import java.util.function.BiPredicate;

class CoursePlan {
    
    private final InfList<CourseReq> courseplan;
    
    CoursePlan(InfList<CourseReq> coursereqs) {
        InfList<Course> courses = coursereqs.<Course>map(x -> x); 
        courseplan = coursereqs.filter(x -> x.satisfiedBy(courses));
    }

    public CoursePlan drop(CourseReq droppedCourse) {
        return new CoursePlan(courseplan.filter(x -> !x.equals(droppedCourse)));
    }

    public int numOfCourses() {
        return courseplan.map(x -> 1).reduce(0, (x,y) -> x + y);
    }

    public InfList<Course> trimSU(BiPredicate<CourseReq,CoursePlan> bipred) {
        return courseplan.filter(x -> bipred.test(x,this)).<Course>map(x -> x);
    }

    public String toString() {
        String plan = courseplan
            .map(x -> x.toString())
            .reduce("", (x,y) -> x + y);

        if (plan.equals("")) {
            return "no courses";
        } else {
            return plan;
        }
    }

}
