package com.github.bibek77.dsa.javaSnippets;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author bibek
 */
public class StreamsNumeric {
    public static void main(String[] args) {

        //Numeric Ranges
        IntStream intStream = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(intStream.count());

        int a = 5;
        //Pythagorean triples
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                .boxed()
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});
        // boxed changes int to Integer to be used for IntStream
        // Instead we can use mapToObject against map for the same thing
        pythagoreanTriples.forEach(item -> System.out.println(item[0] + " " + item[1] + " " + item[2]));

        // We can also generate the value of a in the stream itself
        Stream<int[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(x ->
                        IntStream.rangeClosed(x, 100)
                                .filter(y -> Math.sqrt(x * x + y * y) % 1 == 0)
                                .mapToObj(y -> new int[]{x, y, (int) Math.sqrt(x * x + y * y)})
                );
        pythagoreanTriples2.forEach(item -> System.out.println(item[0] + " " + item[1] + " " + item[2]));

        //Optimised way - calculating sqrt once
        Stream<double[]> pythagoreanTriples3 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(x ->
                        IntStream.rangeClosed(x, 100)
                                .mapToObj(y -> new double[]{x, y, Math.sqrt(x * x + y * y)})
                                .filter(t -> t[2] % 1 == 0)
                );
        pythagoreanTriples3.forEach(item -> System.out.println(item[0] + " " + item[1] + " " + item[2]));
    }
}
