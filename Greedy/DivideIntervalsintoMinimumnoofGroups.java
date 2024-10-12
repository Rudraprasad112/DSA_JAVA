
package Greedy;

import java.util.*;
public class DivideIntervalsintoMinimumnoofGroups {
    public static void main(String[] args) {
        // You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].

        // You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.
        
        // Return the minimum number of groups you need to make.
        
        // Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.


        // example :-Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
        // Output: 3
        // Explanation: We can divide the intervals into the following groups:
        // - Group 1: [1, 5], [6, 8].
        // - Group 2: [2, 3], [5, 10].
        // - Group 3: [1, 10].
        // It can be proven that it is not possible to divide the intervals into fewer than 3 groups.

        int interval[][] = {{5,10},{6,8},{1,5},{2,3},{1,10}};

        System.out.println(minGroups(interval));

    }
    public static  int minGroups(int[][] intervals) {
        
        int n = intervals.length;

        int start[] = new int[n];

        int end[] = new int [n]; int i = 0;

        for(int arr[]:intervals){

            start[i] = arr[0];

            end[i] = arr[1];

            i++;

        }

        Arrays.sort(start);

        Arrays.sort(end);

        int end_idx = 0; int group = 0;

        for(i = 0 ; i < n ; i++){

            if(start[i] > end[end_idx]){// same group

                end_idx++;

            }else{// overlap intervals diff group

                group++;

            }
        }

        return group;
    }

}
