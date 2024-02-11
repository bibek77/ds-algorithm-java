package com.github.bibek77.dsa.javaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author bibek
 */
public class StreamsTest {
    public static void main(String[] args) {
        // 1. List of squares
        List<Integer> list = Arrays.asList(2, 4, 7, 9, 12, 30, 15);
        List<Integer> listSquares = list.stream().map(n -> n * n).toList();
        listSquares.forEach(System.out::println);
        System.out.println();

        // 2. List of Pairs
        List<Integer> l1 = Arrays.asList(2, 4, 6, 8);
        List<Integer> l2 = Arrays.asList(8, 9, 10);
        List<int[]> pairList = l1.stream().flatMap(i -> l2.stream().map(j -> new int[]{i, j})).toList();
        pairList.forEach(e -> System.out.println(e[0] + " " + e[1]));
        System.out.println();

        // 3. Divisible by 3 Pairs
        List<int[]> pairListDivisible = l1.stream()
                .flatMap(i -> l2.stream()
                        .filter(j -> i + j % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .toList();
        pairListDivisible.forEach(e -> System.out.println(e[0] + " " + e[1]));

        // Reduce Operation
        int sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        int product = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);
        int max = list.stream().reduce(0, Integer::max);
        Optional<Integer> maxOpt = list.stream().reduce((x, y) -> x > y ? x : y);
        // identity is not used only if return is optional
        // as in empty stream there will be no return element
        // Integer class has max , min, sum operations which can be used as alternate
        System.out.println(max + " " + maxOpt.get());

        // Counting the elements in stream
        long count = list.stream().count();
        int count2 = list.stream().map(e -> 1).reduce(0, Integer::sum);
        System.out.println(count + " " + count2);

        int[] arr = {1, 1, 0};
        boolean neighbourXor = Arrays.stream(arr).sum() % 2 == 0;
        System.out.println(neighbourXor);
        // there must be even sum of all 1 bit, so we can use adjacent xor

        // String Stream
        List<String> words = Arrays.asList("Hello", "Stream", "World");
        List<String> uniqueChars = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
        // flatmap flattens the [] to "", then its easier to perform distinct and other ops
        uniqueChars.forEach(System.out::println);

        final String SENTENCE =
                " Nel   mezzo del cammin  di nostra  vita " +
                        "mi  ritrovai in una  selva oscura" +
                        " ché la  dritta via era   smarrita ";
        Stream<Character> streamSentence = IntStream.rangeClosed(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
    }
}
