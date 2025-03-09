package az.edu.turing.module2.university_management_system;

import java.util.Arrays;
import java.util.Objects;

public class Course {
    public  String courseCode;
    public String courseName;
    public Professor professor;
    public Student[] students;
    private  int studentCount=0;

    public  Course(String courseCode ,String courseName,Professor professor){
        this.courseCode= courseCode;
        this.courseName= courseName;
        this.professor = professor;
        students = new Student[2000];
    }
    public void addStudent(Student student){
        students[studentCount] = student;
        studentCount++;
    }
    public void displayStudents(){
        for(int i=0;i<studentCount;i++){
            System.out.println(students[i].toString());
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return studentCount == course.studentCount && Objects.equals(courseCode, course.courseCode) && Objects.equals(courseName, course.courseName) && Objects.equals(professor, course.professor) && Objects.deepEquals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseName, professor, Arrays.hashCode(students), studentCount);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", professor=" + professor +
                ", students=" + Arrays.toString(students) +
                ", studentCount=" + studentCount +
                '}';
    }
}
