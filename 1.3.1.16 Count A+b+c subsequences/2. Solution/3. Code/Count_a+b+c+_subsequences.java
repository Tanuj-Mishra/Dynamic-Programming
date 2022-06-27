import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        int countA = 0;
        int countB = 0;
        int countC = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == 'a') {
                countA = 2*countA + 1;
            } else if (ch == 'b') {
                countB = 2*countB + countA;
            } else {
                countC = 2*countC + countB;
            }
        }

        System.out.println(countC);
    }
}