import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] coins = new int[size];
		for (int i = 0; i < size; i++)
			coins[i] = scn.nextInt();

		int target = scn.nextInt();

		coinChangePermutation(coins, target);
	}

	public static void coinChangePermutation(int[] coins, int target) {

		int size = target + 1;
		int[] dp = new int[size];
		dp[0] = 1;

		for (int amount = 0; amount < size; amount++) {
			for (int coin : coins) {
				if (coin <= amount) {
					dp[amount] += dp[amount - coin];
				}
			}
		}

		System.out.println(dp[size - 1]);
	}
}