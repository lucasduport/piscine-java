package fr.epita.assistants.classics;

public class Classics {
    /**
     * Computes the factorial of n.
     * @param n the nth value to compute, negative values should return -1
     *
     * @return the long value of n!
     */
    public static long factorial(int n) {
        long i = 1;
        for (int j = 1; j <= n; j++) {
            i*= j;
        }
        return i;
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
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++)
        {
            if (word.charAt(i) != word.charAt(word.length() - i - 1))
                return false;
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
            for (int k = i; k > 0 && (array[k-1] > array[k]); k++) {
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
