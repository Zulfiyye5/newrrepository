package az.edu.turing.module03.lesson05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = s->s.startsWith("J");
        List<String> names = Arrays.asList("John", "Jane", "Jack","Mary","Jane");

        List<String> filtered = names.stream()
                .filter(predicate)
                .map(String::toUpperCase)
                .toList();
        System.out.println(filtered);
        boolean b = names.stream().anyMatch(predicate);
        System.out.println(b);
        boolean b1 = names.stream().allMatch(predicate);
        System.out.println(b1);
        boolean b2 = names.stream().noneMatch(s->s.startsWith("Z"));
        System.out.println(b2);

        String reduce = names.stream().reduce("", (x, y) -> x + y);
        System.out.println(reduce);

        List<Integer> numbers= Arrays.asList(1,2,3,4);
        Integer reduce1 = numbers.stream().reduce(0, (n, m) -> n + m);
        System.out.println(reduce1);



    }
}
