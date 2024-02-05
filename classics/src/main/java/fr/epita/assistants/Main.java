package fr.epita.assistants;

import fr.epita.assistants.classics.Classics;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int expected = 120;
        if (Classics.factorial(n) != expected)
            System.err.println("Error factorial("+ n +") " +
                    "-> Actual: " + Classics.factorial(5) + " Expected: " + expected);
        n = 7;
        expected = 13;
        if (Classics.tribonacci(n) != expected)
            System.err.println("Error factorial("+ n +") " +
                    "-> Actual: " + Classics.tribonacci(n) + " Expected: " + expected);
    }
}
