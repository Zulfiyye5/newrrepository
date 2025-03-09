package az.edu.turing.module1.lesson07;

public class StringDemo {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(changeValue(s));
        System.out.println(s);

        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(changeValue(sb));
        System.out.println(sb);





    }
    public static  String changeValue(String s){
        return s.concat(" Universe");
    }
    public static  StringBuilder changeValue(StringBuilder sb){
        return new StringBuilder( sb).append(" Universe");
    }
}
