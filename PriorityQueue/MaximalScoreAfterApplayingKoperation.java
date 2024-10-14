package PriorityQueue;
import java.util.*;
/**
 * MaximalScoreAfterApplayingKoperation
 */
public class MaximalScoreAfterApplayingKoperation {

    public static void main(String[] args) {
        // You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.

        // In one operation:
        
        // choose an index i such that 0 <= i < nums.length,
        // increase your score by nums[i], and
        // replace nums[i] with ceil(nums[i] / 3).
        // Return the maximum possible score you can attain after applying exactly k operations.
        
        // The ceiling function ceil(val) is the least integer greater than or equal to val.
        
         
        
        // Example 1:
        
        // Input: nums = [10,10,10,10,10], k = 5
        // Output: 50
        // Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.

        int nums[] = {10,10,10,10,10}; int k = 5;

        long ans = maxKelements(nums, k);
        System.out.println(ans);
    }

    public static long maxKelements(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b - a);

        for(int ele:nums){ // n logn

            pq.add(ele);

        }
        
        long score = 0;

        while(k > 0){

            int re_ele = pq.peek();

            pq.remove();

            score += re_ele;

            pq.add((int)Math.ceil(re_ele/3.0));

            k--;

        }

        return score;
    }
}