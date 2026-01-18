import java.util.function.BiPredicate;

class SUend implements BiPredicate<CourseReq, CoursePlan> {

    public boolean test(CourseReq coursereq, CoursePlan courseplan) {
        //can't find a test that can work with knowledge of only 1 CourseReq itself
        //need BiPredicate
        
        //Test 1: the SUend CourseReq is not the prereq property of any CourseReq 
        //issue with Test 1: getter (a public method) for prereq cannot be used.
        
        //Test 2: create every possible combination of 1 dropped course, 
        //if reconstruction of a new CoursePlan with remaining courses yields courseplan with 
        //numOfCourses 1 less than that before the drop, 
        //the dropped course was the SUend CourseReq.
        int originalNum = courseplan.numOfCourses();
        return originalNum - courseplan.drop(coursereq).numOfCourses() != 1;
    }
}
