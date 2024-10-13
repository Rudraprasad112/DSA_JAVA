package PriorityQueue;
import java.util.*;
public class SmalestRangeconveringRange {
    public static void main(String[] args) {
        

        // You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
            
        // We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
            
            
            
        // Example 1:
            
        // Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
        // Output: [20,24]
        // Explanation: 
        // List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
        // List 2: [0, 9, 12, 20], 20 is in range [20,24].
        // List 3: [5, 18, 22, 30], 22 is in range [20,24].

        Scanner sc = new Scanner(System.in);
        List<List<Integer>> nums = new ArrayList<>();
        System.out.println("enter  the lengt of list");
        int size = sc.nextInt();

        for(int i = 0 ; i < size; i++){

            nums.add(new ArrayList<>());

            System.out.println("enter the innner listsize");
            int len = sc.nextInt();
            for(int j = 0 ; j < len ; j++){

                System.out.println("enter ele");

                nums.get(i).add(sc.nextInt());

            }
        }
        int ans []= smallestRange(nums);
        int as2[] = smallestRange2(nums);
        System.out.println(ans[0] + " "+ans[1]);

    }
    // using naive approach
    public static  int[] smallestRange(List<List<Integer>> nums) {
        
        int n = nums.size();

        int slot[] = new int[n]; // all index point to 0

        int res[] = {-1000000,1000000};

        while(true){

            int minEle = Integer.MAX_VALUE;

            int maxEle = Integer.MIN_VALUE;

            int minLatestIdx = 0;

            for(int i = 0 ; i < n ; i++){//traverse all list and find the smalest and largest element
            
                int List_idx = i;//store curr_list index

                int ele_idx = slot[i];//list index's element index

                int ele = nums.get(List_idx).get(ele_idx);

                if(ele < minEle){// that element is smalest element

                    minEle = ele;

                    minLatestIdx = List_idx;
                    
                }

                maxEle = Math.max(maxEle,ele);

            }

            //update res
            if(maxEle - minEle < res[1] - res[0]){

                res[0] = minEle; res[1] = maxEle;
            }

            //update nextele 

            int next_idx = slot[minLatestIdx] + 1;

            if(next_idx >= nums.get(minLatestIdx).size()){

                break;

            }

            slot[minLatestIdx] = next_idx;
        }

        return res;
    }

    // using PriorityQueue approach to reduce the time complexti to find the smalest element every time

   static  class Pair{

        int idx; int ele;

        public Pair(int idx,int ele){

            this.idx = idx; this.ele = ele;

        }
    }
    public static  int[] smallestRange2(List<List<Integer>> nums) {
        
        int n = nums.size();

        int slot[] = new int[n]; // all index point to 0

        int minEle = Integer.MAX_VALUE;

        int maxEle = Integer.MIN_VALUE;

        int minLatestIdx = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.ele - b.ele);

        for(int i = 0 ; i < n ; i++){//traverse all list and find the smalest and largest element
            
            pq.add(new Pair(i,nums.get(i).get(0)));

            maxEle = Math.max(maxEle,nums.get(i).get(0));

        }

        int res[] = {-1000000,1000000};

        while(true){

            Pair p = pq.remove();// min ele 

            minEle = p.ele; minLatestIdx = p.idx;

            //update res
            if(maxEle - minEle < res[1] - res[0]){

                res[0] = minEle; res[1] = maxEle;
            }

            //update nextele 

            int next_idx = slot[minLatestIdx] + 1;

            if(next_idx >= nums.get(minLatestIdx).size()){

                break;

            }

            pq.add(new Pair(minLatestIdx,nums.get(minLatestIdx).get(next_idx)));

            maxEle = Math.max(maxEle,nums.get(minLatestIdx).get(next_idx));

            slot[minLatestIdx] = next_idx;
        }

        return res;
    }
}
