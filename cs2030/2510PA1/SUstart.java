import java.util.function.BiPredicate;

class SUstart implements BiPredicate<CourseReq, CoursePlan> {
    
    public boolean test(CourseReq coursereq, CoursePlan courseplan) {
        //can be satisfied by itself (OLD WAY with Predicate<CourseReq>)
        //return !coursereq.satisfiedBy(InfList.of(coursereq)); 
        
        //if permutation of remaining CourseReqs after dropping...
        //...yields a new CoursePlan with 0 numOfCourses,
        //then dropped CourseReq was the SUstart CourseReq  
        return courseplan.drop(coursereq).numOfCourses() != 0;    
    }
}
