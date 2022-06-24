import java.util.Scanner;

class Fibonacci {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();

        System.out.println(fibonacciRecursion(number));

        System.out.println(fibonacciMemorisation(number, new int[number + 1]));

    }

    // Returns fibonacci of a number, uses recursion
    public static int fibonacciRecursion(int number) {

        // Base Case
        if (number == 0 || number == 1) {
            return number;
        }

        // Recursive Work
        int smallAns1 = fibonacciRecursion(number - 1);
        int smallAns2 = fibonacciRecursion(number - 2);

        // Self Work
        return smallAns1 + smallAns2;
    }

    // Returns fibonacci of a number, uses dp- memorixation
    public static int fibonacciMemorisation(int number, int[] solutionBank) {

        // Base Case
        if (number == 0 || number == 1) {
            return number;
        }

        // Self Work-1
        if (solutionBank[number] != 0) {
            return solutionBank[number];
        }

        // Recursive Work
        // System.out.println("Hello " + number); -> it is used to count number of state
        int smallAns1 = fibonacciMemorisation(number - 1, solutionBank);
        int smallAns2 = fibonacciMemorisation(number - 2, solutionBank);

        // Self Work
        int ans = smallAns1 + smallAns2;
        solutionBank[number] = ans;
        return ans;
    }

}