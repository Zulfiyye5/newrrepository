package az.edu.turing.module2.university_management_system;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person {
    public String major;
    public Course[] courses;
    public double[] grades;
    private int courseCount = 0;
   

    public Student(String name, int age, String id, String major) {
        super(name, age, id);
        this.major = major;
        courses = new Course[100];
        grades = new double[100];

    }

    public void updateGrade(Course course, double grade) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equals(course)) {
                grades[i] = grade;
                return;
            }
        }
        System.out.println("Student  is not enrolled in this course.");

    }

    public void updateGrade(String courseCode, double grade) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].courseCode.equals(courseCode)) {
                grades[i] = grade;
                return;
            }
        }
        System.out.println("Student is not enrolled in this course");
    }


    public double calculateGPA() {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }

        return total / courseCount;

    }

    public double getGradeByCourseCode(String courseCode) {

        for (int i = 0; i < courseCount; i++) {
            if (courses[i].courseCode.equals(courseCode)) {
                return grades[i];
            }
        }
        return 0;
    }
    public void enrollCourse(Course course) {
        if (isCourseEnrolled(course.courseCode)) {
            System.out.println("Student is already enrolled in " + course.courseCode);
            return;
        }

            courses[courseCount] = course;
            grades[courseCount] = 0;
            courseCount++;

    }

    private boolean isCourseEnrolled(String courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].courseCode.equals(courseCode)) {
                return true;
            }
        }
        return false;
    }


    public void displayCourses() {
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString());
        }
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(major, student.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), major);
    }


    public Course[] getCourses() {
        Course[] allCourses = new Course[courseCount];
        for(int i=0;i<courseCount;i++){
            allCourses[i] = courses[i];
        }
        return allCourses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public double[] getGrades() {
        double[] allGrades= new double[courseCount];
        for(int i=0;i<courseCount;i++){
            allGrades[i] = grades[i];
        }
        return allGrades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "major='" + major + '\'' +
                ", courses=" + Arrays.toString(this.getCourses()) +
                ", grades=" + Arrays.toString(this.getGrades()) +
                ", courseCount=" + courseCount +
                ", name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                '}';
    }
}
