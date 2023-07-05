package Backtracking;

import java.util.List;

// You are given coins of denominations and an amount. Write a function to compute the fewest number of coins
// that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
public class MinCoinsChange {
    public static  int coinChange(List<Integer> coins, int amount){
        int result = minCoinsChange(coins, amount, 0);
        return result == Integer.MAX_VALUE ? -1 : result;

    }

    private static int minCoinsChange(List<Integer> coins, int amount, int sum) {
        if(sum == amount) return 0;
        if(sum > amount) return Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int coin : coins){
            int result = minCoinsChange(coins, amount, sum + coin);
            if(result == Integer.MAX_VALUE){
                continue;
            }
            ans = Math.min(ans, result);
        }
        return ans;
    }
}
