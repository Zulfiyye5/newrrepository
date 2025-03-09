package az.edu.turing.module2.university_management_system;

import java.util.Objects;

public class Professor  extends  Person{
    public String department;
    private int subjectCount=0;
    public String[] subjectArray ;
    public Professor(String name, int age,String id,String department) {
        super(name, age,id);
        this.department = department;
        subjectArray = new String[200];
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addSubject(String subject){
        subjectArray[subjectCount] = subject;
        subjectCount++;
    }
    public void displaySubjects(){
        for(int i=0;i<subjectCount;i++){
            System.out.println(subjectArray[i]);
        }
    }

    @Override
    public String toString() {
        return "Professor{" +
                "department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(department, professor.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }
}
