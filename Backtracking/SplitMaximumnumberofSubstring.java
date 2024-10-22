package Backtracking;

import java.util.HashSet;
import java.util.Set;

public class SplitMaximumnumberofSubstring {
    public static void main(String[] args) {
        String s = "ababccc";
        int ans = maxUniqueSplit(s);
        System.out.println(ans);
    }
     static int max_len;

    public static  int maxUniqueSplit(String s) {
        
        Set<String> set = new HashSet<>();

        max_len = 0;

        solve(0,s,set,0);

        return max_len;

    }
    public static void solve(int i ,String s ,Set<String> set,int curr){

        if(curr + (s.length() - i) <= max_len){

            return;
        }

        if(i >= s.length() ){

            max_len = Math.max(max_len,curr);

            return ;
        }

        for(int j = i+1; j <= s.length(); j++){

            String sub = s.substring(i,j);

            if(!set.contains(sub)){

                set.add(sub);

                solve(j,s,set,curr+1);
                
                set.remove(sub);

            }
        }
    }
}
