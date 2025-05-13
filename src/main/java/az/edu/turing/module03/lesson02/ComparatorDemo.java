package az.edu.turing.module03.lesson02;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
  static Comparator<Car> comparatorByYearAsc = new Comparator<Car>() {
      @Override
      public int compare(Car o1, Car o2) {
         return o1.year-o2.year;
      }
  };
  static Comparator<Car> comparatorByYearAsc2 =(c1,c2)-> c1.year-c2.year;
    static Comparator<Car> comparatorByYearAsc3 =Comparator.comparingInt(c->c.year);

    static Comparator<Car> comparatorByYearAsc4 =Comparator.comparingInt(Car::getYear);

    static Comparator<Car> comparatorByYearDesc = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o2.year-o1.year;
        }
    };
    static Comparator<Car> comparatorByYearDesc2 = (c1,c2)->c2.year-c1.year;


    static Comparator<Car> comparatorByModelAsc1 = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getModel().compareTo(o2.getModel());
        }
    };
    static Comparator<Car> comparatorByModelAsc2 = (c1,c2)-> c1.model.compareTo(c2.model);
    static Comparator<Car> comparatorByModelAsc3 = Comparator.comparing(c->c.model);
    static Comparator<Car> comparatorByModelAsc4 = Comparator.comparing(Car::getModel);


    public static void main(String[] args) {
        Car[] cars = new Car[]{
                new Car("Honda",2019),
                new Car("BMW",2024),
                new Car("Tesla",2022)
        };

    }
}
