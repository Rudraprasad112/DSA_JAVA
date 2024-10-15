package Twopointer;

public class SpritedBlackandRedballs {
    public static void main(String[] args) {
        // There are n balls on a table, each ball has a color black or white.
        // You are given a 0-indexed binary string s of length n, where 1 and 0 represent black and white balls, respectively.
        // 
        // In each step, you can choose two adjacent balls and swap them.
        // 
        // Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.

        String s = "1001";

        long ans = minimumSteps(s);
        
        System.out.println(ans);
    }
    public static  long minimumSteps(String s) {

        int count_one = 0;

        long res = 0;

        for(int i = 0 ; i < s.length(); i++){

            if(s.charAt(i) == '0'){

                res += count_one;

            }else{

                count_one++;

            }
        }

        return res;
    }
}
