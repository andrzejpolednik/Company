package company;

public class WrongCourseSelection extends Exception {
    int courseNumber;

    public WrongCourseSelection(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String toString() {
        return "Error: Choose the right course";
    }

}
