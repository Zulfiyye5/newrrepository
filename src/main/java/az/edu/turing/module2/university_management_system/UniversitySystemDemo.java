package az.edu.turing.module2.university_management_system;

import java.util.Arrays;

public class UniversitySystemDemo {
    public static void main(String[] args) {
        Student student = new Student("Harry",19,"SOO1","Math");
        Professor professor = new Professor("Snape",40,"TOO1","CS");
        Professor professor2 = new Professor("Lily",35,"TOO2","Math");
        professor2.addSubject("ajsbd");
        Course course = new Course("C001","Introductiont to JAVA",professor);
        University university =new University("Hogwarts");
        Course course2 = new Course("COO2","Circuit Teory",professor2);
        university.addCourse(course);
        university.addCourse(course2);
        student.enrollCourse(course);
        student.enrollCourse(course2);
        student.updateGrade(course,100);
        student.updateGrade(course2,80);
        course2.addStudent(student);
        course.addStudent(student);
        course.displayStudents();



    }
}
