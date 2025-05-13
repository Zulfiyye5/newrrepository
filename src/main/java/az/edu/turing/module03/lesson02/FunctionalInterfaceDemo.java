package az.edu.turing.module03.lesson02;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {
    static Supplier<String> stringSupplier =()->"Hello World";
    static Predicate<String> isBiggerThan3 = (s)->s.length()>3;
    static Predicate<String> startsWithH = (s)->s.startsWith("H");
    static Predicate<String> longAndStartsWIthH = isBiggerThan3.and(startsWithH);
    static Consumer<String> consumer = (s)->{
        System.out.println("Hello, " + s + "!");

    };
//    A Function<T, R> is a functional interface that:
//
//    Takes an input of type T
//
//    Returns a result of type R
    static Function<String,Integer> getLength = (s)->s.length();

    public static void main(String[] args) {

        System.out.println(isBiggerThan3.test("Harry"));
        System.out.println(isBiggerThan3.test("Ron"));
        System.out.println(longAndStartsWIthH.test("Harry"));
        consumer.accept("Hermione");


        Optional<String> nickname = Optional.empty();

        String result = nickname.orElseGet(() -> "Guest");  // Supplier used here

        System.out.println(result);  // Output: Guest




        ;


    }
}
