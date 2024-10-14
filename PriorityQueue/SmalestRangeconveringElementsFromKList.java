package PriorityQueue;
import java.util.*;
public class SmalestRangeconveringElementsFromKList {
    public static void main(String[] args) {
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

        int ans[] = smallestRange(nums);

        System.err.println(ans[0]+" "+ans[1]);
          
    }
    static class Pair{

        int idx; int ele;

        public Pair(int idx,int ele){

            this.idx = idx; this.ele = ele;

        }
    }
    public static  int[] smallestRange(List<List<Integer>> nums) {
        
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

            Pair p = pq.remove();// min ele //logn

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

    public static int[] smallestRange2(List<List<Integer>> nums) {
        
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

}
