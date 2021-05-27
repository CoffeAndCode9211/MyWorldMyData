package com.main.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consume {

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);


        // new way to iterate internal iterator
        data.forEach(new Consumer<Integer>() {
            public void accept(Integer value) {
                System.out.println(value);
            }
        });
        data.forEach((Integer value) -> System.out.println(value));
        data.forEach(value -> System.out.println(value));
        data.forEach(System.out::println);


        // new way to read data
        System.out.println(data.stream().
                mapToInt(value -> value * 2)
                .sum());


        // double the first even number greater than 3

        //old way

        int result = 0;
        for (int e : data) {
            if (e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }
        System.out.println(result);


        // lets do this with declarative style
        System.out.println(
                data.stream().filter(value -> value > 3)
                        .filter(value -> value % 2 == 0)
                        .map(value -> value * 2)
                        .findFirst()
                        .orElse(0)
        );

        // using method // collection are lazy by stream
        System.out.println(
                data.stream().filter(Consume::isGreaterThan3)
                        .filter(Consume::isEven)
                        .map(Consume::doubleIt)
                        .findFirst()
                        .orElse(0)
        );


        List<String> tickers = Arrays.asList("ABC", "QWE", "ERT", "gsf", "rft");

        long start = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
        }

        long stop = System.nanoTime();

        System.out.println("Time taken(s)" + (stop - start) / 1.0e9);


    }


    public static boolean isEven(int number) {
        System.out.println("is even with " + number);
        return number % 2 == 0;
    }

    public static boolean isGreaterThan3(int number) {
        System.out.println("is greater than 3 " + number);
        return number > 3;
    }

    public static int doubleIt(int number) {
        System.out.println("double value " + number);
        return number * 2;
    }


    // new way to write interface with body
    public interface Fly {

        public default void sampleData() {
            System.out.println("Hello world");
        }

        ;


    }

}
