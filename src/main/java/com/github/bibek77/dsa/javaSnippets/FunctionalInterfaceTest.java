package com.github.bibek77.dsa.javaSnippets;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author bibek
 */
public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        //Declarative Programming
        Supplier<String> supplier = String::new;
        System.out.println("Supplier Data : " + supplier.get());

        Function<String, String> function = String::new;
        System.out.println("Function Data : " + function.apply("Dummy"));

//        BiFunction<String, Integer, Map<String, Integer>> biFunction = HashMap::new;
//        System.out.println("BiFunction Data : " + biFunction.apply("Test Key", 25));

        Consumer<String> consumer = String::new;
        consumer.accept("Test consumer");



    }
}
