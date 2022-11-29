package com.github.bibek77.dsa.dataStructures.hashing;

/**
 * @author bibek
 */
public class MainClass {
    public static void main(String[] args) {
        DirectChaining directChaining = new DirectChaining(15);
        directChaining.insertHashTable("The");
        directChaining.insertHashTable("Quick");
        directChaining.insertHashTable("Brown");
        directChaining.insertHashTable("Fox");
        directChaining.insertHashTable("Jumps");
        directChaining.insertHashTable("Over");
        directChaining.insertHashTable("The");
        directChaining.insertHashTable("Lazy");
        directChaining.insertHashTable("Dog");
        directChaining.displayHashTable();
        directChaining.searchHashTable("Lazy");
        directChaining.searchHashTable("The");
        directChaining.searchHashTable("Whassup");
        directChaining.deleteHashTable("The");
        directChaining.displayHashTable();

        System.out.println("\nImplementing Quadratic Probing");
        QuadraticProbing quadraticProbing = new QuadraticProbing(15);
        quadraticProbing.insertHashTable("The");
        quadraticProbing.insertHashTable("Quick");
        quadraticProbing.insertHashTable("Brown");
        quadraticProbing.insertHashTable("Fox");
        quadraticProbing.insertHashTable("Jumps");
        quadraticProbing.insertHashTable("Over");
        quadraticProbing.insertHashTable("The");
        quadraticProbing.insertHashTable("Lazy");
        quadraticProbing.insertHashTable("Dog");
        quadraticProbing.displayHashTable();
    }
}
