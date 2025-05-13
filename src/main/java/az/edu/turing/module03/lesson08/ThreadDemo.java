package az.edu.turing.module03.lesson08;

import java.util.concurrent.Callable;

public class ThreadDemo
{
    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("This is runnable, "+
                Thread.currentThread().getName());

        new Thread(runnable).start();
        Callable<String> callable =()->"Hello world";



    }

}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread is running..."+Thread.currentThread().getName());
    }
}