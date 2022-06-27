import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int include = arr[0];
        int exclude = 0;

        for (int i = 1; i < size; i++) {
            int tempInclude = exclude + arr[i];
            int tempExclude = Math.max(include, exclude);

            include = tempInclude;
            exclude = tempExclude;
        }

        System.out.println(Math.max(include, exclude));
    }
}