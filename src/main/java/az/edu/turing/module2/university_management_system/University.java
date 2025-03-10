package az.edu.turing.module2.university_management_system;

import java.util.Arrays;

public class University {
    public String name;
    public Person[] people;
    public  Course[] courses;
    private  int personCount =0;
    private  int  courseCount=0;
    public  University(String name){
        this.name = name;
        people = new Person[10000];
        courses = new Course[5000];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person[] getPeople() {
         return  Arrays.copyOf(people,personCount);
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }

    public Course[] getCourses() {
       return  Arrays.copyOf(courses,courseCount);
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public void  addPerson(Person person){
         people[personCount] = person;
         personCount++;
    }
    public  void addCourse(Course course){
        courses[courseCount] = course;
        courseCount++;
    }
    public  void  displayPeople(){
        for (int i=0;i<personCount;i++){
            System.out.println(people[i].toString());
        }
    }
    public  void displayCourses(){
        for (int i=0;i<courseCount;i++){
            System.out.println(courses[i].toString());
        }
    }
    public Person searchPersonById(String personId) {
        for (Person person : people) {
            if (person.getId().equals(personId)) {
                return person;
            }
        }
        return null;
    }
    public Course searchCourseByCourseCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", people=" + Arrays.toString(this.getPeople()) +
                ", courses=" + Arrays.toString(this.getCourses()) +
                ", personCount=" + personCount +
                ", courseCount=" + courseCount +
                '}';
    }
}
