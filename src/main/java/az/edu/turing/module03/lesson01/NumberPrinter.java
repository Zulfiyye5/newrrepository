package az.edu.turing.module03.lesson01;

public class NumberPrinter<T extends  Number> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public void print(){
        System.out.println(value);
    }
}
