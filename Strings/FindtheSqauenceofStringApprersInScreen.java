package Strings;
import java.util.*;
public class FindtheSqauenceofStringApprersInScreen {
    public static void main(String[] args) {
        String target = "abc";

        List<String>ans = stringSequence(target);

        for(String s : ans){
            System.out.println(s);
        }
    }
    public static  List<String> stringSequence(String target) {
        
        List<String> ans = new ArrayList<>();

        int n = target.length(); StringBuilder temp = new StringBuilder("");

        for(int i = 0 ; i < n ; i++){

            char curr = target.charAt(i);

            temp.append("a");

            ans.add(temp.toString());

            if(curr == 'a') continue;

            for(char ch = 'b' ; ch <= curr; ch++){// 26

                temp = temp.deleteCharAt(temp.length() - 1);

                temp.append(ch);

                ans.add(temp.toString());

            }

        }

        return ans;
    }
}
