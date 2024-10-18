package Bitmanupulation;

public class Maximumswap {
    public static void main(String[] args) {
        // You are given an integer num. You can swap two digits at most once to get the maximum valued number.

        // Return the maximum valued number you can get.
            // 
            // 
            // 
        // Example 1:
            // 
        // Input: num = 2736
        // Output: 7236
        // Explanation: Swap the number 2 and the number 7.

        int num = 1993;

        int ans = maximumSwap(num);
        
        System.out.println(ans);

    }

    public static int maximumSwap(int num) {

        char s[] = Integer.toString(num).toCharArray();

        int n = s.length;

        for(int i = 0 ; i < n; i++){

            int idx = i;

            for(int j = n - 1; j > i ; j--){

                if(s[idx] < s[j]){

                    idx = j;

                }

            }

            if(idx != i && s[idx] > s[i]){

                char temp = s[i];

                s[i] = s[idx];

                s[idx] = temp;

                break;
            }
        }

        return Integer.parseInt(new String(s));
    }
}
