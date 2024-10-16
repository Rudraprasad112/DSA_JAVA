package PriorityQueue;
    import java.util.*;
public class LongesthappyString {

    public static void main(String[] args) {
        // A string s is called happy if it satisfies the following conditions:

        //     s only contains the letters 'a', 'b', and 'c'.
        // s does not contain any of "aaa", "bbb", or "ccc" as a substring.
        // s contains at most a occurrences of the letter 'a'.
        // s contains at most b occurrences of the letter 'b'.
        // s contains at most c occurrences of the letter 'c'.
        // Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

        int a = 1; int b = 1; int c = 7;

        //find the maximum lenght  of string tht satticefiey the condition


    }
    static class Pair{

        char ch; int count;

        public Pair(char c,int co){

            this.ch = c; this.count = co;

        }

    }
    public static  String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->y.count - x.count);

        if(a != 0) pq.add(new Pair('a',a));

        if(b != 0) pq.add(new Pair('b',b));

        if(c != 0) pq.add(new Pair('c',c));

        String ans = "";

        while(!pq.isEmpty()){

            Pair p = pq.remove();

            char ch = p.ch; int count = p.count;

            if(ans.length() >= 2 && ans .charAt(ans.length()-1) == ch && ans .charAt(ans.length()-2) == ch){

                
                if(pq.isEmpty()){// only one element in the pq and not add because 3consutative elements are not added

                    break;

                }
                Pair p2 = pq.remove();

                ans += p2.ch; p2.count--;

                pq.add(new Pair(ch,count));//for first pair

                if(p2.count > 0){

                    pq.add(new Pair(p2.ch,p2.count));

                }

            }else{// only one char added

                ans += ch; count--;

                if(count > 0){

                    pq.add(new Pair(ch,count));

                }

            }

        }

        return ans;
    }

}
