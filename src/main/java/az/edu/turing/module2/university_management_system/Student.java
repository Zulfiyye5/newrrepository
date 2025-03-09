package az.edu.turing.module2.university_management_system;

import java.util.Objects;

public class Student extends Person{
    public String major;
    public Course[] courses;
    public  double[] grades;
    private  int courseCount=0;


    public Student(String name, int age, String id,String major) {
        super(name, age,id);
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
    public double calculateGPA(){
        double total=0;
        for(double grade:grades){
            total+= grade;
        }

        return  total/courseCount;

    }
    public double getGradeByCourseCode(String courseCode){

        for(int i=0;i<courseCount;i++){
            if(courses[i].courseCode.equals(courseCode)){
                return grades[i];
            }
        }
        return  0;
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
    public void enrollCourse(Course course){
        courses[courseCount] = course;
        grades[courseCount]=0;
        courseCount++;
    }
    public  void displayCourses(){
        for(int i=0;i<courseCount;i++){
            System.out.println(courses[i].toString());
        }
    }



}
