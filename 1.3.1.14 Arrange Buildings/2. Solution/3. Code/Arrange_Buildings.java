import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws Exception {
	// write your code here
		Scanner scn = new Scanner(System.in);
		long length = scn.nextInt();

        long oldZero = 1;
        long oldOne = 1;

		for(long i = 2; i <= length; i++) {
            long newZero = oldOne;
            long newOne = oldZero + oldOne;

            oldZero = newZero;
            oldOne = newOne;

		}

        long ans = oldOne + oldZero;           
        ans *= ans;
		System.out.println(ans);
	}

}