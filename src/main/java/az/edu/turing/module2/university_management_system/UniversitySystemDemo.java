package az.edu.turing.module2.university_management_system;

import java.util.Arrays;

public class UniversitySystemDemo {
    public static void main(String[] args) {
        University university = new University("UNI");
        Student student1 = new Student("Harry",19,"SOO1","CS");
        Student student2 = new Student("Ron",21,"SOO2","IT");
        Student student3 = new Student("Emma",20,"SOO3","Math");
        Professor professor1 = new Professor("Tom", 43, "TOO1", "Math");
        Professor professor2 = new Professor("Robert", 51, "TOO2", "CS");
        Course course1 = new Course("COO1","Linear algebra",professor1);
        Course course2 = new Course("COO2", "Data Structures", professor2);
        Course course3 = new Course("COO3", "Artificial Intelligence", professor2);
        professor1.addSubject("Algebra");
        professor2.addSubject("Machine Learning");
        professor1.addSubject("Physics");
        university.addCourse(course1);
        university.addCourse(course2);
        university.addCourse(course3);
        university.addPerson(student1);
        university.addPerson(student2);
        university.addPerson(student3);
        university.addPerson(professor1);
        university.addPerson(professor2);
       student1.enrollCourse(course1);
       student1.updateGrade(course1,95);
       student1.enrollCourse(course2);
        student2.enrollCourse(course1);
       student2.updateGrade(course1,100);
       course1.addStudent(student1);
       course1.addStudent(student2);
       course2.addStudent(student1);
        System.out.println("Course1 has "+course1.courseGPA()+" GPA");
        System.out.println("Student1 has "+student1.calculateGPA()+" GPA");
        System.out.println("Professor1 subjects: "+ Arrays.toString(professor1.getSubjectArray()));
        university.displayPeople();







    }
}
