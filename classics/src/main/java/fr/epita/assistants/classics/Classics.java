package fr.epita.assistants.classics;

import java.util.Arrays;

public class Classics {
    /**
     * Computes the factorial of n.
     *
     * @param n the nth value to compute, negative values should return -1
     * @return the long value of n!
     */
    public static long factorial(int n) {
        if (n < 0)
            return -1;
        long i = 1;
        for (int j = 1; j <= n; j++) {
            i *= j;
        }
        return i;
    }

    private static long tribo(int n, long[] values) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        if (values[n] != -1)
            return values[n];
        values[n] = tribo(n-1, values) + tribo(n-2,values) + tribo(n-3,values);
        return values[n];
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n)
    {
        if (n < 0)
            return -1;
        long[] value = new long[n+1];
        for (int i = 0; i < n+1; i++) {
            value[i]= -1;
        }
        return tribo(n,value);
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        if (word == null)
            return false;
        if (word.length() == 0)
            return true;
        int i = 0;
        int j = word.length() - 1;
        for (; i != j && i < word.length() && j >= 0;)
        {
            if (word.charAt(i) == ' ')
            {
                i++;
                continue;
            }
            if (word.charAt(j) == ' ')
            {
                j--;
                continue;
            }
            if (word.toLowerCase().charAt(i)!= word.toLowerCase().charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     */
    public static void insertionSort(int[] array)
    {
        for (int i = 1; i < array.length; i++) {
            for (int k = i; k > 0 && (array[k-1] > array[k]); k--) {
                var tmp = array[k];
                array[k] = array[k-1];
                array[k-1] = tmp;
            }
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length())
        {
            if (((i + j) % 2) == 0)
            {
                sb.append(a.charAt(i));
                i++;
            }
            else
            {
                sb.append(b.charAt(j));
                j++;
            }
        }
        while (i < a.length())
        {
            sb.append(a.charAt(i));
            i++;
        }
        while (j < b.length())
        {
            sb.append(b.charAt(j));
            j++;
        }
        return sb.toString();
    }
}
