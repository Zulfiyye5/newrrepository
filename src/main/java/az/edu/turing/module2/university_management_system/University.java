package az.edu.turing.module2.university_management_system;

import java.util.Arrays;

public class University {
    public String name;
    private Person[] people;
    private   Course[] courses;
    public   int personCount =0;
    public   int  courseCount=0;
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
        Person[] allpeople = new Person[personCount];
        for(int i=0;i<personCount;i++){
            allpeople[i] = people[i];
        }
        return allpeople;
    }

    public void setPeople(Person[] people) {
        this.people = people;
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

    public void  addPerson(Person person){
        if(!isPersonExist(person.id)){
            people[personCount] = person;
            personCount++;
        }
        else{
            System.out.println("Person " + person.name + " already exists!");
        }

    }
    public  void addCourse(Course course){
        if (!isCourseExist(course.courseCode)) {
                courses[courseCount] = course;
                courseCount++;

        } else {
            System.out.println("Course " + course.courseName + " already exists!");
        }
    }
    private boolean isCourseExist(String courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].courseCode.equals(courseCode)) {
                return true;
            }
        }
        return false;
    }
    private boolean isPersonExist(String personId) {
        for (int i = 0; i < personCount; i++) {
            if (people[i].id.equals(personId)) {
                return true;
            }
        }
        return false;
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
