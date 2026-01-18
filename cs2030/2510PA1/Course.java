class Course {
    private final String courseCode;

    Course(String courseCode) {
        this.courseCode = courseCode;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } 
        if (object instanceof Course course) {
            return this.toString().equals(object.toString());
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "[" + courseCode.toString() + "]";
    }

}
