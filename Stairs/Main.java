package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int s=5;
        System.out.println("Number of ways = " + countWays(s));
        //System.out.println("Number of ways old = " + noOfSteps(s));

    }
    static int countWaysUtil(int n)
    {

        if (n == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i<=3 && i<=n; i++){
           // System.out.println(n + " - " + i +" = " + (n-i));
           res += countWaysUtil(n - i);

        }

        return res;
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s)
    {
        return countWaysUtil(s+1);
    }

}
