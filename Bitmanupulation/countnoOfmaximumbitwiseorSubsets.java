package Bitmanupulation;

import java.util.Arrays;

public class countnoOfmaximumbitwiseorSubsets {
    public static void main(String[] args) {
                // 
                    // Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.
                // 
            // An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.
                // 
            // The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).
                // 
                // 
                // 
            // Example 1:
                // 
            // Input: nums = [3,1]
            // Output: 2
            // Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
            // - [3]
            // - [3,1]
            // Example 2:
                // 
            // Input: nums = [2,2,2]
            // Output: 7
            // Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.
            // Example 3:
                // 
            // Input: nums = [3,2,1,5]
            // Output: 6
            // Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
            // - [3,5]
            // - [3,1,5]
            // - [3,2,5]
            // - [3,2,1,5]
            // - [2,5]
            // - [2,1,5]
                // 
            int nums[] = {3,2,1,5};
        int ans = countMaxOrSubsets(nums);

        System.out.println(ans);
    }
    public static int countMaxOrSubsets(int[] nums) {
        
        int max_or = 0; int n = nums.length;

        for(int i = 0 ; i < nums.length; i++){

            int curr = nums[i];

            max_or = max_or | curr;
            
        }

        //find the subsets of or equalto max or
        int dp[][] = new int[n][max_or+1];

        for(int i = 0 ; i < n; i++){

            Arrays.fill(dp[i],-1);

        }

        return findSubsets(0,nums,0,max_or,dp);

    }

    public static int findSubsets(int idx,int nums[],int or,int max_or,int dp[][]){

        if(idx == nums.length){

            if(or == max_or){

                return 1;

            }
            return 0;
        }

        if(dp[idx][or] != -1){

            return dp[idx][or];

        }

        int take = findSubsets(idx+1,nums,or|nums[idx],max_or,dp);

        int skip = findSubsets(idx+1,nums,or,max_or,dp);

        return dp[idx][or] = take + skip;

    }
}
