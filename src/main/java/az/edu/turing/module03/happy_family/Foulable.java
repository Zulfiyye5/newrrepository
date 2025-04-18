package az.edu.turing.module03.happy_family;

public interface Foulable {
    default void foul(){
        System.out.println("I need to cover it up");
    };
}
