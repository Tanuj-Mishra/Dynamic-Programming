import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int length = scn.nextInt();

        int oldZero = 1;
        int oldOne = 1;

        for (int i = 2; i <= length; i++) {
            int newZero = oldOne;
            int newOne = oldZero + oldOne;

            oldZero = newZero;
            oldOne = newOne;
        }

        System.out.println(oldZero + oldOne);
    }

}